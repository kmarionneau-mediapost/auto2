import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Reception {
	
	protected WebDriver driver;
	
	//Bouton Mécanisation
	private By btnMecanisation = By.xpath("//span[text()='Mécanisation']");
	
	public Page_Reception(WebDriver driver) {
		this.driver = driver;
	}

	public Page_Mecanisation passerSurMecanisation() {
		driver.findElement(btnMecanisation).click();
		return new Page_Mecanisation(driver);
	}

}
