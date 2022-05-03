import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_VisualisationPlannings {

	protected WebDriver driver;

	//Onglet Pr�vision
	private By ogltPrevision = By.xpath("//span[@class='ui-menuitem-text' and text()='Pr�visions']");

	//Onglet Pr�vision
	private  By btnSemActif = By.xpath("//span[text()='Sem.']/parent::div[contains(@class,'ui-state-active')]");

	//Bouton Impression
	private By btnImpression = By.xpath("//button[contains(@class,'printAll')]");
	
	//Choix Planning - Synthese dans la liste d'impression
	private By chxPlanningSynthese = By.xpath("//a[contains(@class, 'btnImprimer-menuitem')]/span[text()='Planning - Synth�se']");
	
	public Page_VisualisationPlannings(WebDriver driver) {
		this.driver = driver;
	}

	//Aller sur l'�cran Pr�vision
	public Page_Prevision ecranPrevision() {
		driver.findElement(ogltPrevision).click();
		return new Page_Prevision(driver);
	}
	
	//Renvoie true si le bouton semaine est actif
	public boolean verifierBoutonSemaineActif() {
		return Boite_a_Outil.verifBoutonExiste(driver, btnSemActif);
	}
	
	//Cliquer sur le bouton Impression
	public void cliquerBtnImpression() {
		driver.findElement(btnImpression).click();
	}
	
	//S�lectionner Le choix Planning - Synth�se dans la liste des impressionns
	public void selectionnerPlanningSynthese() {
		driver.findElement(chxPlanningSynthese).click();
	}

}
