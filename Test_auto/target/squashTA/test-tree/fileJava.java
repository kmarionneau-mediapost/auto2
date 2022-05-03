import java.util.Set;

import org.openqa.selenium.WebDriver;

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