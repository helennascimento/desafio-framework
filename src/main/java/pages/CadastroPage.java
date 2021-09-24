package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CadastroPage extends BasePage {
		public CadastroPage() {
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(id = "codigo")
	private WebElement codigoProjeto;
	
	@FindBy(id = "nome")
	private WebElement nomeDemanda;
	
	@FindBy (xpath = "//input[@type = 'radio'][1]")
	private WebElement tipo;
	
	@FindBy (id= "cenarios")
	private WebElement cenarios;
	
	@FindBy (xpath = "//button[@class='btn btn-success']")
	private WebElement btnContinuar;
	
	
	
	public void preencherCadastroDemandas (String codProjeto, String nome, String codCenario){
		INFO("Inicialização do Preenchimento do cadastro");
		codigoProjeto.sendKeys(codProjeto);
		nomeDemanda.sendKeys(nome);
		tipo.click();
		cenarios.sendKeys(codCenario);
		
	}
	
	public void continuar(){
		btnContinuar.click();
	}
	
	public void sucesso (String resultadoSucesso) {
		 
		String sucesso = 
				driver.findElement(By.xpath("//div[@id = 'resultado'][contains (., '"+resultadoSucesso+"')]")).getText().replace("x", "").trim();
		
		System.out.println(sucesso);
		Assert.assertEquals(resultadoSucesso, sucesso);
			
	}

}
