import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Connexion {
	protected WebDriver driver;
	
	//TextBox Identifiant
	private By tbLogin=By.xpath("//div[@id='Identifiant']/input");
	//TextBox Mot de passe
	private By tbMdp=By.xpath("//div[@id='Password']/input");
	//Bouton Entrer
	private By btnEntrer=By.xpath("//div[@id='Btn_entrer']/input");
	
	public Page_Connexion(WebDriver driver) {
		this.driver = driver;
	}
	
	public Page_Accueil seConnecter(String utilisateur, String motDePasse) {
		
		driver.findElement(tbLogin).sendKeys(utilisateur);
		driver.findElement(tbMdp).sendKeys(motDePasse);
		driver.findElement(btnEntrer).click();
		return new Page_Accueil(driver);
	}
}
