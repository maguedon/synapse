package fr.synapsegaming.statistiques.service;

import java.util.List;

import fr.synapsegaming.statistiques.vo.ObjectMostPlayedVO;
import fr.synapsegaming.statistiques.vo.UserMostActiveVO;
import fr.synapsegaming.user.entity.User;

public interface StatistiquesService {

	/**
	 * Liste les 5 objets les plus joués
	 * @param string 
	 * @return Liste de ObjectMostPlayedVO
	 */
	List<ObjectMostPlayedVO> listFiveObjectsMostPlayed(String object);

	List<UserMostActiveVO> listUsersMostActive();

}
