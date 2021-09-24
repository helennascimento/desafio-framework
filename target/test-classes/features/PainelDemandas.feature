#language:pt
Funcionalidade: Realizar uma consulta de demandas
  Como pesquisar demanda por codigo, nome, usuario responsavel ou status
  Quero editar ou visualizar demandas com detalhes.

  @CSU02
  Cenario: Consultar demandas do sistema que exibira
    Dado que estou na aba de painel
    Quando faco a pesquisa por codigo
    Entao a pesquisa e apresentado com sucesso

  @CSU03
  Cenario: Devo adicionar um responsavel por demanda
    Dado que estou na aba de painel
    E faco a pesquisa por codigo
    Quando opto em ver mais detalhes
    E altero o responsavel
    E altero o status
    E o responsavel retorna ficar vazio e insiro novamente
    E altero o status novamente
    Entao uma demanda e finalizada apos status Finalizada em producao e apresentada
