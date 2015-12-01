package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.statistiques.vo.ClazzMostPlayedVO;
import fr.synapsegaming.statistiques.vo.RaceMostPlayedVO;
import fr.synapsegaming.statistiques.vo.SpecMostPlayedVO;
import fr.synapsegaming.statistiques.vo.UserMostActiveVO;
import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.dao.SpecializationDao;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

@Service("StatistiquesService")
public class StatistiquesServiceImpl<T> implements StatistiquesService {

	@Autowired
	private RaceDao raceDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ClazzDao clazzDao;
	@Autowired
	private SpecializationDao specDao;
	@Autowired
	private ForumReplyDao forumReplyDao;
	
	@Override
	public List<RaceMostPlayedVO> listFiveRaceMostPlayed() {
		List<RaceMostPlayedVO> raceMostPlayed = new ArrayList<RaceMostPlayedVO>();
		List<Race> races = raceDao.list(Race.class);

		for (Race race : races) {
			raceMostPlayed.add(new RaceMostPlayedVO(race.getName(), userDao.listUsersForRace(race.getId()).size()));
		}
		
		Collections.sort(raceMostPlayed);
		if(raceMostPlayed.size() > 5)
			return raceMostPlayed.subList(0, 5);
		return raceMostPlayed;
	}

	@Override
	public List<ClazzMostPlayedVO> listFiveClazzMostPlayed() {
		List<ClazzMostPlayedVO> clazzMostPlayed = new ArrayList<ClazzMostPlayedVO>();
		List<Clazz> classes = clazzDao.list(Clazz.class);

		for (Clazz clazz : classes) {
			clazzMostPlayed.add(new ClazzMostPlayedVO(clazz.getName(), userDao.listUsersForClass(clazz.getId()).size()));
		}
		Collections.sort(clazzMostPlayed);
		if(clazzMostPlayed.size() > 5)
			return clazzMostPlayed.subList(0, 5);
		return clazzMostPlayed;
	}

	@Override
	public List<SpecMostPlayedVO> listFiveSpecMostPlayed() {
		List<SpecMostPlayedVO> specMostPlayed = new ArrayList<SpecMostPlayedVO>();
		List<Specialization> specializations = specDao.list(Specialization.class);
		
		for (Specialization specialization : specializations) {
			// S'il y a déjà une specialization du même nom, 
			// on ajoute juste son nombre d'utilisateurs
			int i=0;
			boolean found = false;
			while(i<specMostPlayed.size() && !found){
				if(specMostPlayed.get(i).getName().equals(specialization.getName())){
					specMostPlayed.get(i).setNbUsers(specMostPlayed.get(i).getNbUsers() + userDao.listUsersForSpec(specialization.getId()).size());
					found = true;
				}
				i++;
			}
			//Sinon, on ajoute une nouvelle specialization à la liste
			if(!found)
				specMostPlayed.add(new SpecMostPlayedVO(specialization.getName(), userDao.listUsersForSpec(specialization.getId()).size()));
		}
		Collections.sort(specMostPlayed);
		if(specMostPlayed.size() > 5)
			return specMostPlayed.subList(0, 5);
		return specMostPlayed;
	}

	@Override
	public List<UserMostActiveVO> listUsersMostActive() {
		List<UserMostActiveVO> usersMostActive = new ArrayList<UserMostActiveVO>();

		List<User> users = userDao.list(User.class);

		for (User user : users) {
			usersMostActive.add(new UserMostActiveVO(user.getNickname(), forumReplyDao.listRepliesForUser(user.getId()).size()));
		}
		
		Collections.sort(usersMostActive);
		if(usersMostActive.size() > 5)
			return usersMostActive.subList(0, 5);
		return usersMostActive;
	}

	@Override
	public List<String> listUsersWithNoAvatar() {
		List<String> usersWithNoAvatar = new ArrayList<String>();

		List<User> users = userDao.list(User.class);

		for (User user : users) {
			if(user.getForumAvatar().contains("/resources/img/default_avatar.png")) {
				usersWithNoAvatar.add(user.getNickname());
			}
		}
		
		return usersWithNoAvatar;
	}
}