package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemandasPage extends BasePage{
	
	public DemandasPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "status")
	private WebElement selecStatus;
	
	@FindBy(id = "responsavel")
	private WebElement selecResponsavel;
	
	@FindBy (id= "enviar_status")
	private WebElement btnEnviarStatus;
	
	@FindBy (id = "refresh")
	private WebElement btnRefresh;
	
	@FindBy (xpath = "//div[@class='modal-body']//select[@id='base']")
	private WebElement modal;
	
	

	public void alteracaoDeResponsavel (String responsavel ) {
		sleep(1000);
		selecResponsavel.click();
		driver.findElement(By.xpath("//select[@name = 'responsavel']//option[contains (., '"+ responsavel +"')]")).click();
		System.out.println("Alteração do responsável para: "+ responsavel +"" );
			
	}
	
	public void alteracaoStatus (String status) throws InterruptedException{
		sleep(1000);
		selecStatus.click();
		
		driver.findElement(By.xpath("//select[@name = 'status']//option[contains (., '"+ status +"')]")).click();
		System.out.println("Alteração do status para: "+ status +"");
		
		sleep(1000);
		btnEnviarStatus.click();
	}
	
	public void validacaoDeSucesso (String sucesso) throws InterruptedException {
		sleep(2000);
		btnRefresh.click();	
		
	}
	
	public void statusContrucao (String status) {
		selecStatus.click();
		
		driver.findElement(By.xpath("//select[@name = 'status']//option[contains (., '"+ status +"')]")).click();
		System.out.println("Alteração do status para: "+ status +"");
		
		btnEnviarStatus.click();
		
	}
	
	public void modalBaseDados (String opcoesModal){
		modal.click();
		
		String escolhaModal = driver.findElement(By.xpath("//select[@id = 'base']//option[contains (., '"+ opcoesModal +"')]")).getText();
		System.out.println("Escolha da opção:" + escolhaModal +"");
		

	}
	
}
