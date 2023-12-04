#Author:Alexandre Freitas

Feature: Validar telas do sistema

  Scenario: Validar a tela de login
    Given que acessei a classe "ValidarComponentesTelas"
    When valido a URL "https://irp.imusica.com.br/Account/Login"
    And valido o texto "Bem-vindo ao IRP"
    And valido o texto "Usuário"
    And valido o texto "Senha"
    And valido o texto "Lembrar de mim?"
    And valido o texto "Acessar"
    Then valido o texto "Esqueceu sua senha?"
    
  Scenario: Validar o rodapé  
  	Given que acessei a classe "ValidarComponentesTelas"
    When valido o texto "© 2023 - iMusica (Claro S.A.)"
    And valido o texto "Download do manual"
    And valido o texto "Idioma"
    And valido o componente "filtro de países"
    And valido o texto "Usamos cookies..."
    And valido o texto "Aceitar"
    And escrevo o texto "login"
    And escrevo o texto "senha"
    Then clico no botao "Acessar"
    
  Scenario: Validar a tela de autenticação de dois fatores
  	Given que acessei a classe "ValidarComponentesTelas"
    When valido o texto "Autenticação de dois fatores"
    And valido o texto "Seu login está protegido com um aplicativo de autenticação. Entre com seu código de autenticação abaixo."
    And valido o texto "Código de autenticação"
    And valido o componente "texto codigo"
    And valido o texto "Lembrar desta máquina"
    And valido o texto "Log in"
    And valido o texto "Não possui acesso ao dispositivo de autenticação? Você pode logar com um código de recuperação."
    And escrevo o texto "código recebido"
    Then clico no botao "Login"  
    
  Scenario: Validar os componentes da barra de menu 
    Given que acessei a classe "Menu"
    When valido o texto "IRP (BETA )"
    And valido o componente "Relatórios"
    And valido o componente "Faturamento"
    And valido o componente "Histórico de Faturas"
    And valido o componente "Admin"
    And valido o componente "Idiomas"
    And valido o texto "Saudação"
    Then valido o componente "Botão Sair"
    
  Scenario: Validar os dados da conta
  	Given que acessei a classe "Contas"
  	When valido o texto "Nome da Conta"
  	And valido o texto "ID Conta"
  	And valido o texto "Razão social"
  	And valido o texto "Moeda"
  	And valido o texto "Pagamento mínimo"
  	Then valido o texto "Data de Cadastro"    
  	
  Scenario: Validar o menu Relatórios
  	Given que acessei a classe "Relatorios"
    When valido o texto "Filtro de relatórios"
    And valido o texto "Serviço"
    And valido o texto "País"
    And valido o texto "Período Inicial"
    And valido o texto "Período Final"
    And valido o texto "Status"
    Then valido o componente "Botão Listar"	
    
  Scenario: Validar o menu Faturamento
  	Given que acessei a classe "Faturamento"
  	When valido o texto "Instruções para faturamento"
    And valido o texto "Filtro de faturas"
    And valido o texto "País de Faturamento"
    And valido o texto "Moeda de Faturamento"
    And valido o texto "Serviço"
    And valido o texto "País"
    And valido o texto "Período Inicial"
    And valido o texto "Período Final"
    Then valido o componente "Botão Listar"	  