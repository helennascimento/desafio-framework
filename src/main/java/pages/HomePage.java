package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//li[contains(., 'Cadastrar')]")
	private WebElement btnCadastrar;
	

	@FindBy(xpath = "//li[@class = 'active']")
	private WebElement btnPainel;
	
	
	public void clicarBotaoCadastrar () {
		btnCadastrar.click();
	}
	
	public void painel () {
		btnPainel.click();
	}

}
