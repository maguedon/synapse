package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.statistiques.vo.ClazzMostPlayedVO;
import fr.synapsegaming.statistiques.vo.RaceMostPlayedVO;
import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
@Service("StatistiquesService")
public class StatistiquesServiceImpl implements StatistiquesService{

	@Autowired
	ClazzDao clazzDao;

	@Autowired
	UserDao userDao;

	@Autowired
	RaceDao raceDao;

	@Override
	public List<ClazzMostPlayedVO> listFiveClassesMostPlayed() {
		List<Clazz> classes = clazzDao.list(Clazz.class);
		List<ClazzMostPlayedVO> classesMostPlayed = new ArrayList<ClazzMostPlayedVO>();

		for(Clazz clazz:classes) {
			classesMostPlayed.add(new ClazzMostPlayedVO(clazz.getName(), clazz.getUsers().size()));
		}

		Collections.sort(classesMostPlayed);
		return classesMostPlayed.subList(0, 5);

	}

	@Override
	public List<RaceMostPlayedVO> listFiveRacesMostPlayed() {
		List<Race> races = raceDao.list(Race.class);
		List<RaceMostPlayedVO> classesMostPlayed = new ArrayList<RaceMostPlayedVO>();

		for(Race clazz:races) {
			classesMostPlayed.add(new RaceMostPlayedVO(clazz.getName(), clazz.getUsers().size()));
		}

		Collections.sort(classesMostPlayed);
		return classesMostPlayed.subList(0, 5);
	}
}
