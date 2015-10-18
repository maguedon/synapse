package fr.synapsegaming.statistiques.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.utils.Page;

@Service("StatistiquesService")
public class StatistiquesServiceImpl implements StatistiquesService{

	@Autowired
	ClazzDao clazzDao;
	
	@Override
	public List<Clazz> listFiveClassesMostPlayed() {
		List<Clazz> classes = clazzDao.list(Clazz.class);
		List<Integer> nbUses = new ArrayList<Integer>();
		//Récupération du nombre d'utilisation de chaque classe
		for(int i=0; i<classes.size(); i++){
			nbUses.set(i, classes.get(i).getUsers().size());
		}
		
		List<Integer> fiveClassMostPlayed() = new ArrayList<Integer>;
		
		return null;
	}


	
}
