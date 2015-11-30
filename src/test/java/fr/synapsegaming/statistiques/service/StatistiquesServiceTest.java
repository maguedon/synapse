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

	private static final String FIRST_RACE = "Mort vivant";
	private static final String SECOND_RACE = "Elfe de sang";
	private static final String THIRD_RACE = "Orc";
	private static final String FOURTH_RACE = "Gobelin";
	private static final String FIFTH_RACE = "Tauren";
	
	private static final String FIRST_SPECIAL = "Combat";
	private static final String SECOND_SPECIAL = "Assassinat";
	private static final String THIRD_SPECIAL = "Finesse";
	
	private static final String FIRST_USER = "Squash";
	private static final String SECOND_USER = "Inactive";
	private static final String THIRD_USER = "XtremZ";

	private static final int USER_WITH_NO_AVATAR_EXPECTED = 4;
	private static final String FIRST_USER_NO_AVATAR = "Squash";
	private static final String SECOND_USER_NO_AVATAR = "XtremZ";
	private static final String THIRD_USER_NO_AVATAR = "Inactive";
	private static final String FOURTH_USER_NO_AVATAR = "Update";
	
	@Autowired
	StatistiquesService statistiquesService;
	
	// ---- Classes 

	@Test
	public void testListFiveClassesMostPlayedHasFiveRecords() {
		assertTrue(statistiquesService.listFiveClazzMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}
	
	@Test
	public void testFirstClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClazzMostPlayed().get(0).getName(), FIRST_CLASS);
	}
	
	@Test
	public void testSecondClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClazzMostPlayed().get(1).getName(), SECOND_CLASS);
	}

	@Test
	public void testThirdClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClazzMostPlayed().get(2).getName(), THIRD_CLASS);
	}

	@Test
	public void testFourthClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClazzMostPlayed().get(3).getName(), FOURTH_CLASS);
	}

	@Test
	public void testFifthClasseMostPlayed() {
		assertEquals(statistiquesService.listFiveClazzMostPlayed().get(4).getName(), FIFTH_CLASS);
	}

	@Test
	public void testFirstClasseNumberMostPlayed() {
		assertTrue(statistiquesService.listFiveClazzMostPlayed().get(0).getNbUsers() == 3);
	}
	
	// ---- Races

	@Test
	public void testListFiveRaceMostPlayedHasFiveRecords() {
		assertTrue(statistiquesService.listFiveRaceMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}
	
	@Test
	public void testFirstRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRaceMostPlayed().get(0).getName(), FIRST_RACE);
	}
	
	@Test
	public void testSecondRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRaceMostPlayed().get(1).getName(), SECOND_RACE);
	}

	@Test
	public void testThirdRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRaceMostPlayed().get(2).getName(), THIRD_RACE);
	}

	@Test
	public void testFourthRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRaceMostPlayed().get(3).getName(), FOURTH_RACE);
	}

	@Test
	public void testFifthRaceMostPlayed() {
		assertEquals(statistiquesService.listFiveRaceMostPlayed().get(4).getName(), FIFTH_RACE);
	}

	@Test
	public void testFirstRaceNumberMostPlayed() {
		assertTrue(statistiquesService.listFiveRaceMostPlayed().get(0).getNbUsers() == 2);
	}
	
	// ---- Spécialisations 
	
	@Test
	public void testListFiveSpecializationMostPlayedHasFiveRecordsMax() {
		assertTrue(statistiquesService.listFiveSpecMostPlayed().size() <= 5);
	}
	
	@Test
	public void testFirstSpecializationMostPlayed() {
		assertEquals(statistiquesService.listFiveSpecMostPlayed().get(0).getName(), FIRST_SPECIAL);
	}
	
	@Test
	public void testSecondSpecializationMostPlayed() {
		assertEquals(statistiquesService.listFiveSpecMostPlayed().get(1).getName(), SECOND_SPECIAL);
	}

	@Test
	public void testThirdSpecializationMostPlayed() {
		assertEquals(statistiquesService.listFiveSpecMostPlayed().get(2).getName(), THIRD_SPECIAL);
	}

	@Test
	public void testFirstSpecializationNumberMostPlayed() {
		assertTrue(statistiquesService.listFiveSpecMostPlayed().get(0).getNbUsers() == 3);
	}
	
	// ---- Actifs 
	
	@Test
	public void testListFivePlayersMostActiveHasFiveRecordsMax() {
		assertTrue(statistiquesService.listUsersMostActive().size() <= 5);
	}
	
	@Test
	public void testFirstPlayerMostActive() {
		assertEquals(statistiquesService.listUsersMostActive().get(0).getName(), FIRST_USER);
	}
	
	@Test
	public void testSecondPlayerMostActive() {
		assertEquals(statistiquesService.listUsersMostActive().get(1).getName(), SECOND_USER);
	}

	@Test
	public void testThirdPlayerMostActive() {
		assertEquals(statistiquesService.listUsersMostActive().get(2).getName(), THIRD_USER);
	}
	
	// ---- Avatars
	
	@Test
	public void testListNumberUserWithNoAvatar() {
		assertTrue(statistiquesService.listUsersWithNoAvatar().size() == USER_WITH_NO_AVATAR_EXPECTED);
	}

	@Test
	public void testFirstPlayerWithNoAvatar() {
		assertEquals(statistiquesService.listUsersWithNoAvatar().get(0), FIRST_USER_NO_AVATAR);
	}

	@Test
	public void testSecondPlayerWithNoAvatar() {
		assertEquals(statistiquesService.listUsersWithNoAvatar().get(1), SECOND_USER_NO_AVATAR);
	}

	@Test
	public void testThirdPlayerWithNoAvatar() {
		assertEquals(statistiquesService.listUsersWithNoAvatar().get(2), THIRD_USER_NO_AVATAR);
	}

	@Test
	public void testFourthPlayerWithNoAvatar() {
		assertEquals(statistiquesService.listUsersWithNoAvatar().get(3), FOURTH_USER_NO_AVATAR);
	}
}