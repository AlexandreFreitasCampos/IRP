package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.criaDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveStep;
import static br.com.claro.irp.utils.PDF.escreveTitulo;
import static br.com.claro.irp.utils.PDF.insereCaBecalho;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.TiraPrint.screenShot;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DecimalFormat;

import br.com.claro.irp.pages.pageObjects.ContasPO;
import br.com.claro.irp.pages.pageObjects.LoginPO;
import br.com.claro.irp.pages.pageObjects.MenuPO;
import br.com.claro.irp.pages.pageObjects.RelatoriosPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;
import br.com.claro.irp.utils.PDF;
import org.junit.Test;

public class LoginPA2 extends DriverFactory{
	private RelatoriosPO acaoRelatorios = new RelatoriosPO();
	private LoginPO acaoLogin = new LoginPO();
	private acoesWeb acaoWeb = new acoesWeb();


	public  void criarArquvioPDF(String string) {
		try {
			switch (string) {
			case "realizarloginIRP":
				criaDocumento(string);
				insereCaBecalho();
				escreveTitulo("Realizar login no sistema 'IRP'");
				PDF.escreveSubTitulo("Precondição:\nPossuir uma conta cadastrada");
				break;
			}
		} catch (Exception e) {
			escreveErroComponente("Falha ao criar o arquivo PDF!!!");
		}

	}
	public void inserirUsuario(String string) {
		switch (string) {
		case "alexandre.campos":
		case "alexandre.campos.recorder":
		case "alexandre.campos.editor":
			acaoWeb.aguardaElementoPresente(acaoRelatorios.btnAceitar);
			acaoRelatorios.btnAceitar.click();
			escreveStep("Inserir usuário e senha e clicar em 'Acessar'");
			acaoLogin.inputUsuario.click();
			acaoLogin.inputUsuario.clear();
			acaoLogin.inputUsuario.sendKeys(string);
			break;
		}
	}

	public void inserirSenha(String string) {
		switch (string) {
		case "@Gg190504":
			acaoLogin.inputSenha.click();
			acaoLogin.inputSenha.clear();
			acaoLogin.inputSenha.sendKeys(string);
			try {
				screenShot();
			} catch (IOException e) {
				PDF.escreveErroComponente(e.getMessage());
			} catch (AWTException e) {
				PDF.escreveErroComponente(e.getMessage());
			}
			inserePrint();
			break;
		}

	}
	public void clicarBotao(String string) {
		switch (string) {
		case "Acessar":
			acaoLogin.btnAcessar.click();
			break;
		case "Log in":
			acaoLogin.btnLogin.click();
			break;
		}
	}

	public void inserirCodigo(String string) {
		try {
			switch (string) {
			case "M2FA":
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
				inserePrint();
				break;
			}
		} catch (InterruptedException e) {
			escreveErroComponente(e.getMessage());
		}

	}
}
