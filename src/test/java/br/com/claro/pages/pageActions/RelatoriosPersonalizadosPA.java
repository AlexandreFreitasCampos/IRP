package br.com.claro.pages.pageActions;


import br.com.claro.pages.pageObjects.RelatoriosPersonalizdosPO;
import br.com.claro.utils.AcoesWeb;
import br.com.claro.utils.DriverFactory;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import static br.com.claro.utils.PDF.*;

public class RelatoriosPersonalizadosPA extends DriverFactory{
    RelatoriosPersonalizdosPO relatoriosPersonalizados = new RelatoriosPersonalizdosPO();

    private boolean fim = false;
    private static String contaSelecionada;
    private static String servicoSelecionado;
    private static String paisSelecionado;
    private static String periodoInicial;
    private static String periodoFinal;
    private static String tipoRelatorio;
    private static String filtro;
    private List<WebElement> totalSelos;


    public void criarArquvioPDF(String string) {
        try {
            criaDocumento(string);
            insereCaBecalho();
            switch (string) {
                case "rel_person_grav_edit_todo_catalogo":
                case "rel_person_grav_edit_selos":
                case "rel_person_grav_edit_artistas":
                case "rel_person_grav_edit_albuns":
                case "rel_person_grav_edit_faixas":
                    escreveTitulo("CT - Gerar relatorio personalizado com perfil Gravadora/Editora");
                    break;
                case "rel_person_grav":
                    escreveTitulo("CT - Gerar relatorio personalizado com perfil Gravadora");
                    break;
                case "rel_person_edit":
                    escreveTitulo("CT - Gerar relatorio personalizado com perfil Editora");
                    break;
            }
            escreveSubTitulo("Dados de entrada:\nConta: Warner (Gravadora)\n" +
                    "Serviço: Claro Música\nPaís: Brasil\nPeríodo: 10/2023 à 12/2023\n\nPrecondição:" +
                    "\nEstar logado na página de Relatórios\n\nResultado esperado: Relatório gerado com sucesso");
        } catch (Exception e) {
            escreveErroComponente("Falha ao criar o arquivo PDF!!!");
        }
    }

