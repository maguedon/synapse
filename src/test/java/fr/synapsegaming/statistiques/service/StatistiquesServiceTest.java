package fr.synapsegaming.statistiques.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.synapsegaming.commons.service.AbstractServiceTest;

public class StatistiquesServiceTest extends AbstractServiceTest  {

	private static final int RECORD_NUMBER_EXPECTED = 5;
	private static final String FIRST_CLASS = "Chaman";
	private static final String SECOND_CLASS = "Chevalier de la mort";
	private static final String THIRD_CLASS = "Chasseur";
	private static final String FOURTH_CLASS = "Démoniste";
	private static final String FIFTH_CLASS = "Guerrier";
	/*
	 * Elfe de sang
		Gobelin
		Mort vivant
		Orc
		Tauren
		
		1343
	 */
	private static final String FIRST_RACE = "Mort vivant";
	private static final String SECOND_RACE = "Elfe de sang";
	private static final String THIRD_RACE = "Orc";
	private static final String FOURTH_RACE = "Gobelin";
	private static final String FIFTH_RACE = "Tauren";
	
	@Autowired
	StatistiquesService statistiquesService;
	
	// ---- Classes

	@Test
	public void testListFiveClassesMostPlayedHasFiveRecords() {
		assertTrue(statistiquesService.listFiveClassesMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}
	
	@Test
	public void testFirstClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClassesMostPlayed().get(0).getName(), FIRST_CLASS);
	}
	
	@Test
	public void testSecondClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClassesMostPlayed().get(1).getName(), SECOND_CLASS);
	}

	@Test
	public void testThirdClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClassesMostPlayed().get(2).getName(), THIRD_CLASS);
	}

	@Test
	public void testFourthClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClassesMostPlayed().get(3).getName(), FOURTH_CLASS);
	}

	@Test
	public void testFifthClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClassesMostPlayed().get(4).getName(), FIFTH_CLASS);
	}

	@Test
	public void testFirstClasseNumberMostPlayed() {
		assertTrue(statistiquesService.listFiveClassesMostPlayed().get(0).getNbUsers() == 3);
	}
	
	// ---- Races

	@Test
	public void testListFiveRaceMostPlayedHasFiveRecords() {
		assertTrue(statistiquesService.listFiveRacesMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}
	
	@Test
	public void testFirstRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRacesMostPlayed().get(0).getName(), FIRST_RACE);
	}
	
	@Test
	public void testSecondRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRacesMostPlayed().get(1).getName(), SECOND_RACE);
	}

	@Test
	public void testThirdRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRacesMostPlayed().get(2).getName(), THIRD_RACE);
	}

	@Test
	public void testFourthRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRacesMostPlayed().get(3).getName(), FOURTH_RACE);
	}

	@Test
	public void testFifthRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRacesMostPlayed().get(4).getName(), FIFTH_RACE);
	}

	@Test
	public void testFirstRaceNumberMostPlayed() {
		assertTrue(statistiquesService.listFiveRacesMostPlayed().get(0).getNbUsers() == 2);
	}
}
