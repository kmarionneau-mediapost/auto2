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

	//Dossier de téléchargement
	public String dlFile = "C:\\Users\\kevin.marionneau\\Desktop\\DossierDLTestAuto";

	//Nom du fichier à télécharger
	public String nomFichier = "Prév_Double_Tour_LP";


	@Before
	public void main() throws IOException {
		System.setProperty("webdriver.gecko.driver",".\\rsc\\geckodriver.exe");

		//Appeler options Firefox, mettre chemin pour les téléchargement
		FirefoxOptions options = Boite_a_Outil.setOptionsFirefox(dlFile);

		//Créer le driver et lui mettre les options
		driver = new FirefoxDriver (options);

		//Ouvre le site PROLOG
		driver.get("http://logiappzqua1.mediapost.fr:8080/prolog/common/login.xhtml");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		//Vider dossier téléchargment
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

		//Vérifier qu'on est sur la page d'accueil
		assertEquals("La page n'est pas la page d'accueil. Il s'agit de " + Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:8080/prolog/common/accueil.xhtml",Boite_a_Outil.URL(driver));

		// Sélectionner La PFM de Blois
		pageAccueil.choisirSite("MM41B0");

		//Aller sur Réception
		Page_Reception pageReception = pageAccueil.passerSurReception();
		Thread.sleep(3000);

		//Passer à l'onglet Réception
		main_window=Boite_a_Outil.passerOngletSuivant(main_window, driver);

		//Vérifier qu'on est sur la page de Réception
		assertEquals("La page n'est pas la page de réception. Il s'agit de " + Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:9088/reception/common/accueil.jsf",Boite_a_Outil.URL(driver));

		//Aller sur la page Mécanisation
		Page_VisualisationPlannings pageVisualisationPlannings = pageReception.passerSurVisualisationPlannings();
		Thread.sleep(10000);

		//Passer à l'onglet Mécanisation
		main_window=Boite_a_Outil.passerOngletSuivant(main_window, driver);

		//Vérifier qu'on est sur la page de Mécanisation
		assertEquals("La page n'est pas la page de mécanisation. Il s'agit de " + Boite_a_Outil.URL(driver),"http://logiappzqua1.mediapost.fr:7088/mecanisation2Web/common/accueil.jsf",Boite_a_Outil.URL(driver));

		//Aller sur la page Prévisions
		Page_Prevision pagePrevision = pageVisualisationPlannings.ecranPrevision();
		Thread.sleep(10000);

		//Vérifier qu'on est sur la page Prévision
		assertEquals("Le tableau Prévisions n'est pas affiché", "Prévisions", pagePrevision.getTextTableau1());

		//Télécharger l'export LP
		pagePrevision.cliquerBtnExportDoubleTour();
		Thread.sleep(5000);

		//Vérifier que le fichier d'export LP existe
		assertTrue(Boite_a_Outil.verifierFichierExistant(dlFile, nomFichier));

	}

	@After
	public void quitBrowser() throws IOException {
		driver.close();

		//Vider dossier téléchargment
		Boite_a_Outil.viderDossierTelechargement(dlFile);
	}

}