package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.statistiques.vo.ObjectMostPlayedVO;
import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;

@Service("StatistiquesService")
public class StatistiquesServiceImpl implements StatistiquesService {

	@Autowired
	ClazzDao clazzDao;

	@Autowired
	UserDao userDao;

	@Autowired
	RaceDao raceDao;

	@Override
	public List<ObjectMostPlayedVO> listFiveObjectsMostPlayed(String object) {
		List<ObjectMostPlayedVO> classesMostPlayed = new ArrayList<ObjectMostPlayedVO>();

		if (object == "Classes") {
			List<Clazz> classes = clazzDao.list(Clazz.class);

			for (Clazz clazz : classes) {
				classesMostPlayed.add(new ObjectMostPlayedVO(clazz.getName(), clazz.getUsers().size()));
			}
		}
		if (object == "Races") {
			List<Race> races = raceDao.list(Race.class);

			for (Race race : races) {
				classesMostPlayed.add(new ObjectMostPlayedVO(race.getName(), race.getUsers().size()));
			}
		}

		Collections.sort(classesMostPlayed);
		return classesMostPlayed.subList(0, 5);

	}
}
