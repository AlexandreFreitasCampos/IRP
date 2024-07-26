# Author: Alexandre Freitas
# language: pt
# coding: utf-8

Funcionalidade: Gerar relatórios
  Eu como usuário
  Quero gerar relatórios automatizados
  Para garantir a qualidade dos testes
  E melhorar o tempo de execução

  @recEditor
  Cenario: Efetuar login com perfil Gravadora/Editora
    Dado que criei o arquvio PDF "realizarloginIRP_rec_editor" "" ""
    Quando valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    E insiro o usuario "alexandre.campos"
    E insiro a senha "@Gg190504"
    E clico no botao "Acessar"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    Quando insiro o codigo "M2FA"
    E clico no botao "Log in"
    Entao salvo o PDF "Login"

   @faixas
  Esquema do Cenario: Gerar "<arquivo>"
    Dado que criei o arquvio PDF "<arquivo>" "<servico>" "Warner (Gravadora)"
    Quando clico no menu "Relatórios"
    E clico no menu "Relatórios Personalizados"
    Entao valido a URL "https://irp-hmg.imusica.com.br/RecordersAndEditors/CustomReports/CustomReports"
    Quando seleciono a opcao "<opcao>"
    E seleciono a conta "Warner (Gravadora)"
    E clico no botao "Seguinte Conta"
    E seleciono o servico "<servico>"
    E clico no botao "Seguinte Servico"
    E seleciono o Pais "BRASIL"
    E clico no botao "Seguinte Pais"
    E seleciono o periodo Inicial "10/2023"
    E seleciono o periodo Final "12/2023"
    E clico no botao "Seguinte Periodo"
    E seleciono o tipo de relatorio "<tipo de relatorio>"
    E seleciono o filtro "<filtro>"
    E clico no botao "Seguinte relatorio"
    E altero a ordem das colunas
    E deleto as colunas
    E clico no botao "Resetar colunas"
    E clico no botao "Usar filtro de share"
    E informo o Share por artista 50
    Entao clico no botao "Seguinte Colunas"
    Quando valido os dados inseridos
    E clico no botao "Gerar"
    E clico no botao "Ok"
    Quando valido os dados do relatorio de pedido
    E clico no botao "Download"
    E clico no botao "Excluir"
    E salvo o PDF "Relatorios"
    Entao clico no botao "Sair"

    Exemplos:
      | arquivo                      | opcao     | servico      | tipo de relatorio     | filtro   |
      | rel_person_rec_edit_selos    | Gravadora | RBT          | Relatorios Unificados | Selos    |
      | rel_person_rec_edit_artistas | Gravadora | RBT          | Relatorios Unificados | Artistas |
      | rel_person_rec_edit_albuns   | Gravadora | Claro Música | Relatorios Multiplos  | Albuns   |
      | rel_person_rec_edit_faixas   | Gravadora | Claro Música | Relatorios Multiplos  | Faixas   |
