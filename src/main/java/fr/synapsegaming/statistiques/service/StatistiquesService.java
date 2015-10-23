package fr.synapsegaming.statistiques.service;

import java.util.List;

import fr.synapsegaming.statistiques.vo.ObjectMostPlayedVO;

public interface StatistiquesService {

	/**
	 * Liste les 5 objets les plus joués
	 * @param string 
	 * @return Liste de ObjectMostPlayedVO
	 */
	List<ObjectMostPlayedVO> listFiveObjectsMostPlayed(String object);

}
