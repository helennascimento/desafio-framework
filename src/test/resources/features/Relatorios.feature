#language:pt
Funcionalidade: Realizar busca de relatorios de demandas
  Como retornar demandas de execucoes
  Quero verificar o relatorio com tempo e quantidade de tarefas

  @CSU04
  Cenario: Devo fazer uma busca de relatorios de Demandas
    Dado que estou na aba de relatorios "demandas"
    Quando faco uma pesquisa de demanda que estao execucao
    Entao e informado uma lista de demandas

  @CSU05
  Cenario: Devo fazer uma busca de relatorio de SLA
    Dado que estou na aba de relatorios "SLA"
    Quando faco uma pesquisa de SLA
    Entao deve retornar demandas ja finalizadas

  @CSU06
  Cenario: Devo fazer uma busca de relatorio de Status por projeto
    Dado que estou na aba de relatorios "Projeto"
    Quando faco uma pesquisa de status por projeto
    Entao deve retornar finalizacao de um projeto com varias demandas

  @CSU07
  Cenario: Devo fazer uma busca de relatorio por Execucao
    Dado que estou na aba de relatorios "execucao"
    Quando faco uma pesquisa por execucao 
    Entao deve retornar a quantidade de tarefas por pessoa
