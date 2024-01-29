package br.com.claro.irp.steps;

import br.com.claro.irp.pages.pageActions.LoginPA2;
import br.com.claro.irp.pages.pageActions.RelatoriosPersonalizadosPA;
import br.com.claro.irp.pages.pageObjects.LoginPO;
import br.com.claro.irp.utils.acoesWeb;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static br.com.claro.irp.utils.PDF.escreveStep;

public class StepDefinition {
    acoesWeb acaoWeb = new acoesWeb();
    LoginPA2 login = new LoginPA2();
    LoginPO acaoLogin = new LoginPO();
    RelatoriosPersonalizadosPA relatorios = new RelatoriosPersonalizadosPA();

    @Dado("que criei o arquvio PDF {string}")
    public void queCrieiOArquvioPDF(String string) {
        switch (string) {
            case "realizarloginIRP":
                login.criarArquvioPDF(string);
                break;
            case "relatorio_personalizado_claro_musica_gra_edit":
            case "relatorio_personalizado_claro_musica_editora":
            case "relatorio_personalizado_claro_musica_gravadora":
            case "relatorio_personalizado_rbt_gra_edit":
            case "relatorio_personalizado_rbt_editora":
            case "relatorio_personalizado_rbt_gravadora":
            case "relatorio_personalizado_ott_unificado_gra_edit":
            case "relatorio_personalizado_ott_unificado_editora":
            case "relatorio_personalizado_ott_unificado_gravadora":
            case "relatorio_personalizado_ott_gra_edit":
            case "relatorio_personalizado_ott_editora":
            case "relatorio_personalizado_ott_gravadora":
                relatorios.criarArquvioPDF(string);
                break;
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
            case "Gerar":
                relatorios.clicarBotao(string);
                break;
        }
    }

    @Quando("insiro o codigo {string}")
    public void insiroOCodigo(String string) {
        login.inserirCodigo(string);
    }

    @Quando("clico no menu {string}")
    public void clicoNoMenu(String string) {
        switch (string) {
            case "Relatórios":
            case "Relatórios Personalizados":
                relatorios.clicarMenu(string);
                break;
        }
    }

    @Quando("seleciono a conta {string}")
    public void selecionoAConta(String string) {
        relatorios.selecionarConta(string);
    }

    @Quando("seleciono o servico {string}")
    public void selecionoOServico(String string) {
        relatorios.selecionarServico(string);
    }

    @Quando("seleciono o Pais")
    public void selecionoOPais() {
        relatorios.selecionarPais();
    }

    @Quando("seleciono o periodo {string}")
    public void selecionoOPeriodo(String string) {
        relatorios.selecionarPeriodo(string);
    }

    @Quando("valido os dados selecionados")
    public void validoOsDadosSelecionados() {
        relatorios.validarDadosSelecionados();
    }

    @Entao("salvo o PDF")
    public void salvoOPDF() {
        relatorios.salvarPDF();
    }

}