#      | rel_person_grav_edit_todo_catalogo | Gravadora | Claro Música | Relatorios Unificados | Todo o Catálogo |

  @rec
  Cenario: Efetuar login com perfil Gravadora
    Dado que criei o arquvio PDF "realizarloginIRP_recorder" "" ""
    Quando valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    E insiro o usuario "alexandre.campos.recorder"
    E insiro a senha "@Gg190504"
    E clico no botao "Acessar"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    Quando insiro o codigo "M2FA"
    E clico no botao "Log in"
    Entao salvo o PDF "Login"

    @faixasRec
  Esquema do Cenario: Gerar "<arquivo>"
    Dado que criei o arquvio PDF "<arquivo>" "<servico>" "MK Music (Editora)"
    Quando seleciono a conta "Warner (Gravadora)"
    E clico no menu "Relatórios"
    E clico no menu "Relatórios Personalizados"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Recorders/CustomReports/CustomReports"
    Quando seleciono o servico "<servico>"
    E clico no botao "Seguinte Servico"
    E seleciono o Pais "BRASIL"
    E clico no botao "Seguinte Pais"
    E seleciono o periodo Inicial "10/2023"
    E seleciono o periodo Final "12/2023"
    E clico no botao "Seguinte Periodo"
    E seleciono o tipo de relatorio "<tipo de relatorio>"
    E seleciono o filtro "<filtro>"
    E clico no botao "Seguinte relatorio"
    E altero a ordem das colunas
    E deleto as colunas
    E clico no botao "Resetar colunas"
    E clico no botao "Usar filtro de share"
    E informo o Share por artista 50
    Entao clico no botao "Seguinte Colunas"
    Quando valido os dados inseridos
    E clico no botao "Gerar"
    E clico no botao "Ok"
    Quando valido os dados do relatorio de pedido
    E clico no botao "Download"
    E clico no botao "Excluir"
    E clico no botao "Voltar"
    E salvo o PDF "Relatorios"
    Entao clico no botao "Sair"

    Exemplos:
      | arquivo                      | opcao     | servico      | tipo de relatorio     | filtro   |
      | rel_person_recorder_selos    | Gravadora | RBT          | Relatorios Unificados | Selos    |
      | rel_person_recorder_artistas | Gravadora | RBT          | Relatorios Unificados | Artistas |
      | rel_person_recorder_albuns   | Gravadora | Claro Música | Relatorios Multiplos  | Albuns   |
      | rel_person_recorder_faixas   | Gravadora | Claro Música | Relatorios Multiplos  | Faixas   |
##      | rel_person_recorder_todo_catalogo | Gravadora | Claro Música | Relatorios Multiplos  | Todo o Catálogo |

  Cenario: Efetuar login com perfil Editora
    Dado que criei o arquvio PDF "realizarloginIRP_editor" "" ""
    Quando valido a URL "https://irp-hmg.imusica.com.br/Account/Login"
    E insiro o usuario "alexandre.campos.editor"
    E insiro a senha "@Gg190504"
    E clico no botao "Acessar"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Account/LoginWith2fa?RememberMe=False"
    Quando insiro o codigo "M2FA"
    E clico no botao "Log in"
    Entao salvo o PDF "Login"

  Esquema do Cenario: Gerar "<arquivo>"
    Dado que criei o arquvio PDF "<arquivo>" "<servico>" "MK Music (Editora)"
    Quando seleciono a conta "MK Music (Editora)"
    E clico no menu "Relatórios"
    E clico no menu "Relatórios Personalizados"
    Entao valido a URL "https://irp-hmg.imusica.com.br/Editors/CustomReports/CustomReports"
    Quando seleciono o servico "<servico>"
    E clico no botao "Seguinte Servico"
    E seleciono o Pais "BRASIL"
    E clico no botao "Seguinte Pais"
    E seleciono o periodo Inicial "10/2023"
    E seleciono o periodo Final "12/2023"
    E clico no botao "Seguinte Periodo"
    E seleciono o tipo de relatorio "<tipo de relatorio>"
    E seleciono o filtro "<filtro>"
    E clico no botao "Seguinte relatorio"
    E altero a ordem das colunas
    E deleto as colunas
    E clico no botao "Resetar colunas"
    E clico no botao "Usar filtro de share"
    E informo o Share por artista 50
    Entao clico no botao "Seguinte Colunas"
    Quando valido os dados inseridos
    E clico no botao "Gerar"
    E clico no botao "Ok"
    Quando valido os dados do relatorio de pedido
    E clico no botao "Download"
    E clico no botao "Excluir"
    E clico no botao "Voltar"
    E salvo o PDF "Relatorios"
    Entao clico no botao "Sair"

    Exemplos:
      | arquivo                    | opcao     | servico      | tipo de relatorio     | filtro   |
      | rel_person_editor_selos    | Gravadora | RBT          | Relatorios Unificados | Selos    |
      | rel_person_editor_artistas | Gravadora | RBT          | Relatorios Unificados | Artistas |
      | rel_person_editor_albuns   | Gravadora | Claro Música | Relatorios Multiplos  | Albuns   |
      | rel_person_editor_faixas   | Gravadora | Claro Música | Relatorios Multiplos  | Faixas   |
##      | rel_person_editor_todo_catalogo | Gravadora | Claro Música | Relatorios Multiplos  | Todo o Catálogo |