    public void clicarMenu(String string) {
        try {
            switch (string) {
                case "Relatórios":
                    Thread.sleep(3000);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.menuRelatorios);
                    relatoriosPersonalizados.menuRelatorios.click();
                    break;
                case "Relatórios Personalizados":
                    escreveStep("Clicar no menu Relatórios e em Relatórios personalizados");
                    AcoesWeb.highlightElement(relatoriosPersonalizados.menuRelatoriosPersonalizados);
                    inserePrint();
                    relatoriosPersonalizados.menuRelatoriosPersonalizados.click();
                    Thread.sleep(2000);
                    while(relatoriosPersonalizados.relatoriosEmAndamento.isDisplayed()){
                        System.out.println("Construção de relatórios em andamento. Aguardando...");
                        Thread.sleep(1000);
                    }
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarOpcaoConta(String string) {
        try {
            relatoriosPersonalizados.inputContaGravadora.click();
            AcoesWeb.highlightElement(relatoriosPersonalizados.labelContaGravadora);
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarConta(String string) {
        try {
            escreveStep("Selecionar a conta '" + string + "' e clicar no botão Seguinte");
            if (string.equals("Warner (Gravadora)")) {
                contaSelecionada = relatoriosPersonalizados.contaWarner.getText();
                relatoriosPersonalizados.contaWarner.click();
                AcoesWeb.highlightElement(relatoriosPersonalizados.selectContas);
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void clicarBotao(String string) {
        try {
            switch (string) {
                case "Seguinte Conta":
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnSeguinteConta);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguinteConta.click();
                    break;
                case "Seguinte Servico":
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnSeguinteServico);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguinteServico.click();
                    break;
                case "Seguinte Pais":
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnSeguintePais);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguintePais.click();
                    break;
                case "Seguinte Periodo":
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnSeguintePeriodo);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguintePeriodo.click();
                    break;
                case "Seguinte relatorio":
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnSeguinteRelatorio);
                    inserePrint();
                  //  relatoriosPersonalizados.btnSeguinteRelatorio.click();
                    break;
            }
        }catch (Exception e){
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarServico(String string) {
        try {
            AcoesWeb.aguardaElementoPresente(relatoriosPersonalizados.servicoClaroMusica);
            relatoriosPersonalizados.servicoClaroMusica.click();
            escreveStep("Selecionar o serviço '" + string + "' e clicar no botão Seguinte");
            switch (string) {
                case "Claro Música":
                    servicoSelecionado = relatoriosPersonalizados.servicoClaroMusica.getText();
                    relatoriosPersonalizados.servicoClaroMusica.click();
                    AcoesWeb.highlightElement(relatoriosPersonalizados.servicoClaroMusica);
                    break;
                case "RBT":
                    servicoSelecionado = relatoriosPersonalizados.servicoRBT.getText();
                    relatoriosPersonalizados.servicoRBT.click();
                    AcoesWeb.highlightElement(relatoriosPersonalizados.servicoRBT);
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarPais(String string) {
        try {
            Thread.sleep(2000);
            escreveStep("Selecionar o país '" + string + "' e clicar no botão Seguinte");
            AcoesWeb.aguardaElementoPresente(relatoriosPersonalizados.paisBrasil);
            paisSelecionado = relatoriosPersonalizados.paisBrasil.getText();
            AcoesWeb.highlightElement(relatoriosPersonalizados.selectPaises);
            relatoriosPersonalizados.paisBrasil.click();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarPeriodoInicial(String string) {
        try {
            escreveStep("Selecionar o período inicial");
            Thread.sleep(2000);
            AcoesWeb.selecionarPeriodoInicial();
            periodoInicial = relatoriosPersonalizados.periodoInicial.getAttribute("value");
            AcoesWeb.highlightElement(relatoriosPersonalizados.periodoInicial);
            inserePrint();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarPeriodoFinal(String string) {
        try {
            escreveStep("Selecionar o período final e clicar no botão Seguinte");
            AcoesWeb.aguardaElementoPresente(relatoriosPersonalizados.periodoInicial);
            AcoesWeb.selecionarPeriodoFinal();
            periodoFinal = relatoriosPersonalizados.periodoFinal.getAttribute("value");
            AcoesWeb.highlightElement(relatoriosPersonalizados.periodoFinal);
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarTipoDeRelatorio(String string) {
        try {
            escreveStep("Selecionar " + string);
            switch (string) {
                case "Relatorios Unificados":
                    Thread.sleep(2000);
                    AcoesWeb.scrollPagina();
                    tipoRelatorio = relatoriosPersonalizados.btnRelatoriosUnificados.getText();
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnRelatoriosUnificados);
                    relatoriosPersonalizados.btnRelatoriosUnificados.click();
                    inserePrint();
                    Thread.sleep(1500);
                    break;
                case "Relatorios Multiplos":
                    Thread.sleep(2000);
                    AcoesWeb.scrollPagina();
                    tipoRelatorio = relatoriosPersonalizados.btnRelatoriosMultiplos.getText();
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnRelatoriosMultiplos);
                    relatoriosPersonalizados.btnRelatoriosMultiplos.click();
                    inserePrint();
                    Thread.sleep(1500);
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarFiltroDeRelatorio(String string) {
        try {
            escreveStep("Filtrar por " + string + " e clicar no botão Seguinte");
            Thread.sleep(1000);
            switch (string) {
                case "Todo o Catálogo":
                    tipoRelatorio = relatoriosPersonalizados.labelTodoOCatalogo.getText();
                    relatoriosPersonalizados.labelTodoOCatalogo.click();
                    AcoesWeb.scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.labelTodoOCatalogo);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnSeguinteRelatorio);
                    inserePrint();
                    relatoriosPersonalizados.menuRelatorios.click();
                    relatoriosPersonalizados.menuRelatoriosPersonalizados.click();
                    Thread.sleep(2000);
                    break;
                case "Selos":
                    tipoRelatorio = relatoriosPersonalizados.labelSelecionePorSelos.getText();
                    relatoriosPersonalizados.labelSelecionePorSelos.click();
                    AcoesWeb.scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.labelSelecionePorSelos);
                    Thread.sleep(3000);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalSelos = relatoriosPersonalizados.listaDeFiltros;

                    for(int i = 2; i <= totalSelos.size(); i++){
                        AcoesWeb.clicarElementosListaSelo(i);
                    }
                    inserePrint();
                    break;
                case "Artistas":
                    tipoRelatorio = relatoriosPersonalizados.labelSelecionePorArtistas.getText();
                    relatoriosPersonalizados.labelSelecionePorArtistas.click();
                    AcoesWeb.scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.labelSelecionePorArtistas);
                    Thread.sleep(3000);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalSelos = relatoriosPersonalizados.listaDeFiltros;

                    for(int i = 2; i <= totalSelos.size(); i++){
                        AcoesWeb.clicarElementosListaSelo(i);
                    }
                    inserePrint();
                    break;
                case "Albuns":
                    tipoRelatorio = relatoriosPersonalizados.labelSelecionePorAlbuns.getText();
                    relatoriosPersonalizados.labelSelecionePorAlbuns.click();
                    AcoesWeb.scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.labelSelecionePorAlbuns);
                    Thread.sleep(3000);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalSelos = relatoriosPersonalizados.listaDeFiltros;

                    for(int i = 2; i <= totalSelos.size(); i++){
                        AcoesWeb.clicarElementosListaSelo(i);
                    }
                    inserePrint();
                    break;
                case "Faixas":
                    tipoRelatorio = relatoriosPersonalizados.labelSelecionePorFaixas.getText();
                    relatoriosPersonalizados.labelSelecionePorFaixas.click();
                    AcoesWeb.scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.labelSelecionePorFaixas);
                    Thread.sleep(3000);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalSelos = relatoriosPersonalizados.listaDeFiltros;

                    for(int i = 2; i <= totalSelos.size(); i++){
                        AcoesWeb.clicarElementosListaSelo(i);
                    }
                    inserePrint();
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }
}


