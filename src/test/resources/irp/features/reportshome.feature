# Author:Alexandre Freitas

Feature: Validar a tela home

  Scenario: Validar os componentes do menu 
    Given que acessei a classe "Home"
    When valido a URL "https://irp.imusica.com.br/Recorders/Reports/Reports"
    And valido o texto "IRP (BETA )"
    And valido o componente "Relatórios"
    And valido o componente "Faturamento"
    And valido o componente "Histórico de Faturas"
    And valido o componente "Admin"
    And valido o componente "Idiomas"
    And valido o texto "Saudação"
    Then valido o componente "Botão Sair"
    
  Scenario: Validar os dados da conta
  	Given que acessei a classe "Home"
  	When valido o texto "Nome da Conta"
  	And valido o texto "ID Conta"
  	And valido o texto "Razão social"
  	And valido o texto "Moeda"
  	And valido o texto "Pagamento mínimo"
  	Then valido o texto "Data de Cadastro"  
    
  Scenario: Validar o filtro de relatórios
  	Given que acessei a classe "Home"
    When valido o texto "Filtro de relatórios"
    And valido o texto "Serviço"
    And valido o texto "País"
    And valido o texto "Período Inicial"
    And valido o texto "Período Final"
    And valido o texto "Status"
    And valido o componente "Botão Listar"
    And valido o texto "Usamos cookies..."
    Then valido o componente "Botão Aceitar"
    
    #And valido o texto "Conta"
    #And valido o componente "Lista conta"
    #And valido o componente "Lista serviço"
    #And valido o componente "Lista país"
    #And valido o componente "período inicial"
    #And valido o componente "período final"
    #Then valido o componente "status"
    #
    #
    #
    #
    #
    #
    #When clico no botao "Admin"  
    #And valido o texto "Troca de senha"
    #And valido o texto "Registro de Usuários"
    #And valido o texto "Listagem de Usuários"
    #And valido o texto "Resetar 2FA"
    #
    #When clico no botao "Troca de senha"
    #And valido o texto "Trocar Senha"
    #And valido o texto "Senha atual"    
    #And valido o texto "Nova senha"    
    #And valido o texto "Confirme a senha"
    #And valido o texto "Salvar"
    #
    #And clico no botao "Registro de Usuários"
    #And valido o texto "Registro de usuário"
    #And valido o texto "Nome"    
    #And valido o texto "Email"    
    #And valido o texto "Usuário"
    #And valido o texto "Perfil"
    #And valido o componente "Campo texto 'Nome'"
    #And valido o componente "Campo texto 'Email'"
    #And valido o componente "Campo texto 'Usuário'"
    #And valido o componente "Campo texto 'Perfil'"
    #And valido o texto "Gravadora/Editora"
    #And valido o texto "Serviço"
    #And valido o texto "País"
    #And valido o componente "Gravadora/Editora"
    #And valido o componente "Serviço"
    #And valido o componente "País"
    #And  valido o componente "Botão Salvar"	
    #
    #
    #And clico no botao "Listagem de Usuários"
 
    ##And valido o componente "Registro de Usuários"
    ##And valido o componente "Listagem de Usuários"
    ##And valido o componente "Resetar 2FA"
    ##And valido o botao "Salvar"
    ##And valido o texto "Usamos cookies"
    ##And valido o botao "Aceitar"
    
    