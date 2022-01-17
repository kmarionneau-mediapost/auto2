
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PoiCasDeTestDaoTest {

	//Chemin où mettre le rapport généré
	private static String exportSquash = "C:\\Users\\kevin.marionneau\\Desktop\\Pilotage\\Rapport de test\\exportsquash.xlsx";

	private CasDeTestDao dao;

	@Before
	public void doBefore() {
		dao = new PoiCasDeTestDao (exportSquash);
	}

	@Test
	public void testFindAllCasDeTest() {
		
		final int expectedSize = 6;
		
		List<CasDeTest> lcasDeTest = dao.findAllCasDeTest();
		
		Assert.assertNotNull(lcasDeTest);
		Assert.assertEquals(expectedSize, lcasDeTest.size());

		//Boite_a_Outils.verifierFichierExistant(cheminRapport, "Rapport");
	}

}
