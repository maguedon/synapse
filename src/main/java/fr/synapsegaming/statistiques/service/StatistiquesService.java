package fr.synapsegaming.statistiques.service;

import java.util.List;

import fr.synapsegaming.statistiques.vo.ClazzMostPlayedVO;
import fr.synapsegaming.statistiques.vo.RaceMostPlayedVO;
import fr.synapsegaming.statistiques.vo.SpecMostPlayedVO;
import fr.synapsegaming.statistiques.vo.UserMostActiveVO;

public interface StatistiquesService {

	/**
	 * Liste les 5 objets les plus joués
	 * @param string 
	 * @return Liste de ObjectMostPlayedVO
	 */
	List<RaceMostPlayedVO> listFiveRaceMostPlayed();
	
	List<ClazzMostPlayedVO> listFiveClazzMostPlayed();
	
	List<SpecMostPlayedVO> listFiveSpecMostPlayed();

	List<UserMostActiveVO> listUsersMostActive();

	List<String> listUsersWithNoAvatar();
}
