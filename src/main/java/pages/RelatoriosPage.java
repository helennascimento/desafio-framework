package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Calendar;

public class RelatoriosPage extends BasePage {
	public RelatoriosPage() {
		PageFactory.initElements(driver, this);
	}

	Calendar calendario = new Calendar();

	@FindBy(id = "menu3")
	private WebElement btnRelatorios;

	@FindBy(id = "dpd1")
	private WebElement clickPrimeiraData;

	@FindBy(id = "dpd2")
	private WebElement clickSegundaData;
	
	@FindBy(xpath = "//button[@title = 'Gerar Relatorio']")
	private WebElement btnBuscar;
	
	@FindBy(id = "datatable")
	private WebElement tabela;

	public void relatorios() {
		btnRelatorios.click();
	}

	public void selecaoDeRelatorio(String tipo) {

		WebElement tipoRelatorio = driver
				.findElement(By.xpath("//ul[@class = 'dropdown-menu']//a[@href='relatorios.php?tipo=" + tipo + "']"));
		tipoRelatorio.click();

	}

	public void validacaoPagina(String validacao) {
		String validacaoPag = driver.findElement(By.xpath("//p[contains(.,'" + validacao + "')]")).getText();
		System.out.println("Página de pesquisa");
		sleep(2000);
		Assert.assertEquals(validacao, validacaoPag);

	}

	public void datePrimeiroPeriodo(int data) {
		clickPrimeiraData.click();

		java.util.Date dataFutura = Calendar.obterDataComDiferencaDias(data);

		WebElement date = driver
				.findElement(By.xpath("(//div[@class = 'datepicker-days']//td[contains(.,'" + data + "')])[1]"));

		date.click();
		
		sleep(200);
	}

	public void dateSegundoPeriodo(int data) {
		//clickSegundaData.click();
		
		java.util.Date dataFutura = Calendar.obterDataComDiferencaDias(data);

		WebElement date = driver
				.findElement(By.xpath("(//div[@class = 'datepicker-days']//td[contains(.,'" + data + "')])[2]"));

		date.click();
		

		sleep(1000);
	
	}
	
	public void buscar () {
		btnBuscar.click();
		
		sleep(1000);
	}
	
	public void digitarData(String dataPrimeira, String dataSegunda){
		clickPrimeiraData.sendKeys(dataPrimeira);
		clickSegundaData.sendKeys(dataSegunda);
	}
	
	public void relatorioDoPeriodo (String resultadoDe) {
		String resultado = driver.findElement(By.xpath("//p[contains(.,'Relatório de "+resultadoDe+" no período')]")).getText();
		
		System.out.println("Relatório de "+resultado+"");
		
		
	}
		
	public boolean validador() {
        List<String> mediaTempo = new ArrayList<String>();
        int cont = 0;

        mediaTempo.add("895759:42:46");
        mediaTempo.add("00:00:45");
        mediaTempo.add("00:00:19");
        mediaTempo.add("00:00:21");
        mediaTempo.add("00:00:16");
        mediaTempo.add("00:00:00");
        
        System.out.println(mediaTempo);
        

        
        boolean validador = (cont == 6) ? true : false;
        return validador;
    }
	
	
	
	public boolean demandaPorStatus() {
        List<String> demandaStatus = new ArrayList<String>();
        int cont = 0;

        demandaStatus.add("Cristiano");
        demandaStatus.add("1");
        demandaStatus.add("Elaine Borges");
        demandaStatus.add("0");
        demandaStatus.add("Helen Sales");
        demandaStatus.add("0");
        demandaStatus.add("Wesley");
        demandaStatus.add("0");
        
        System.out.println(demandaStatus);
        

        boolean validador = (cont == 6) ? true : false;
        return validador;
    }

}