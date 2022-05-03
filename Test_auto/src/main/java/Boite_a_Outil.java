import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Boite_a_Outil {
	

	//Permet de changer d'onglet, et fermer le précédent
	public static String passerOngletSuivant(String main_window, WebDriver driver) {
		Set<String> allwindows= driver.getWindowHandles();
		for (String childWindow : allwindows) {
			if(!childWindow.equals(main_window))
			{
				//Ferme l'onglet principal
				driver.close();
				//Focus sur le nouvel onglet
				driver.switchTo().window(childWindow);
				//Passe le nouvel onglet en onglet principal
				main_window=childWindow;
			}
		}
		return main_window;
	}

	//Permet de récupérer l'URL
	public static String URL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	//Préférences Firefox, pour enregistrer directement les fichiers téléchargés
	public static FirefoxOptions setOptionsFirefox(String cheminDL) {
		FirefoxOptions options = new FirefoxOptions()
				.addPreference("browser.download.folderList", 2)
				.addPreference("browser.download.dir", cheminDL)
				.addPreference("browser.download.useDownloadDir", true)
				.addPreference("browser.helperApps.alwaysAsk.force", false)
				.addPreference("browser.download.manager.showWhenStarting",false)
				.addPreference("browser.download.viewableInternally.enabledTypes", "")
				//Rajouter type DL si besoin
				.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/xlsx;vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.ms-excel,text/xml,application/x-excel,application/x-msexcel,application/xhtml+xml,application/octet-stream,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				.addPreference("pdfjs.disabled", true)
				.addPreference("browser.download.useDownloadDir", true);
		return options;
	}

	//Rechercher un fichier avec son chemin et son nom
	public static boolean verifierFichierExistant(String chemin, String nom) {
		
		//Initialiser variable verif à False
		boolean verif = false;
		
		//Création d'une liste listFiles avec les documents du chemin fourni
		File[] listFiles = new File(chemin).listFiles();

		//Initialisation d'un iterateur avec en taille max, le nombre de fichier dans la liste listFiles
		for (int i = 0; i < listFiles.length; i++) {

			if (listFiles[i].isFile()) {
				String fileName = listFiles[i].getName();
				//Si le fichier commence bien avec le nom prévu, la variable verif passe à True
				if (fileName.startsWith(nom)) {
					verif = true;
				}
			}
		}
		return verif;
	}

	//Vider le dossier de téléchargement
	public static void viderDossierTelechargement(String chemin) throws IOException {
		File dir = new File(chemin);
		File[] listFiles = new File(chemin).listFiles();

		if (listFiles.length > 0) {
			FileUtils.cleanDirectory(dir);
		}
		
	}
	
	public static boolean verifBoutonExiste(WebDriver driver, By locator) {
		
		//Retourner true si l'élément est visible
		return driver.findElement(locator).isDisplayed();
	}
	
}