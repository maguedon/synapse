package fr.synapsegaming.statistiques.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StatistiquesServiceTest {

	private static final int RECORD_NUMBER_EXPECTED = 5;
	
	@Autowired
	StatistiquesService statistiquesService;

	@Test
	public void testlistFiveClassesMostPlayedHasFiveRecords() {
		assertTrue(statistiquesService.listFiveClassesMostPlayed().size() == RECORD_NUMBER_EXPECTED);
	}



}
