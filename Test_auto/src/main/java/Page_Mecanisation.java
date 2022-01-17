import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Mecanisation {
	
	protected WebDriver driver;
	
	//Onglet Prévision
	private By ogltPrevision = By.xpath("//span[@class='ui-menuitem-text' and text()='Prévisions']");
	
	public Page_Mecanisation(WebDriver driver) {
		this.driver = driver;
	}
	
	public Page_Prevision ecranPrevision() {
		driver.findElement(ogltPrevision).click();
		return new Page_Prevision(driver);
	}

}
