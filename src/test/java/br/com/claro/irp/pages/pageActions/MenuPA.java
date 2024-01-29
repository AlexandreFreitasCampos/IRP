package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.escreveDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveErroTexto;
import static br.com.claro.irp.utils.PDF.escreveStep;
import static br.com.claro.irp.utils.PDF.escreveSubTitulo;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.TiraPrint.screenShot;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.claro.irp.pages.pageObjects.MenuPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class MenuPA extends DriverFactory {

	MenuPO acaoMenu = new MenuPO();
	br.com.claro.irp.utils.acoesWeb acoesWeb = new acoesWeb();

	private String textorecebido;
	private Boolean elementoPresente;
	private List<String> listaEsperada;
	private List<String> listaRecebida;

	public void getURL(String string) {
		// TODO Auto-generated method stub

	}

	public void getTexto(String string) {
		try {
			switch (string) {
			case "IRP (BETA )":
				escreveStep("Validar os componentes da tela de 'Relatórios'");
				screenShot();
				inserePrint();
				escreveSubTitulo("Barra de menu:");
				textorecebido = acaoMenu.textoIRP.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Saudação":
				textorecebido = acaoMenu.textoOla.getText();
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
			case "Admin":
				escreveStep("Validar o menu 'Admin'");
				acaoMenu.menuAdmin.click();
				screenShot();
				inserePrint();
				break;
			/*
			 * case "Troca de senha" : acaoMenu.btnTrocaDeSenha.click();
			 * acaoMenu.btnAceitar.click();
			 * escreveStep("Validar a tela de troca de 'Senha'"); screenShot();
			 * inserePrint(); break; case "Registro de Usuários":
			 * acaoMenu.menuAdmin.click(); acaoMenu.btnRegistroDeUsuarios.click();
			 * acoesWeb.aguardaElementoPresente(acao.textoNenhumSelecionado); break;
			 */
			/*
			 * case "Botão Salvar": elementoPresente = acaoMenu.btnSalvar.isDisplayed(); if
			 * (elementoPresente) { escreveDocumento(string); acao.menuRelatorios.click(); }
			 * else { escreveErroComponente(string); } break;
			 */
			}
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

	public void getComponente(String string) {
		try {
			switch (string) {
			case "Relatórios":
				elementoPresente = acaoMenu.menuRelatorios.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Relatórios'");
				} else {
					escreveErroComponente("Menu 'Relatórios'");
				}
				break;
			case "Faturamento":
				elementoPresente = acaoMenu.menuFaturamento.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Faturamento'");
				} else {
					escreveErroComponente("Menu 'Faturamento'");
				}
				break;
			case "Histórico de Faturas":
				elementoPresente = acaoMenu.menuHistóricoDeFaturas.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Histórico de Faturas'");
				} else {
					escreveErroComponente("Menu 'Histórico de Faturas'");
				}
				break;
			case "Admin":
				elementoPresente = acaoMenu.menuAdmin.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Admin'");
				} else {
					escreveErroComponente("Menu 'Admin'");
				}
				break;
			case "Idiomas":
				acoesWeb.aguardaListaPresente(acaoMenu.listaIdiomas);
				listaEsperada = Arrays.asList("português (Brasil)", "inglês (Estados Unidos)", "espanhol (México)");

				listaRecebida = new ArrayList<>();
				for (WebElement paises : acaoMenu.listaIdiomas) {
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
				elementoPresente = acaoMenu.menuRelatorios.isDisplayed();
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
