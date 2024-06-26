package br.com.claro.steps;


import br.com.claro.pages.pageActions.LoginPA;
import br.com.claro.pages.pageActions.RelatoriosPersonalizadosPA;
import br.com.claro.utils.AcoesWeb;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static br.com.claro.utils.PDF.escreveStep;

public class StepsDefinition {
    public StepsDefinition() {

    }
    LoginPA login = new LoginPA();
    RelatoriosPersonalizadosPA relatoriosPersonalizados = new RelatoriosPersonalizadosPA();
    AcoesWeb acaoWeb = new AcoesWeb();

    @Dado("que criei o arquvio PDF {string} {string} {string}")
    public void queCrieiOArquvioPDF(String string, String string2, String string3) {
        if (string.equals("realizarloginIRP")) {
            login.criarArquvioPDF(string, string2);
        } else {
            relatoriosPersonalizados.criarArquvioPDF(string, string2, string3);
        }

    }

    @Quando("valido a URL {string}")
    public void validoAURL(String string) {
        escreveStep("Validar a 'URL' " + string);
        acaoWeb.getURL(string);
    }

    @Quando("insiro o usuario {string}")
    public void insiroOUsuario(String string) {
        login.inserirUsuario(string);
    }

    @Quando("insiro a senha {string}")
    public void insiroASenha(String string) {
        login.inserirSenha(string);
    }

    @Quando("insiro o codigo {string}")
    public void insiroOCodigo(String string) {
        login.inserirCodigo(string);
    }

    @Quando("clico no menu {string}")
    public void clicoNoMenu(String string) {
        relatoriosPersonalizados.clicarMenu(string);
    }

    @Quando("seleciono a opcao {string}")
    public void selecionoAOpcao(String string) {
        relatoriosPersonalizados.selecionarOpcaoConta(string);
    }

    @Quando("seleciono a conta {string}")
    public void selecionoAConta(String string) {
        relatoriosPersonalizados.selecionarConta(string);
    }

    @Quando("clico no botao {string}")
    public void clicoNoBotao(String string) {
        switch (string) {
            case "Acessar":
            case "Log in":
                login.clicarBotao(string);
                break;
            case "Seguinte Conta":
            case "Seguinte Servico":
            case "Seguinte Pais":
            case "Seguinte Periodo":
            case "Seguinte relatorio":
            case "Resetar colunas":
            case "Usar filtro de share":
            case "Seguinte Colunas":
            case "Gerar":
            case "Ok":
            case "Download":
            case "Excluir":
            case "Voltar":
                relatoriosPersonalizados.clicarBotao(string);
                break;
        }
    }

    @Quando("seleciono o servico {string}")
    public void selecionoOServico(String string) {
        relatoriosPersonalizados.selecionarServico(string);
    }

    @Quando("seleciono o Pais {string}")
    public void selecionoOPais(String string) {
        relatoriosPersonalizados.selecionarPais(string);
    }

    @Quando("seleciono o periodo Inicial {string}")
    public void selecionoOPeriodoInicial(String string) {
        relatoriosPersonalizados.selecionarPeriodoInicial(string);
    }

    @Quando("seleciono o periodo Final {string}")
    public void selecionoOPeriodoFinal(String string) {
        relatoriosPersonalizados.selecionarPeriodoFinal(string);
    }

    @Quando("seleciono o tipo de relatorio {string}")
    public void selecionoOTipoDeRelatorio(String string) {
        relatoriosPersonalizados.selecionarTipoDeRelatorio(string);
    }

    @Quando("seleciono o filtro {string}")
    public void selecionoOFiltro(String string) {
        relatoriosPersonalizados.selecionarFiltroDeRelatorio(string);
    }

    @Quando("altero a ordem das colunas")
    public void alteroAOrdemDasColunas() {
        relatoriosPersonalizados.alterarPosicaoColunas();
    }

    @Quando("deleto as colunas")
    public void deletoAsColunas() {
        relatoriosPersonalizados.excluirColunas();
    }

    @Quando("informo o Share por artista {int}")
    public void informoOSharePorArtista(Integer share) {
        relatoriosPersonalizados.informarShareArtista(share);
    }

    @Quando("valido os dados inseridos")
    public void validoOsDadosInseridos() {
        relatoriosPersonalizados.validarDadosParaFiltro();
    }
    @Quando("valido os dados do relatorio de pedido")
    public void validoOsDadosDoRelatorioDePedido() {
        relatoriosPersonalizados.validarRelatorioDePedidos();
    }

    @Entao("salvo o PDF {string}")
    public void salvoOPDF(String string) {
        if(string.equals("Login")){
            login.salvarPDF();
        }else {
            relatoriosPersonalizados.salvarPDF();
        }
    }
}
