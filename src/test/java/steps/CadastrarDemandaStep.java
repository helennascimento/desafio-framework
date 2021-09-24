package steps;



import com.github.javafaker.Faker;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import pages.HomePage;


public class CadastrarDemandaStep {
	
	HomePage home = new HomePage();
	CadastroPage cadastro = new CadastroPage();
	Faker faker = new Faker();
	

	String nome = faker.gameOfThrones().character() +" "+ faker.gameOfThrones().dragon();
	String numero = faker.numerify("##########");
	String cenario = faker.numerify("##");

	
	
	@Dado("que devo fazer um cadastro de demandas")
	public void queDevoFazerUmCadastroDeDemandas() {
		home.acessarUrl();
		home.clicarBotaoCadastrar();
	    
	}

	@Quando("preencho todos os campos obrigatorio")
	public void preenchoTodosOsCamposObrigatorio() {
		cadastro.preencherCadastroDemandas(numero, nome, cenario);
		cadastro.continuar();
	    
	}

	@Entao("e cadastrado com sucesso")
	public void eCadastradoComSucesso() {
		cadastro.sucesso("Cadastro realizado com sucesso!x");
	    
	}


}
