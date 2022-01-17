import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Prevision {
	
	protected WebDriver driver;
	
	//Titre du 1er tableau
	private By tableau1 = By.xpath("//div[@class='previsionCol1']//legend");
	
	//Bouton Export cont. LP
	private By btnExportLP = By.xpath("//button[contains(@id,'j_id_1x')]");
	
	public Page_Prevision(WebDriver driver) {
		this.driver = driver;
	}
	
	//R�cup�rer texte du 1er tableau
	public String getTextTableau1() {
		return driver.findElement(tableau1).getText();
	}
	
	public void cliquerBtnExportLP() {
		driver.findElement(btnExportLP).click();
	}
	
}
