package fr.synapsegaming.statistiques.service;

import java.util.List;

import fr.synapsegaming.statistiques.vo.ClazzMostPlayedVO;
import fr.synapsegaming.statistiques.vo.RaceMostPlayedVO;

public interface StatistiquesService {

	/**
	 * Liste les 5 classes les plus jouées
	 * @return Liste de classes
	 */
	List<ClazzMostPlayedVO> listFiveClassesMostPlayed();

	List<RaceMostPlayedVO> listFiveRacesMostPlayed();

}
