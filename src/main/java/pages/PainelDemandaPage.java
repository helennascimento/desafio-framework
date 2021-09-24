package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PainelDemandaPage extends BasePage {
	
	public PainelDemandaPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='pesquisa_demanda']")
	private WebElement pesquisar;
	
	@FindBy(xpath = "//button[@type= 'submit']")
	private WebElement btnPesquisar;
	
	@FindBy(xpath = "//td[contains(., 'Wesley')]")
	private WebElement resultadoResponsavel;
	
	@FindBy (xpath = "//td[contains(., 'Produção')]")
	private WebElement resultadoStatus;
	
	@FindBy(xpath = "//td[contains(., 'Parcial')]")
	private WebElement resultadoTipo;
	
	@FindBy(id= "detalhar")
	private WebElement btnDetalhar;
	
	
	
	public void buscarDemandaPorCodigo (String codigo) {
		pesquisar.sendKeys(codigo);
		btnPesquisar.click();
	}
	
	public void validacaoDaPesquisa (String responsavel, String status, String tipo) {
		String resultadoResponsavel = driver.findElement(By.xpath("//td[contains(., 'Wesley')]")).getText();
		Assert.assertEquals(resultadoResponsavel, responsavel);
		System.out.println("Resultado do responsável: "+ resultadoResponsavel +"");
		
		String resultadoStatus = driver.findElement(By.xpath("//td[contains(., 'Produção')]")).getText();
		Assert.assertEquals(resultadoStatus, status);
		System.out.println("Resultado do status: "+resultadoStatus+"");
		
		String resultadoTipo = driver.findElement(By.xpath("//td[contains(., 'Parcial')]")).getText();
		Assert.assertEquals(resultadoTipo, tipo);
		System.out.println("Resultado do responsável: "+resultadoTipo+"");
		
	}
	
	public void contadorDeStatus (String farolParada ) {
		String parada = driver.findElement(By.xpath("//div[@class = 'lg-total']")).getText();
		Assert.assertEquals(parada, farolParada);
		System.out.println("Resultado do responsável: "+parada+" Total de Demandas na Esteira");
		
	}
	
	public void detalhar () {
		btnDetalhar.click();
	}
	
	
}
