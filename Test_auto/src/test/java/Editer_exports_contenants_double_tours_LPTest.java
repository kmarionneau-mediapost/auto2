import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Editer_exports_contenants_double_tours_LPTest {

	public  WebDriver driver;
	public  String main_window;

	//Dossier de t�l�chargement
	public String dlFile = "C:\\Users\\kevin.marionneau\\Desktop\\DossierDLTestAuto";

	//Nom du fichier � t�l�charger
	public String nomFichier = "Pr�v_Double_Tour_LP";


	@Before
	public void main() throws IOException {
		System.setProperty("webdriver.gecko.driver",".\\rsc\\geckodriver.exe");

		//Appeler options Firefox, mettre chemin pour les t�l�chargement
		FirefoxOptions options = Boite_a_Outil.setOptionsFirefox(dlFile);

		//Cr�er le driver et lui mettre les options
		driver = new FirefoxDriver (options);

		//Ouvre le site PROLOG
		driver.get("http://logiappzqua1.mediapost.fr:8080/prolog/common/login.xhtml");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		//Vider dossier t�l�chargment
		Boite_a_Outil.viderDossierTelechargement(dlFile);
	}

	@Test
	public void EditerExportContenantLP() throws InterruptedException {
		Page_Connexion pageConnexion = new Page_Connexion (driver);

		//Enregistrer l'onglet principal dans la variable main_window
		main_window = driver.getWindowHandle();

		//Se connecter avec cecile thomas (compte admin)
		Page_Accueil pageAccueil = pageConnexion.seConnecter("cecile.thomas", "watoo");
		Thread.sleep(3000);

		//V�rifier qu'on est sur la page d'accueil
		assertEquals("La page n'est pas la page d'accueil. Il s'agit de " + Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:8080/prolog/common/accueil.xhtml",Boite_a_Outil.URL(driver));

		// S�lectionner La PFM de Blois
		pageAccueil.choisirSite("MM41B0");

		//Aller sur R�ception
		Page_Reception pageReception = pageAccueil.passerSurReception();
		Thread.sleep(3000);

		//Passer � l'onglet R�ception
		main_window=Boite_a_Outil.passerOngletSuivant(main_window, driver);

		//V�rifier qu'on est sur la page de R�ception
		assertEquals("La page n'est pas la page de r�ception. Il s'agit de " + Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:9088/reception/common/accueil.jsf",Boite_a_Outil.URL(driver));

		//Aller sur la page M�canisation
		Page_VisualisationPlannings pageVisualisationPlannings = pageReception.passerSurVisualisationPlannings();
		Thread.sleep(10000);

		//Passer � l'onglet M�canisation
		main_window=Boite_a_Outil.passerOngletSuivant(main_window, driver);

		//V�rifier qu'on est sur la page de M�canisation
		assertEquals("La page n'est pas la page de m�canisation. Il s'agit de " + Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:7088/mecanisation2Web/common/accueil.jsf",Boite_a_Outil.URL(driver));

		//Aller sur la page Pr�visions
		Page_Prevision pagePrevision = pageVisualisationPlannings.ecranPrevision();
		Thread.sleep(10000);

		//V�rifier qu'on est sur la page Pr�vision
		assertEquals("Le tableau Pr�visions n'est pas affich�", "Pr�visions", pagePrevision.getTextTableau1());

		//T�l�charger l'export LP
		pagePrevision.cliquerBtnExportDoubleTour();
		Thread.sleep(5000);

		//V�rifier que le fichier d'export LP existe
		assertTrue(Boite_a_Outil.verifierFichierExistant(dlFile, nomFichier));

	}

	@After
	public void quitBrowser() throws IOException {
		driver.close();

		//Vider dossier t�l�chargment
		Boite_a_Outil.viderDossierTelechargement(dlFile);
	}

}