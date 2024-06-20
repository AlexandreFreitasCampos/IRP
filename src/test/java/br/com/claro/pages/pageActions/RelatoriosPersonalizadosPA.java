package br.com.claro.pages.pageActions;


import br.com.claro.pages.pageObjects.RelatoriosPersonalizdosPO;
import br.com.claro.utils.AcoesWeb;
import br.com.claro.utils.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static br.com.claro.utils.AcoesWeb.*;
import static br.com.claro.utils.PDF.*;

public class RelatoriosPersonalizadosPA extends DriverFactory {
    RelatoriosPersonalizdosPO relatoriosPersonalizados = new RelatoriosPersonalizdosPO();

    private boolean fim = false;
    private static String contaSelecionada;
    private static String servicoSelecionado;
    private static String paisSelecionado;
    private static String periodoInicial;
    private static String periodoFinal;
    private static String tipoDeRelatorio;
    private static String filtro;
    private static String qtdeRoyalties;
    private List<WebElement> totalFiltros;
    private List<String> nomeColunas;
    private Scenario scenario;
    private int erro;


    public void criarArquvioPDF(String string) {
        try {
            erro = 0;
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
            escreveSubTitulo("Dados de entrada:\nConta: Warner (Gravadora)\n" + "Serviço: Claro Música\nPaís: Brasil\nPeríodo: 10/2023 à 12/2023\n\nPrecondição:" + "\nEstar logado na página de Relatórios\n\nResultado esperado: Relatório gerado com sucesso");
        } catch (Exception e) {
            escreveErroComponente("Falha ao criar o arquivo PDF!!! Cenário: " + scenario.getName());
            erro ++;

        }
    }

