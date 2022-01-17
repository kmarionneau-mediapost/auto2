import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Accueil {
	protected WebDriver driver;

	
	//Liste déroulante des sites
	private By ldSite = By.xpath("//select[@id='chgtSite']");
	//Bouton Mécanisation
	private By btnMecanisation = By.xpath("//a[text()=\'Mécanisation\']");
	
	public Page_Accueil(WebDriver driver) {
		this.driver = driver;
	}
	
	public void choisirSite(String site) {
		//Choix du site avec variable
		driver.findElement(ldSite).click();
		driver.findElement(By.xpath("//select[@id='chgtSite']/option[@value='"+site+"']")).click();
	}
	
	public Page_Reception passerSurReception() {
		//Cliquer sur le Bouton Mécanisation
		driver.findElement(btnMecanisation).click();
		return new Page_Reception(driver);
	}
	
}
