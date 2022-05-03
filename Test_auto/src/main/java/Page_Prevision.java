import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Prevision {
	
	protected WebDriver driver;
	
	//Titre du 1er tableau
	private By tableau1 = By.xpath("//div[@class='previsionCol1']//legend");
	
	//Bouton Export cont. LP
	private By btnExportLP = By.xpath("//button[contains(@id,'j_id_1x')]");
	
	//Bouton Export cont. MDP
	private By btnExportMDP = By.xpath("//button[contains(@id,'j_id_23')]");
	
	//Bouton Export double tour
	private By btnExportDoubleTour = By.xpath("//button[contains(@id,'j_id_1z')]");
	
	public Page_Prevision(WebDriver driver) {
		this.driver = driver;
	}
	
	//Récupérer texte du 1er tableau
	public String getTextTableau1() {
		return driver.findElement(tableau1).getText();
	}
	
	public void cliquerBtnExportLP() {
		driver.findElement(btnExportLP).click();
	}
	
	public void cliquerBtnExportMDP() {
		driver.findElement(btnExportMDP).click();
	}
	
	public void cliquerBtnExportDoubleTour() {
		driver.findElement(btnExportDoubleTour).click();
	}
	
}
