# Author: Alexandre Freitas
# language: pt0/
# coding: utf-8

Funcionalidade: Gerar relatórios
  Eu como usuário
  Quero gerar relatórios automatizados
  Para garantir a qualidade dos testes
  E melhorar o tempo de execução

  Cenario: Efetuar login com perfil Gravadora/Editora
    Dado que criei o arquvio PDF "realizarloginIRP"
    Quando valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    E insiro o usuario "alexandre.campos"
    E insiro a senha "@Gg190504"
    E clico no botao "Acessar"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    Quando insiro o codigo "M2FA"
    E clico no botao "Log in"
    Entao salvo o PDF

  Esquema do Cenario: Gerar relatorio personalizado com perfil Gravadora/Editora e Servico "<Servico>"
    Dado que criei o arquvio PDF "<PDF>"
    Quando clico no menu "Relatórios"
    E clico no menu "Relatórios Personalizados"
    Entao valido a URL "https://irp-hmg.imusica.com.br/RecordersAndEditors/CustomReports/CustomReports"
    Quando seleciono a conta "Grav/Edit"
    E clico no botao "Seguinte Conta"
    E seleciono o servico "<Servico>"
    E clico no botao "Seguinte Servico"
    E seleciono o Pais
    E clico no botao "Seguinte Pais"
    E seleciono o periodo "Inicial"
    E seleciono o periodo "Final"
    E clico no botao "Seguinte Periodo"
    E valido os dados selecionados
    E clico no botao "Gerar"
    Entao salvo o PDF

    Exemplos:
      | Servico       | PDF                                            |
      | Claro Musica  | relatorio_personalizado_claro_musica_gra_edit  |
      | RBT           | relatorio_personalizado_rbt_gra_edit           |
      | OTT Unificado | relatorio_personalizado_ott_unificado_gra_edit |
      | OTT           | relatorio_personalizado_ott_gra_edit           |


  Cenario: Efetuar login com perfil Gravadora
    Dado que criei o arquvio PDF "realizarloginIRP"
    Quando valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    E insiro o usuario "alexandre.campos.recorder"
    E insiro a senha "@Gg190504"
    E clico no botao "Acessar"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    Quando insiro o codigo "M2FA"
    E clico no botao "Log in"
    Entao salvo o PDF


  Esquema do Cenario: Gerar relatorio personalizado com perfil Gravadora e Servico "<Servico>"
    Dado que criei o arquvio PDF "<PDF>"
    Quando seleciono a conta "<Servico>"
    E clico no menu "Relatórios"
    E clico no menu "Relatórios Personalizados"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Recorders/CustomReports/CustomReports"
    Quando seleciono o servico "<Servico>"
    E clico no botao "Seguinte Servico"
    E seleciono o Pais
    E clico no botao "Seguinte Pais"
    E seleciono o periodo "Inicial"
    E seleciono o periodo "Final"
    E clico no botao "Seguinte Periodo"
    E valido os dados selecionados
    E clico no botao "Gerar"
    Entao salvo o PDF

    Exemplos:
      | Servico       | PDF                                             |
      | Claro Musica  | relatorio_personalizado_claro_musica_gravadora  |
      | RBT           | relatorio_personalizado_rbt_gravadora           |
      | OTT Unificado | relatorio_personalizado_ott_unificado_gravadora |
      | OTT           | relatorio_personalizado_ott_gravadora           |

  Cenario: Efetuar login com perfil Editora
    Dado que criei o arquvio PDF "realizarloginIRP"
    Quando valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    E insiro o usuario "alexandre.campos.editor"
    E insiro a senha "@Gg190504"
    E clico no botao "Acessar"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    Quando insiro o codigo "M2FA"
    E clico no botao "Log in"
    Entao salvo o PDF

  Esquema do Cenario: Gerar relatorio personalizado com perfil Editora e Servico "<Servico>"
    Dado que criei o arquvio PDF "<PDF>"
    Quando seleciono a conta "<Servico>"
    E clico no menu "Relatórios"
    E clico no menu "Relatórios Personalizados"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Editors/CustomReports/CustomReports"
    Quando seleciono o servico "<Servico>"
    E clico no botao "Seguinte Servico"
    E seleciono o Pais
    E clico no botao "Seguinte Pais"
    E seleciono o periodo "Inicial"
    E seleciono o periodo "Final"
    E clico no botao "Seguinte Periodo"
    E valido os dados selecionados
    E clico no botao "Gerar"
    Entao salvo o PDF

    Exemplos:
      | Servico       | PDF                                           |
      | Claro Musica  | relatorio_personalizado_claro_musica_editora  |
      | RBT           | relatorio_personalizado_rbt_editora           |
      | OTT Unificado | relatorio_personalizado_ott_unificado_editora |
      | OTT           | relatorio_personalizado_ott_editora           |