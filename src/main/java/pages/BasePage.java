package pages;

import static java.util.logging.Logger.GLOBAL_LOGGER_NAME;

import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import config.Driver;


public class BasePage {
	
	private static final Logger logger = Logger.getLogger(GLOBAL_LOGGER_NAME);
	
	@FindBy(id = "login")
	private WebElement login;
	
	@FindBy (id = "senha")
	private WebElement senha;
	
	@FindBy (xpath = "//input [@value ='Logar']")
	private WebElement logar;
	
	public static WebDriver driver = Driver.getDriver();
	
	public void acessarUrl () {
		driver.get("https://demandas-frwk.000webhostapp.com/");
		
		acesso("helen.sales", "frame2021");
		
		
	}
	
	public void acessarUrl(String url) {
		driver.get(url);
		
	}
	
	public void acesso (String acessoLogin, String acessoSenha) {
		login.sendKeys(acessoLogin);
		senha.sendKeys(acessoSenha);
		logar.click();
	}
	
	public void sleep(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void INFO (String log){
		logger.info(log);
		
	}
	
	public void selecionarPorTexto(WebElement elemento, String texto) {
		Select select = new Select(elemento);
		select.selectByVisibleText(texto);
	}
	
	public void clickJavaScript (WebElement elemento ) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", elemento);
	}
	
	
	
}
