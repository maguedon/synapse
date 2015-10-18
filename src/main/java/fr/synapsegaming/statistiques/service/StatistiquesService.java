package fr.synapsegaming.statistiques.service;

import java.util.List;

import fr.synapsegaming.user.entity.Clazz;

public interface StatistiquesService {

	/**
	 * Liste les 5 classes les plus jouées
	 * @return Liste de classes
	 */
	List<Clazz> listFiveClassesMostPlayed();

}
