package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.criaDocumento;
import static br.com.claro.irp.utils.PDF.escreveDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveErroTexto;
import static br.com.claro.irp.utils.PDF.escreveStep;
import static br.com.claro.irp.utils.PDF.escreveSubTitulo;
import static br.com.claro.irp.utils.PDF.escreveTitulo;
import static br.com.claro.irp.utils.PDF.insereCaBecalho;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.TiraPrint.screenShot;
import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import br.com.claro.irp.pages.pageObjects.FaturamentoPO;
import br.com.claro.irp.pages.pageObjects.LoginPO;
import br.com.claro.irp.pages.pageObjects.RelatoriosPO;
import br.com.claro.irp.utils.acoesWeb;

public class ValidarComponentesTelasPA{
	private LoginPO acaoLogin = new LoginPO();
	private RelatoriosPO acaoReporter = new RelatoriosPO();
	private FaturamentoPO acaoFaturamento = new FaturamentoPO();
	private br.com.claro.irp.utils.acoesWeb acoesWeb = new acoesWeb();

	private String textorecebido;
	private Boolean elementoPresente;
	
	public void getTexto(String string) {
		try {
			switch (string) {
			case "Bem-vindo ao IRP":
				System.out.println("Criando o documento");
				criaDocumento("validar_telas_sistema");
				insereCaBecalho();
				escreveTitulo("Validar as telas do sistema");
				escreveSubTitulo("Precondição:\nPossuir uma conta no 'IRP'");
				escreveStep("Validar os componentes da tela de 'Login'");
				screenShot();
				inserePrint();
				escreveSubTitulo("Tela:");
				textorecebido = acaoLogin.textoBemVindo.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Usuário":
				textorecebido = acaoLogin.inputUsuario.getAttribute("placeholder");
				assertEquals(textorecebido, string);
				escreveDocumento("Campo texto: " + textorecebido);
				break;
			case "Senha":
				textorecebido = acaoLogin.inputSenha.getAttribute("placeholder");
				assertEquals(textorecebido, string);
				escreveDocumento("Campo texto: " + textorecebido);
				break;
			case "Lembrar de mim?":
				textorecebido = acaoLogin.textoLembrar.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Acessar":
				textorecebido = acaoLogin.btnAcessar.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Botão: " + textorecebido);
				break;
			case "Esqueceu sua senha?":
				textorecebido = acaoLogin.textoEsqueceuSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "© 2023 - iMusica (Claro S.A.)":
				escreveSubTitulo("Rodapé:");
				textorecebido = acaoLogin.textoCopyright.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Download do manual":
				textorecebido = acaoLogin.textoDownloadManual.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Idioma":
				textorecebido = acaoLogin.textoIdioma.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Usamos cookies...":
				string = "Usamos cookies para garantir que você obtenha a melhor experiência em nosso site. Ao clicar em "
						+ "\"Aceitar\",\nvocê concorda que podemos usar esses cookies. Clique em políticas de privacidade para consultar"
						+ " mais informações. Aceitar";
				textorecebido = acaoLogin.textoCookies.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido.substring(0, 220).replace("\n", " "));
				break;
			case "Aceitar":
				textorecebido = acaoLogin.btnAceitar.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Botão: " + textorecebido);
				acaoLogin.inputUsuario.sendKeys("alexandre.campos");
				acaoLogin.inputSenha.sendKeys("@Gg190504");
				acaoLogin.btnAcessar.click();
				break;
			case "Autenticação de dois fatores":
				escreveStep("Validar os componentes da  tela de 'Autenticação de dois fatores'");
				screenShot();
				inserePrint();
				escreveSubTitulo("Tela:");
				textorecebido = acaoLogin.textoMFA.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Seu login está protegido com um aplicativo de autenticação. Entre com seu código de autenticação abaixo.":
				textorecebido = acaoLogin.textoLoginProtegido.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Código de autenticação":
				textorecebido = acaoLogin.textoCodigoAutenticacao.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Lembrar desta máquina":
				textorecebido = acaoLogin.textoLembrarMaquina.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Log in":
				textorecebido = acaoLogin.btnLogin.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Botão: " + textorecebido);
				break;
			case "Não possui acesso ao dispositivo de autenticação? Você pode logar com um código de recuperação.":
				textorecebido = acaoLogin.textoNaoPossuiAcesso.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Filtro de relatórios":
				escreveSubTitulo("Filtro de relatórios:");
				textorecebido = acaoReporter.textoFiltroDeRelatorios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Conta":
				textorecebido = acaoReporter.textoConta.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Serviço":
				textorecebido = acaoReporter.textoSerivico.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "País":
				textorecebido = acaoReporter.textoPais.getText();
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Período Inicial":
				textorecebido = acaoReporter.textoPeriodoInicial.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Período Final":
				textorecebido = acaoReporter.textoPeriodoFinal.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Status":
				textorecebido = acaoReporter.textoStatus.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			}	
			
			
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}	
	}

	
	public void clicarBotao(String string) {
		try {
			switch (string) {
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
				break;
			}
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}
		
	}

	
	public void getComponente(String string) {
		try {
			switch (string) {
			case "texto codigo":
				elementoPresente = acaoLogin.inputCodigoAutenticacao.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto: Código de autenticação");
				} else {
					escreveErroComponente("Campo texto 'Código de autenticação'");
				}
				break;
			/*case "Relatórios":
				elementoPresente = acaoReporter.menuRelatorios.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Relatórios'");
				} else {
					escreveErroComponente("Menu 'Relatórios'");
				}
				break;
			case "Faturamento":
				elementoPresente = acaoReporter.menuFaturamento.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Faturamento'");
				} else {
					escreveErroComponente("Menu 'Faturamento'");
				}
				break;	
			case "Histórico de Faturas":
				elementoPresente = acaoReporter.menuHistóricoDeFaturas.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Histórico de Faturas'");
				} else {
					escreveErroComponente("Menu 'Histórico de Faturas'");
				}
				break;		
			case "Admin":
				elementoPresente = acaoReporter.menuAdmin.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Admin'");
				} else {
					escreveErroComponente("Menu 'Admin'");
				}
				break;	
			case "Idiomas":
				acoesWeb.aguardaListaPresente(acaoReporter.listaIdiomas);
				listaEsperada = Arrays.asList("português (Brasil)", "inglês (Estados Unidos)", "espanhol (México)");

				listaRecebida = new ArrayList<>();
				for (WebElement paises : acaoReporter.listaIdiomas) {
					listaRecebida.add(paises.getText());
				}
				textorecebido = listaRecebida.toString();
				escreveDocumento("Países: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "Botão Sair":
				elementoPresente = acaoReporter.menuRelatorios.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				break;	*/
			case "Botão Listar":
				elementoPresente = acaoReporter.btnListar.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				
				break;	
			}
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}
		
	}
}
