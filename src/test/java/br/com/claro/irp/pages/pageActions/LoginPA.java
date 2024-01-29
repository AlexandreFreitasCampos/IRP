package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.criaDocumento;
import static br.com.claro.irp.utils.PDF.escreveDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveStep;
import static br.com.claro.irp.utils.PDF.escreveTitulo;
import static br.com.claro.irp.utils.PDF.insereCaBecalho;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.PDF.salvaDocumento;
import static br.com.claro.irp.utils.TiraPrint.screenShot;

import java.text.DecimalFormat;

import br.com.claro.irp.pages.pageObjects.LoginPO;
import br.com.claro.irp.pages.pageObjects.MenuPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;


public class LoginPA extends DriverFactory{
	LoginPO acaoLogin = new LoginPO();
	MenuPO acaoMenu = new MenuPO();
	acoesWeb acaoWeb = new acoesWeb();
	
	
	public void getURL(String string) {
		try {
			switch (string) {
			case "https://irp-hmg.imusica.com.br/Account/Login":
				criaDocumento("realizarloginIRP");
				insereCaBecalho();
				escreveTitulo("Realizar login no 'IRP'");
				escreveDocumento("Precondição:\nPossuir uma conta cadastrada no 'IRP'");
				escreveStep("Validar a 'URL' " + string);
				acaoWeb.getURL(string);
				break;
			default:
				escreveStep("Validar a 'URL' " + string);
				acaoWeb.getURL(string);
				break;
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void clicarBotao(String string) {
		try {
			switch (string) {
			case "Acessar":
				acaoLogin.btnAcessar.click();
				break;
			case "Log in":
				escreveStep("Inserir o código de autenticação e clicar em 'Log in'");
				screenShot();
				inserePrint();
				acaoLogin.btnLogin.click();
				acaoWeb.aguardaElementoPresente(acaoMenu.btnSair);
				salvaDocumento();
				break;
			case "Login":
				acaoLogin.btnLogin.click();
				break;	
			}
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}
		
	}

	
	public void setTexto(String string) {
		try {
			switch (string) {
			case "login gravadora":
				string = "alexandre.campos.recorder";
				escreveStep("Inserir usuário e senha e clicar em 'Acessar'");
				acaoLogin.inputUsuario.click();
				acaoLogin.inputUsuario.clear();
				acaoLogin.inputUsuario.sendKeys(string);
				break;
			case "login editora":
				string = "alexandre.campos.editor";
				escreveStep("Inserir usuário e senha e clicar em 'Acessar'");
				acaoLogin.inputUsuario.click();
				acaoLogin.inputUsuario.clear();
				acaoLogin.inputUsuario.sendKeys(string);
				break;	
			case "login gravadora/editora":
				string = "alexandre.campos";
				escreveStep("Inserir usuário e senha e clicar em 'Acessar'");
				acaoLogin.inputUsuario.click();
				acaoLogin.inputUsuario.clear();
				acaoLogin.inputUsuario.sendKeys(string);
				break;
			case "senha":
				string = "@Gg190504";
				acaoLogin.inputSenha.click();
				acaoLogin.inputSenha.clear();
				acaoLogin.inputSenha.sendKeys(string);
				screenShot();
				inserePrint();
				break;
			case "código recebido":
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
				//escreveStep("Inserir o código 2FA e clicar em 'Log in'");
				//screenShot();
				//inserePrint();
				break;

			}
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}
	}

	
	public void getComponente(String string) {
		/*try {
			switch (string) {
			case "filtro de países":
				List<String> paises = Arrays.asList("português (Brasil)", "inglês (Estados Unidos)",
						"espanhol (México)");

				List<String> getPaises = new ArrayList<String>();
				for (WebElement pais : acaoLogin.filtroPaises) {
					getPaises.add(pais.getText());
				}

				String pais = getPaises.toString();
				escreveDocumento("Idiomas: " + pais.replace("[", "").replace("]", ""));

				for (int i = 0; i < getPaises.size(); i++) {
					if (!paises.get(i).equals(getPaises.get(i))) {
						escreveErroTexto(paises.get(i), getPaises.get(i));
					}
				}
				break;
			case "texto codigo":
				elementoPresente = acaoLogin.inputCodigoAutenticacao.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto: Código de autenticação");
				} else {
					escreveErroComponente("Campo texto 'Código de autenticação'");
				}
				break;
			}
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}*/

	}
}
