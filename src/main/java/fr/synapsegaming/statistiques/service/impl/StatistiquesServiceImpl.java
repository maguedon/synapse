package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.statistiques.vo.ObjectMostPlayedVO;
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
public class StatistiquesServiceImpl implements StatistiquesService {

	@Autowired
	ClazzDao clazzDao;

	@Autowired
	UserDao userDao;

	@Autowired
	RaceDao raceDao;
	
	@Autowired
	SpecializationDao specialDao;
	
	@Autowired
	ForumReplyDao forumReplyDao;

	@Override
	public List<ObjectMostPlayedVO> listFiveObjectsMostPlayed(String object) {
		List<ObjectMostPlayedVO> objectsMostPlayed = new ArrayList<ObjectMostPlayedVO>();

		if (object == "Classes") {
			List<Clazz> classes = clazzDao.list(Clazz.class);

			for (Clazz clazz : classes) {
				objectsMostPlayed.add(new ObjectMostPlayedVO(clazz.getName(), userDao.listUsersForClass(clazz.getId()).size()));
			}
		}
		if (object == "Races") {
			List<Race> races = raceDao.list(Race.class);

			for (Race race : races) {
				objectsMostPlayed.add(new ObjectMostPlayedVO(race.getName(), userDao.listUsersForRace(race.getId()).size()));
			}
		}
		if (object == "Specializations") {
			List<Specialization> specializations = specialDao.list(Specialization.class);
			
			for (Specialization specialization : specializations) {
				// S'il y a déjà une specialization du même nom, 
				// on ajoute juste son nombre d'utilisateurs
				int i=0;
				boolean found = false;
				while(i<objectsMostPlayed.size() && !found){
					if(objectsMostPlayed.get(i).getName().equals(specialization.getName())){
						objectsMostPlayed.get(i).setNbUsers(objectsMostPlayed.get(i).getNbUsers() + userDao.listUsersForSpec(specialization.getId()).size());
						found = true;
					}
					i++;
				}
				//Sinon, on ajoute une nouvelle specialization à la liste
				if(!found)
					objectsMostPlayed.add(new ObjectMostPlayedVO(specialization.getName(), userDao.listUsersForSpec(specialization.getId()).size()));
			}
		}

		Collections.sort(objectsMostPlayed);
		if(objectsMostPlayed.size() > 5)
			return objectsMostPlayed.subList(0, 5);
		return objectsMostPlayed;

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
}
