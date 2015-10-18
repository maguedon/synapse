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
	
}
