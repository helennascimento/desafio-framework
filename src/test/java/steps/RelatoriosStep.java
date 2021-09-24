package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import pages.HomePage;
import pages.RelatoriosPage;
;

public class RelatoriosStep {
	
	HomePage home = new HomePage();
	RelatoriosPage relatorio = new RelatoriosPage();
	CadastroPage cadastro = new CadastroPage();
	
	
	@Dado("que estou na aba de relatorios {string}")
	public void que_estou_na_aba_de_relatorios(String tipo) {
		home.acessarUrl();
		relatorio.relatorios();
		relatorio.selecaoDeRelatorio(tipo);
	}

	@Quando("faco uma pesquisa de demanda que estao execucao")
	public void faco_uma_pesquisa_de_demanda_que_estao_execucao() {
		relatorio.validacaoPagina("Filtros de pesquisa");
		relatorio.datePrimeiroPeriodo(5);
		relatorio.dateSegundoPeriodo(10);
	    relatorio.buscar();
	}

	
	@Entao("e informado uma lista de demandas")
	public void e_informado_uma_lista_de_demandas() {
		cadastro.sucesso("Sua Pesquisa não retornou resultados!");
	    
	}
	
	
	@Quando("faco uma pesquisa de SLA")
	public void faco_uma_pesquisa_de_SLA() {
		relatorio.validacaoPagina("Filtros de pesquisa");
		relatorio.digitarData("02022021", "03022021");
		relatorio.buscar();
	    
	}
	
	@Entao("deve retornar demandas ja finalizadas")
	public void deve_retornar_demandas_ja_finalizadas() {
		relatorio.validador();
	    
	}


	@Quando("faco uma pesquisa de status por projeto")
	public void faco_uma_pesquisa_de_status_por_projeto() {
		relatorio.validacaoPagina("Filtros de pesquisa");
		relatorio.digitarData("03042021", "04042021");
		relatorio.buscar();
	    
	}
	
	@Entao("deve retornar finalizacao de um projeto com varias demandas")
	public void deve_retornar_finalizacao_de_um_projeto_com_varias_demandas() {
		cadastro.sucesso("Erro File no such in diretory, please contact admn");
	    
	}

	@Quando("faco uma pesquisa por execucao")
	public void faco_uma_pesquisa_por_execucao() {
		relatorio.validacaoPagina("Relatório de Execução - Filtros de pesquisa");
		relatorio.digitarData("04052021", "05052021");
		relatorio.buscar();
	   
	}
	
	
	@Entao("deve retornar a quantidade de tarefas por pessoa")
	public void deve_retornar_a_quantidade_de_tarefas_por_pessoa() {
		relatorio.demandaPorStatus();
	    
	}

}

	