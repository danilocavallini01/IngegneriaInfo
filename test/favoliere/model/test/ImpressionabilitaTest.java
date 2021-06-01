package favoliere.model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import favoliere.model.Impressionabilita;

public class ImpressionabilitaTest {
	
	@Test
	public void testImpressionabilita() {
		assertTrue(Impressionabilita.MOLTO_IMPRESSIONABILE.compareTo(Impressionabilita.POCO_IMPRESSIONABILE)>0);
		assertTrue(Impressionabilita.PERNULLA_IMPRESSIONABILE.compareTo(Impressionabilita.POCO_IMPRESSIONABILE)<0);
	}
}
