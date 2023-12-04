#Author:Alexandre Freitas

Feature: Realizar login no IRP

  Scenario: Realizar login
    Given que acessei a classe "Login"
    When valido a URL "https://irp.imusica.com.br/Account/Login"
    And escrevo o texto "login"
    And escrevo o texto "senha"
    Then clico no botao "Acessar"
    And valido a URL "https://irp.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    And escrevo o texto "código recebido"
    Then clico no botao "Log in"




