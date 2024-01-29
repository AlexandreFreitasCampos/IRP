#Author:Alexandre Freitas

Feature: Gerar Relatórios
Eu como usuário
Quero gerar relatórios automatizados
Para garantir a qualidade e melhorar o processo

Scenario: Realizar login com perfil 'Gravadora/Editora'
    Given que acessei a classe "Login"
    When valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    And escrevo o texto "login gravadora/editora"
    And escrevo o texto "senha"
    Then clico no botao "Acessar"
    And valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    And escrevo o texto "código recebido"
    Then clico no botao "Log in" 
  
 Scenario Outline: Gerar relatório personalizados com perfil Gravadora e Editora e serviço <Serviço>
    Given que acessei a classe "Relatorios"
    When valido o componente "<Serviço>"
    Then clico no botao "Seguinte"
    And valido o componente "BRAZIL"
    Then clico no botao "SeguinteCountry"
    And valido o componente "Período Inicial"
    And valido o componente "Período Final"
    Then clico no botao "SeguintePeriod"
    And valido o texto "Serviço selecionado"
    And valido o texto "País selecionado"
    And valido o texto "Período selecionado"
    Then valido o componente "Botão gerar"
    
 Examples:
  |Serviço                        |
  |Claro Música Gravadora/Editora |
  |RBT Gravadora/Editora          |
  |OTT Gravadora/Editora          |
  |OTT Unificado Gravadora/Editora| 
  
 Scenario: Realizar login com perfil 'Gravadora'
    Given que acessei a classe "Login"
    When valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    And escrevo o texto "login gravadora"
    And escrevo o texto "senha"
    Then clico no botao "Acessar"
    And valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    And escrevo o texto "código recebido"
    Then clico no botao "Log in"

 Scenario Outline: Gerar relatório personalizados com perfil Gravadora e serviço <Serviço>
    Given que acessei a classe "Relatorios"
    When valido o componente "<Serviço>"
    Then clico no botao "Seguinte"
    And valido o componente "BRAZIL"
    Then clico no botao "SeguinteCountry"
    And valido o componente "Período Inicial"
    And valido o componente "Período Final"
    Then clico no botao "SeguintePeriod"
    And valido o texto "Serviço selecionado"
    And valido o texto "País selecionado"
    And valido o texto "Período selecionado"
    Then valido o componente "Botão gerar"
    
 Examples:
  |Serviço                |
  |Claro Música Gravadora |
  |RBT Gravadora          |
  |OTT Gravadora          |
  |OTT Unificado Gravadora|
  
 Scenario: Realizar login com perfil 'Editora'
    Given que acessei a classe "Login"
    When valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    And escrevo o texto "login editora"
    And escrevo o texto "senha"
    Then clico no botao "Acessar"
    And valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    And escrevo o texto "código recebido"
    Then clico no botao "Log in"
     
 Scenario Outline: Gerar relatório personalizados com perfil Editora e serviço <Serviço>
    Given que acessei a classe "Relatorios"
    When valido o componente "<Serviço>"
    Then clico no botao "Seguinte"
    And valido o componente "BRAZIL"
    Then clico no botao "SeguinteCountry"
    And valido o componente "Período Inicial"
    And valido o componente "Período Final"
    Then clico no botao "SeguintePeriod"
    And valido o texto "Serviço selecionado"
    And valido o texto "País selecionado"
    And valido o texto "Período selecionado"
    Then valido o componente "Botão gerar"
    
 Examples:
  |Serviço              |
  |Claro Música Editora |
  |RBT Editora          |
  |OTT Editora          |
  |OTT Unificado Editora| 