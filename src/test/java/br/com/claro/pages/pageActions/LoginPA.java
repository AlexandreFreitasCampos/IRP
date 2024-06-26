package br.com.claro.pages.pageActions;


import br.com.claro.pages.pageObjects.LoginPO;
import br.com.claro.pages.pageObjects.RelatoriosPersonalizdosPO;
import br.com.claro.utils.AcoesWeb;

import java.text.DecimalFormat;

import static br.com.claro.utils.PDF.*;


public class LoginPA{
    private final RelatoriosPersonalizdosPO acaoRelatorios = new RelatoriosPersonalizdosPO();
    private final LoginPO acaoLogin = new LoginPO();

    public void criarArquvioPDF(String nomeArquivo, String servico) {
        try {
            if (nomeArquivo.contains("realizarloginIRP")) {
                criaDocumento(nomeArquivo);
                insereCaBecalho();
                escreveTitulo("Realizar login no sistema 'IRP'");
                escreveSubTitulo("Precondição:\nPossuir uma conta cadastrada");
            }
        } catch (Exception e) {
            escreveErroComponente("Falha ao criar o arquivo PDF!!!");
        }

    }

    public void inserirUsuario(String string) {
        try {
            AcoesWeb.highlightElement(acaoLogin.inputUsuario);
            //AcoesWeb.aguardaElementoPresente(acaoLogin.btnAceitar);
            if(acaoLogin.listBtnAceitar.size() > 0) {
                acaoLogin.btnAceitar.click();
            }
            escreveStep("Inserir usuário e senha e clicar em 'Acessar'");
            acaoLogin.inputUsuario.click();
            acaoLogin.inputUsuario.clear();
            acaoLogin.inputUsuario.sendKeys(string);
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void inserirSenha(String string) {
        AcoesWeb.highlightElement(acaoLogin.inputSenha);
        acaoLogin.inputSenha.click();
        acaoLogin.inputSenha.clear();
        acaoLogin.inputSenha.sendKeys(string);
    }

    public void clicarBotao(String string) {
        try {
            switch (string) {
                case "Acessar":
                    AcoesWeb.highlightElement(acaoLogin.btnAcessar);
                    Thread.sleep(200);
                    inserePrint();
                    acaoLogin.btnAcessar.click();
                    break;
                case "Log in":
                    AcoesWeb.highlightElement(acaoLogin.btnLogin);
                    Thread.sleep(200);
                    inserePrint();
                    acaoLogin.btnLogin.click();
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void inserirCodigo(String string) {
        AcoesWeb.highlightElement(acaoLogin.inputCodigoAutenticacao);
        try {
            if (string.equals("M2FA")) {
                int segundos = 0;
                int minutos = 0;
                int tamanhoTexto = 0;
                while (tamanhoTexto < 6) {
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                    DecimalFormat formatter = new DecimalFormat("00");
                    System.out.println("Aguardando código MFA " + formatter.format(minutos) + ":"
                            + formatter.format(segundos) + " segundos...");

                    Thread.sleep(1000);
                    tamanhoTexto = acaoLogin.inputCodigoAutenticacao.getAttribute("value").length();
                    segundos++;
                }
                escreveStep("Inserir o código 2FA e clicar em 'Log in'");
            }
        } catch (InterruptedException e) {
            escreveErroComponente(e.getMessage());
        }

    }

    public void salvarPDF() {
        salvaDocumento();
    }
}