    public void clicarMenu(String string) {
        try {
            switch (string) {
                case "Relatórios":
                    Thread.sleep(3000);
                    highlightElement(relatoriosPersonalizados.menuRelatorios);
                    relatoriosPersonalizados.menuRelatorios.click();
                    break;
                case "Relatórios Personalizados":
                    escreveStep("Clicar no menu Relatórios e em Relatórios personalizados");
                    highlightElement(relatoriosPersonalizados.menuRelatoriosPersonalizados);
                    inserePrint();
                    relatoriosPersonalizados.menuRelatoriosPersonalizados.click();
                    Thread.sleep(2000);
                    int segundos = 0;
                    int minutos = 0;
                    while (relatoriosPersonalizados.relatoriosEmAndamento.isDisplayed()) {
                        if (segundos == 60) {
                            segundos = 0;
                            minutos++;
                        }
                        DecimalFormat formatter = new DecimalFormat("00");
                        System.out.println(relatoriosPersonalizados.relatoriosEmAndamento.getText() + formatter.format(minutos) + ":" + formatter.format(segundos) + " segundos");
                        Thread.sleep(1000);
                        segundos++;
                    }
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarOpcaoConta(String string) {
        try {
            relatoriosPersonalizados.inputContaGravadora.click();
            highlightElement(relatoriosPersonalizados.labelContaGravadora);
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarConta(String string) {
        try {
            AcoesWeb.aguardaElementoPresente(relatoriosPersonalizados.contaWarner);
            escreveStep("Selecionar a conta '" + string + "' e clicar no botão Seguinte");
            if (string.equals("Warner (Gravadora)")) {
                contaSelecionada = relatoriosPersonalizados.contaWarner.getText();
                relatoriosPersonalizados.contaWarner.click();
                highlightElement(relatoriosPersonalizados.selectContas);
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void clicarBotao(String string) {
        try {
            switch (string) {
                case "Seguinte Conta":
                    highlightElement(relatoriosPersonalizados.btnSeguinteConta);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguinteConta.click();
                    break;
                case "Seguinte Servico":
                    highlightElement(relatoriosPersonalizados.btnSeguinteServico);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguinteServico.click();
                    break;
                case "Seguinte Pais":
                    highlightElement(relatoriosPersonalizados.btnSeguintePais);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguintePais.click();
                    break;
                case "Seguinte Periodo":
                    highlightElement(relatoriosPersonalizados.btnSeguintePeriodo);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguintePeriodo.click();
                    break;
                case "Seguinte relatorio":
                    highlightElement(relatoriosPersonalizados.btnSeguinteRelatorio);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguinteRelatorio.click();
                    Thread.sleep(3000);

                    if (AcoesWeb.verificaElementoExistente(relatoriosPersonalizados.listaNenhumRegistro)) {
                        escreveStep("Nenhum registro encontrado para " + filtro);
                        AcoesWeb.highlightElement(relatoriosPersonalizados.btnNenhumRegistro);
                        inserePrint();
                        relatoriosPersonalizados.btnNenhumRegistro.click();
                        AcoesWeb.atualizaPagina();
                        salvaDocumento();
                    }
                    break;
                case "Resetar colunas":
                    escreveStep("Resetar todas as colunas");
                    highlightElement(relatoriosPersonalizados.btnResetColunas);
                    relatoriosPersonalizados.btnResetColunas.click();
                    inserePrint();
                    break;
                case "Seguinte Colunas":
                    highlightElement(relatoriosPersonalizados.btnSeguinteColunas);
                    inserePrint();
                    relatoriosPersonalizados.btnSeguinteColunas.click();
                    break;
                case "Usar filtro de share":

                    escreveStep("Clicar em Usar filtro de share");
                    highlightElement(relatoriosPersonalizados.btnFiltoShare);
                    relatoriosPersonalizados.btnFiltoShare.click();
                    inserePrint();
                    break;
                case "Gerar":
                    rolarPaginaParaCima();
                    highlightElement(relatoriosPersonalizados.btnGerar);
                    inserePrint();
                    relatoriosPersonalizados.btnGerar.click();
                    break;
                case "Ok":
                    escreveStep("Clicar no botão Ok");
                    aguardaElementoPresente(relatoriosPersonalizados.btnOk);
                    highlightElement(relatoriosPersonalizados.btnOk);
                    inserePrint();
                    relatoriosPersonalizados.btnOk.click();
                    Thread.sleep(3000);
                    int segundos = 0;
                    int minutos = 0;
                    AcoesWeb.rolarPaginaParaBaixo();
                    while (relatoriosPersonalizados.relatoriosEmAndamento.isDisplayed()) {
                        if (segundos == 60) {
                            segundos = 0;
                            minutos++;
                        }
                        DecimalFormat formatter = new DecimalFormat("00");
                        System.out.println(relatoriosPersonalizados.relatoriosEmAndamento.getText() + formatter.format(minutos) + ":" + formatter.format(segundos) + " segundos");
                        Thread.sleep(1000);
                        segundos++;
                    }
                    break;
                case "Download":
                    escreveStep("Clicar no botão de Dowload");
                    highlightElement(relatoriosPersonalizados.btnDownloadRelatorio);
                    inserePrint();
                    relatoriosPersonalizados.btnDownloadRelatorio.click();
                    AcoesWeb.aguardaElementoClicavel(relatoriosPersonalizados.btnDownloadRelatorio);
                    break;
                case "Excluir":
                    Thread.sleep(3000);
                    escreveStep("Clicar no botão de excluir e confirmar a exclusão do relatório");
                    highlightElement(relatoriosPersonalizados.btnExcluirRelatorio);
                    relatoriosPersonalizados.btnExcluirRelatorio.click();
                    AcoesWeb.aguardaElementoPresente(relatoriosPersonalizados.btnConfirmaExclusaoRelatorio);
                    AcoesWeb.highlightElement(relatoriosPersonalizados.btnConfirmaExclusaoRelatorio);
                    inserePrint();
                    relatoriosPersonalizados.btnConfirmaExclusaoRelatorio.click();
                    AcoesWeb.aguardaElementoPresente(relatoriosPersonalizados.inputContaGravadora);
                    if(erro > 0){
                        System.out.println("Total de erros encontrados: " + erro);
                    }
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarServico(String string) {
        try {
            aguardaElementoPresente(relatoriosPersonalizados.servicoClaroMusica);
            relatoriosPersonalizados.servicoClaroMusica.click();
            escreveStep("Selecionar o serviço '" + string + "' e clicar no botão Seguinte");
            switch (string) {
                case "Claro Música":
                    servicoSelecionado = relatoriosPersonalizados.servicoClaroMusica.getText();
                    relatoriosPersonalizados.servicoClaroMusica.click();
                    highlightElement(relatoriosPersonalizados.servicoClaroMusica);
                    break;
                case "RBT":
                    servicoSelecionado = relatoriosPersonalizados.servicoRBT.getText();
                    relatoriosPersonalizados.servicoRBT.click();
                    highlightElement(relatoriosPersonalizados.servicoRBT);
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarPais(String string) {
        try {
            Thread.sleep(2000);
            escreveStep("Selecionar o país '" + string + "' e clicar no botão Seguinte");
            aguardaElementoPresente(relatoriosPersonalizados.paisBrasil);
            paisSelecionado = relatoriosPersonalizados.paisBrasil.getText();
            highlightElement(relatoriosPersonalizados.selectPaises);
            relatoriosPersonalizados.paisBrasil.click();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarPeriodoInicial(String string) {
        try {
            escreveStep("Selecionar o período inicial");
            Thread.sleep(2000);
            AcoesWeb.selecionarPeriodoInicial();
            periodoInicial = relatoriosPersonalizados.periodoInicial.getAttribute("value");
            highlightElement(relatoriosPersonalizados.periodoInicial);
            inserePrint();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarPeriodoFinal(String string) {
        try {
            escreveStep("Selecionar o período final e clicar no botão Seguinte");
            aguardaElementoPresente(relatoriosPersonalizados.periodoInicial);
            AcoesWeb.selecionarPeriodoFinal();
            periodoFinal = relatoriosPersonalizados.periodoFinal.getAttribute("value");
            highlightElement(relatoriosPersonalizados.periodoFinal);
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarTipoDeRelatorio(String string) {
        try {
            Thread.sleep(2000);
            escreveStep("Selecionar " + string);
            switch (string) {
                case "Relatorios Unificados":
                    rolarPaginaParaBaixo();
                    tipoDeRelatorio = relatoriosPersonalizados.btnRelatoriosUnificados.getText();
                    highlightElement(relatoriosPersonalizados.btnRelatoriosUnificados);
                    relatoriosPersonalizados.btnRelatoriosUnificados.click();
                    inserePrint();
                    break;
                case "Relatorios Multiplos":
                    rolarPaginaParaBaixo();
                    tipoDeRelatorio = relatoriosPersonalizados.btnRelatoriosMultiplos.getText();
                    highlightElement(relatoriosPersonalizados.btnRelatoriosMultiplos);
                    relatoriosPersonalizados.btnRelatoriosMultiplos.click();
                    inserePrint();
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void selecionarFiltroDeRelatorio(String string) {
        try {
            escreveStep("Filtrar por " + string + " e clicar no botão Seguinte");
            Thread.sleep(2000);
            switch (string) {
                case "Todo o Catálogo":
                    filtro = relatoriosPersonalizados.labelTodoOCatalogo.getText();
                    relatoriosPersonalizados.labelTodoOCatalogo.click();
                    scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    highlightElement(relatoriosPersonalizados.labelTodoOCatalogo);
                    break;
                case "Selos":
                    filtro = relatoriosPersonalizados.labelSelecionePorSelos.getText();
                    relatoriosPersonalizados.labelSelecionePorSelos.click();
                    scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    highlightElement(relatoriosPersonalizados.labelSelecionePorSelos);
                    Thread.sleep(2000);
                    highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalFiltros = relatoriosPersonalizados.listaDeFiltros;

                    for (int i = 2; i <= totalFiltros.size(); i++) {
                        clicarElementosLista(i);
                    }
                    break;
                case "Artistas":
                    filtro = relatoriosPersonalizados.labelSelecionePorArtistas.getText();
                    relatoriosPersonalizados.labelSelecionePorArtistas.click();
                    scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    highlightElement(relatoriosPersonalizados.labelSelecionePorArtistas);
                    Thread.sleep(2000);
                    highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalFiltros = relatoriosPersonalizados.listaDeFiltros;

                    for (int i = 2; i <= totalFiltros.size(); i++) {
                        clicarElementosLista(i);
                    }
                    break;
                case "Albuns":
                    filtro = relatoriosPersonalizados.labelSelecionePorAlbuns.getText();
                    relatoriosPersonalizados.labelSelecionePorAlbuns.click();
                    scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    highlightElement(relatoriosPersonalizados.labelSelecionePorAlbuns);
                    Thread.sleep(2000);
                    highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalFiltros = relatoriosPersonalizados.listaDeFiltros;

                    for (int i = 2; i <= totalFiltros.size(); i++) {
                        clicarElementosLista(i);
                    }
                    break;
                case "Faixas":
                    filtro = relatoriosPersonalizados.labelSelecionePorFaixas.getText();
                    relatoriosPersonalizados.labelSelecionePorFaixas.click();
                    scrollAteElemento(relatoriosPersonalizados.btnSeguinteRelatorio);
                    highlightElement(relatoriosPersonalizados.labelSelecionePorFaixas);
                    Thread.sleep(2000);
                    highlightElement(relatoriosPersonalizados.btnNenhumSelecionado);
                    relatoriosPersonalizados.btnNenhumSelecionado.click();
                    totalFiltros = relatoriosPersonalizados.listaDeFiltros;

                    for (int i = 2; i <= totalFiltros.size(); i++) {
                        clicarElementosLista(i);
                    }
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void alterarPosicaoColunas() {
        try {
            nomeColunas = new ArrayList<String>();
            for (WebElement nome : relatoriosPersonalizados.nomeColunas) {
                nomeColunas.add(nome.getText());
            }
            escreveStep("Alterar a ordem das colunas: " + nomeColunas.get(1) + " -> " + nomeColunas.get(2) + ", " + nomeColunas.get(5) + " -> " + nomeColunas.get(6) + ", " + nomeColunas.get(9) + " -> " + nomeColunas.get(10));
            inserePrint();
            trocarPosicaoDeColunas(nomeColunas.get(1), nomeColunas.get(2));
            trocarPosicaoDeColunas(nomeColunas.get(5), nomeColunas.get(6));
            trocarPosicaoDeColunas(nomeColunas.get(9), nomeColunas.get(10));

            inserePrint();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void excluirColunas() {
        try {
            escreveStep("Excluir todas as colunas");
            AcoesWeb.excluirColunas();
            inserePrint();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void informarShareArtista(Integer share) {
        try {
            escreveStep("Informar o share de 50% e clicar no botão Seguinte");
            aguardaElementoClicavel(relatoriosPersonalizados.inputShareArtista);
            relatoriosPersonalizados.inputShareArtista.sendKeys("5000");
            highlightElement(relatoriosPersonalizados.inputShareArtista);
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void validarDadosParaFiltro() {
        try {
            escreveStep("Validar os dados inseridos para filtro e clicar no botão Gerar");
            if (relatoriosPersonalizados.txtContaSelecionada.getText().contains(contaSelecionada)) {
                escreveDocumento("Conta selecionada: " + relatoriosPersonalizados.txtContaSelecionada.getText());
            } else {
                escreveErroTexto(contaSelecionada, relatoriosPersonalizados.txtContaSelecionada.getText());
            }
            if (servicoSelecionado.equals(relatoriosPersonalizados.txtServicoSelecionado.getText())) {
                escreveDocumento("Serviço selecionado: " + relatoriosPersonalizados.txtServicoSelecionado.getText());
            } else {
                escreveErroTexto(servicoSelecionado, relatoriosPersonalizados.txtServicoSelecionado.getText());
            }
            if (paisSelecionado.equals(relatoriosPersonalizados.txtPaisSelecionado.getText())) {
                escreveDocumento("País selecionado: " + relatoriosPersonalizados.txtPaisSelecionado.getText());
            } else {
                escreveErroTexto(paisSelecionado, relatoriosPersonalizados.txtPeriodoSelecionado.getText());
            }
            String periodoSelecionado = periodoInicial + " - " + periodoFinal;
            if (periodoSelecionado.equals(relatoriosPersonalizados.txtPeriodoSelecionado.getText())) {
                escreveDocumento("Período selecionado: " + relatoriosPersonalizados.txtPeriodoSelecionado.getText());
            } else {
                escreveErroTexto(periodoSelecionado, relatoriosPersonalizados.txtPeriodoSelecionado.getText());
            }
            String tipoRelatorio = relatoriosPersonalizados.txtTipoDeRelatorioEFiltro.getText();
            if (tipoRelatorio.contains(tipoDeRelatorio)) {
                escreveDocumento("Tipo de relatório " + tipoRelatorio);
            } else {
                escreveErroTexto(tipoDeRelatorio, tipoRelatorio);
            }
            String colunas = "";  //= "Store, Format, Period, Track, ISRC, Artist(s), Label, Album, Author(s), UPC, Currency Code, QTY, UnitValue, FinalValue, Plano";
            for (int i = 0; i < nomeColunas.size(); i++) {
                colunas += nomeColunas.get(i) + ", ";
            }
            ;
            if (colunas.substring(0, colunas.length() - 2).equals(relatoriosPersonalizados.txtColunas.getText())) {
                escreveDocumento("Colunas " + relatoriosPersonalizados.txtColunas.getText());
            } else {
                escreveErroTexto(colunas, relatoriosPersonalizados.txtColunas.getText());
            }
            String filtroShare = "Usar filtro de share - 50.00 % (Share por artista)";
            if (filtroShare.equals(relatoriosPersonalizados.txtFiltroshare.getText())) {
                escreveDocumento(relatoriosPersonalizados.txtFiltroshare.getText());
            } else {
                escreveErroTexto(filtroShare, relatoriosPersonalizados.btnFiltoShare.getText());
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }
    }

    public void validarRelatorioDePedidos() {
        try {
            escreveStep("Validar o Relatório de Pedidos");
            rolarPaginaParaBaixo();
            Thread.sleep(2000);
            inserePrint();
            String periodo = periodoInicial.replace("/", "-") + " a " + periodoFinal.replace("/", "-");
            if (relatoriosPersonalizados.txtRelatorioDePedidosPeriodo.getText().equals(periodo)) {
                escreveDocumento("Período:  " + relatoriosPersonalizados.txtRelatorioDePedidosPeriodo.getText());
            } else {
                escreveErroTexto(periodo, relatoriosPersonalizados.txtRelatorioDePedidosPeriodo.getText());
            }
            if (tipoDeRelatorio.equals("Relatórios Unificados")) {
                if (relatoriosPersonalizados.txtRelatorioDePedidosTipoDeRelatorio.getText().equalsIgnoreCase(tipoDeRelatorio.replace("s", ""))) {
                    escreveDocumento("Tipo de relatório:  " + relatoriosPersonalizados.txtRelatorioDePedidosTipoDeRelatorio.getText());
                } else {
                    escreveErroTexto(tipoDeRelatorio, relatoriosPersonalizados.txtRelatorioDePedidosTipoDeRelatorio.getText());
                }
            } else {
                if (relatoriosPersonalizados.txtRelatorioDePedidosTipoDeRelatorio.getText().equalsIgnoreCase(tipoDeRelatorio.replace("u", "ú"))) {
                    escreveDocumento("Tipo de relatório:  " + relatoriosPersonalizados.txtRelatorioDePedidosTipoDeRelatorio.getText());
                } else {
                    escreveErroTexto(tipoDeRelatorio, relatoriosPersonalizados.txtRelatorioDePedidosTipoDeRelatorio.getText());
                }
            }
            if (relatoriosPersonalizados.txtRelatorioDePedidosCatalogo.getText().equalsIgnoreCase(filtro.replace("Selecione por ", "Filtrado por "))) {
                escreveDocumento("Catálogo:  " + relatoriosPersonalizados.txtRelatorioDePedidosCatalogo.getText());
            } else {
                escreveErroTexto(filtro, relatoriosPersonalizados.txtRelatorioDePedidosCatalogo.getText());
            }
            qtdeRoyalties = relatoriosPersonalizados.txtRelatorioDePedidosQtdeRoyalties.getText();
            escreveDocumento("Quantidade de Royalties: " + qtdeRoyalties);

            Date dataAtual = new Date();
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
            if (relatoriosPersonalizados.txtRelatorioDePedidosDtGeracao.getText().equals(dataFormatada)) {
                escreveDocumento("Data de Geração:  " + relatoriosPersonalizados.txtRelatorioDePedidosDtGeracao.getText());
            } else {
                escreveErroTexto(dataFormatada, relatoriosPersonalizados.txtRelatorioDePedidosDtGeracao.getText());
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
            erro ++;
        }

    }
}


