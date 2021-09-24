package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.DemandasPage;
import pages.HomePage;
import pages.PainelDemandaPage;

public class PainelDemandasStep {
	
	HomePage home = new HomePage();
	PainelDemandaPage painel = new PainelDemandaPage();
	DemandasPage demanda = new DemandasPage();
	
	@Dado("que estou na aba de painel")
	public void que_estou_na_aba_de_painel() {
		home.acessarUrl();
		home.painel();
	}

	@Quando("faco a pesquisa por codigo")
	public void faco_a_pesquisa_por_codigo() {
		painel.buscarDemandaPorCodigo("33322-22300");
	}

	@Entao("a pesquisa e apresentado com sucesso")
	public void a_pesquisa_e_apresentado_com_sucesso() {
		painel.validacaoDaPesquisa("Wesley", "Validação Em Produção", "Parcial");
		painel.contadorDeStatus("79");
	}
	
	@Quando("opto em ver mais detalhes")
	public void opto_em_ver_mais_detalhes() {
		painel.detalhar();
	    
	}

	@E("altero o responsavel")
	public void altero_o_responsavel() {
		demanda.alteracaoDeResponsavel("Cristiano");
	}

	@E("altero o status")
	public void altero_o_status() throws InterruptedException {
		demanda.alteracaoStatus("Em Validação");
		demanda.validacaoDeSucesso("Status Alterado com sucesso!");
		demanda.alteracaoStatus("Aguardando Construção");
		demanda.validacaoDeSucesso("Status Alterado com sucesso!");
		 
	}

	@E("o responsavel retorna ficar vazio e insiro novamente")
	public void o_responsavel_retorna_ficar_vazio_e_insiro_novamente() {
		demanda.alteracaoDeResponsavel("Helen Sales");
		
	    
	}

	@E("altero o status novamente")
	public void altero_o_status_novamente() throws InterruptedException {
		demanda.statusContrucao("Em Construção");
		demanda.modalBaseDados("Homologação - 1");
	    
	}

	@Entao("uma demanda e finalizada apos status Finalizada em producao e apresentada")
	public void uma_demanda_e_finalizada_apos_status_Finalizada_em_producao_e_apresentada() {
	   
	}

}
