import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Affichage_ecran_planning_semaineTest {

	public  WebDriver driver;
	public  String main_window;


	@Before
	public void main() {
		System.setProperty("webdriver.gecko.driver",".\\rsc\\geckodriver.exe");
		driver = new FirefoxDriver ();
		//Ouvre le site PROLOG
		driver.get("http://logiappzqua1.mediapost.fr:8080/prolog/common/login.xhtml");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testAffichageEcranPrevision() throws InterruptedException {
		Page_Connexion pageConnexion = new Page_Connexion (driver);

		//Enregistrer l'onglet principal dans la variable main_window
		main_window = driver.getWindowHandle();

		//Se connecter avec cecile thomas (compte admin)
		Page_Accueil pageAccueil = pageConnexion.seConnecter("cecile.thomas", "watoo");
		Thread.sleep(3000);

		//V�rifier qu'on est sur la page d'accueil
		assertEquals(Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:8080/prolog/common/accueil.xhtml");

		// S�lectionner La PFM de Blois
		pageAccueil.choisirSite("MM41B0");

		//Aller sur R�ception
		Page_Reception pageReception = pageAccueil.passerSurReception();
		Thread.sleep(3000);

		//Passer � l'onglet R�ception
		main_window=Boite_a_Outil.passerOngletSuivant(main_window, driver);

		//V�rifier qu'on est sur la page de R�ception
		assertEquals(Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:9088/reception/common/accueil.jsf");

		//Aller sur la page M�canisation
		Page_VisualisationPlannings pageVisualisationPlannings = pageReception.passerSurVisualisationPlannings();
		Thread.sleep(10000);

		//Passer � l'onglet M�canisation
		main_window=Boite_a_Outil.passerOngletSuivant(main_window, driver);

		//V�rifier qu'on est sur la page de M�canisation
		assertEquals(Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:7088/mecanisation2Web/common/accueil.jsf");

		//V�rifier que le planning est sur la semaine
		assertTrue(pageVisualisationPlannings.verifierBoutonSemaineActif());
	}

	@After
	public void quitBrowser() {
		driver.close();
	}

}
