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
import static br.com.claro.irp.utils.PDF.salvaDocumento;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.claro.irp.pages.pageObjects.ContasPO;
import br.com.claro.irp.pages.pageObjects.RelatoriosPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class RelatoriosPA extends DriverFactory{
	private RelatoriosPO acaoRelatorios = new RelatoriosPO();
	private  ContasPO acaoContas = new ContasPO();
	private acoesWeb acaoWeb = new acoesWeb();
	private boolean fim = false;

	private String textorecebido;
	private Boolean elementoPresente;
	private List<String> listaEsperada;
	private List<String> listaRecebida;

	
	public void getURL(String string) {
		try {
			switch (string) {
			case "https://irp.imusica.com.br/Recorders/Reports/Reports":
				criaDocumento("reportshome");
				insereCaBecalho();
				escreveTitulo("Validar a tela de 'Home'");
				escreveDocumento("Precondição:\nTer efetuado login no 'IRP'");
				escreveStep("Validar a 'URL' " + string);
				acaoWeb.getURL(string);
				break;
			default:
				escreveStep("Validar a 'URL' " + string);
				acaoWeb.getURL(string);
				break;
			}
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

	
	public void getTexto(String string) {
		try {
			switch (string) {
			case "Filtro de relatórios":
				escreveSubTitulo("Filtro de relatórios:");
				textorecebido = acaoRelatorios.textoFiltroDeRelatorios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Conta":
				textorecebido = acaoRelatorios.textoConta.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Serviço":
				textorecebido = acaoRelatorios.textoSerivico.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "País":
				textorecebido = acaoRelatorios.textoPais.getText();
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Período Inicial":
				textorecebido = acaoRelatorios.textoPeriodoInicial.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Período Final":
				textorecebido = acaoRelatorios.textoPeriodoFinal.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Status":
				textorecebido = acaoRelatorios.textoStatus.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Usamos cookies...":
				string = "Usamos cookies para garantir que você obtenha a melhor experiência em nosso site. Ao clicar em \"Aceitar\", "
						+ "você concorda que podemos usar esses cookies. Clique em políticas de privacidade para consultar mais informações.";
				textorecebido = acaoRelatorios.textoUsamosCookies.getText().replace(" Aceitar", "").replace("\n", " ");
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Troca de senha":
				textorecebido = acaoRelatorios.btnTrocaDeSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Registro de Usuários":
				textorecebido = acaoRelatorios.btnRegistroDeUsuarios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Registro de usuário":
				Thread.sleep(5000);
				escreveStep("Validar a tela 'Registro de usuário'");

				inserePrint();
				textorecebido = acaoRelatorios.textoRegistroDeUsuario.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Listagem de Usuários":
				textorecebido = acaoRelatorios.btnListagemDeUsuarios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Resetar 2FA":
				textorecebido = acaoRelatorios.btnResetar2FA.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Trocar Senha":
				textorecebido = acaoRelatorios.textoTrocarSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Título: " + textorecebido);
				break;
			case "Senha atual":
				textorecebido = acaoRelatorios.textoSenhaAtual.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Nova senha":
				textorecebido = acaoRelatorios.textoNovaSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Confirme a senha":
				textorecebido = acaoRelatorios.textoConfirmeASenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Nome":
				textorecebido = acaoRelatorios.textoNome.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Email":
				textorecebido = acaoRelatorios.textoEmail.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Usuário":
				textorecebido = acaoRelatorios.textoUsuario.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Perfil":
				textorecebido = acaoRelatorios.textoPerfil.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Gravadora/Editora":
				textorecebido = acaoRelatorios.textoGravadoraEditora.getText();
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
			case "Seguinte":
				acaoRelatorios.btnSeguinteConta.click();
				break;
			case "SeguinteCountry":
				acaoRelatorios.btnSeguinteServico.click();
				break;
			case "SeguintePeriod":
				acaoRelatorios.btnSeguintePais.click();
				break;
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
			case "Lista conta":
				listaEsperada = Arrays.asList("Todos");
				listaRecebida = new ArrayList<>();
				for (WebElement contas : acaoRelatorios.listaContas) {
					listaRecebida.add(contas.getText());
				}

				escreveStep("Validar a lista de  'Contas'");
				acaoRelatorios.selectContas.click();

				inserePrint();

				textorecebido = listaRecebida.toString();
				escreveDocumento("Contas: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}

				break;
			case "Lista serviço":
				listaEsperada = Arrays.asList("Todos");

				listaRecebida = new ArrayList<>();
				for (WebElement servicos : acaoRelatorios.listaServicos) {
					listaRecebida.add(servicos.getText());
				}

				escreveStep("Validar a lista de  'Serviços'");
				acaoRelatorios.selectServicos.click();

				inserePrint();

				textorecebido = listaRecebida.toString();
				escreveDocumento("Serviços: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "Lista país":
				listaEsperada = Arrays.asList("Todos", "N/A");

				listaRecebida = new ArrayList<>();
				for (WebElement paises : acaoRelatorios.listaPaises) {
					listaRecebida.add(paises.getText());
				}

				escreveStep("Validar a lista de  'Países'");
				acaoRelatorios.selectPaises.click();

				inserePrint();

				textorecebido = listaRecebida.toString();
				escreveDocumento("Países: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "status":
				listaEsperada = Arrays.asList("Todos", "Aguardando Liberação", "Liberado para download / Não baixado",
						"Baixado / Aguardando fatura", "Faturado / Aguardando Aprovação", "Fatura Aprovada",
						"Fatura Rejeitada", "Fatura Paga", "Enviado via FTP/Aguardando Fatura");

				listaRecebida = new ArrayList<>();
				for (WebElement status : acaoRelatorios.listaStatus) {
					listaRecebida.add(status.getText());
				}

				escreveStep("Validar a lista de  'Status'");
				acaoRelatorios.selectStatus.click();
				Thread.sleep(1000);

				inserePrint();

				textorecebido = listaRecebida.toString();
				escreveDocumento("Status: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "Botão Listar":
				elementoPresente = acaoRelatorios.btnListar.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				break;
			case "Botão Aceitar":
				elementoPresente = acaoRelatorios.btnAceitar.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				break;
			case "Campo texto 'Nome'":
				elementoPresente = acaoRelatorios.campoTextoNome.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto 'Nome'");
				} else {
					escreveErroComponente("Campo texto 'Nome'");
				}
				break;
			case "Campo texto 'Email'":
				elementoPresente = acaoRelatorios.campoTextoEmail.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto 'Email'");
				} else {
					escreveErroComponente("Campo texto 'Email'");
				}
				break;
			case "Campo texto 'Usuário'":
				elementoPresente = acaoRelatorios.campoTextoUsuario.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto 'Usuário'");
				} else {
					escreveErroComponente("Campo texto 'Usuário'");
				}
				break;
			/*
			 * case "Botão Salvar": elementoPresente =
			 * acaoRelatorios.btnSalvar.isDisplayed(); if (elementoPresente) {
			 * escreveDocumento(string); acaoRelatorios.menuRelatorios.click(); } else {
			 * escreveErroComponente(string); } break;
			 */
			case "Campo texto 'Perfil'":
				listaEsperada = Arrays.asList("iMusica", "Royalties", "Recorders", "Editors", "RecordersAndEditors");

				listaRecebida = new ArrayList<>();
				for (WebElement perfis : acaoRelatorios.listaPerfil) {
					listaRecebida.add(perfis.getText());
				}

				escreveStep("Validar a lista de  'Perfis'");
				acaoRelatorios.selectPerfil.click();

				inserePrint();

				textorecebido = listaRecebida.toString();
				escreveDocumento("Perfis: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "Gravadora/Editora":
				listaEsperada = Arrays.asList("Todos", "Dabliú Discos (Gravadora)",
						"zzz - Cogumelo (Gravadora) INOPERANTE", "Nikita Music (Editora/Gravadora)",
						"Rob Digital (Gravadora)");

				escreveStep("Validar a lista de  'Gravadoras/Editoras'");
				acaoRelatorios.selectGravadorEditora.click();
				Thread.sleep(1000);

				inserePrint();

				listaRecebida = new ArrayList<String>(acaoWeb.listaGravadoras());

				textorecebido = listaRecebida.toString();
				escreveDocumento("Gravadoras/Editoras: " + textorecebido.replace("[", "").replace("]", "") + "...");

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "Serviço":
				listaEsperada = Arrays.asList("Todos", "Claromusica", "RBT", "Combo Hits", "Tag", "iMusicaFM",
						"Claromusica Play", "iTunes USD", "iTunes CAD", "iTunes MXN", "iTunes All", "Deezer", "Spotify",
						"Youtube", "Google Play", "Facebook", "iTunes", "Apple Music", "Napster", "Pandora",
						"Outros OTTs", "Ott Unificado");

				escreveStep("Validar a lista de  'Serviços'");
				acaoRelatorios.selectServico.click();
				Thread.sleep(1000);

				inserePrint();

				listaRecebida = new ArrayList<>();
				for (WebElement servico : acaoRelatorios.listaServicoRegistro) {
					listaRecebida.add(servico.getText());
				}

				textorecebido = listaRecebida.toString();
				escreveDocumento("Serviços: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "País":
				listaEsperada = Arrays.asList("Todos", "ARGENTINA", "BRAZIL", "CHILE", "COLOMBIA", "COSTA RICA",
						"DOMINICAN REPUBLIC", "ECUADOR", "GUATEMALA", "HONDURAS", "MEXICO", "NICARAGUA", "PANAMA",
						"PERU", "PARAGUAY", "EL SALVADOR", "URUGUAY");

				escreveStep("Validar a lista de  'Países'");
				acaoRelatorios.selectPais.click();
				Thread.sleep(1000);

				inserePrint();

				listaRecebida = new ArrayList<>();
				for (WebElement pais : acaoRelatorios.listaPaisRegistro) {
					listaRecebida.add(pais.getText());
				}

				textorecebido = listaRecebida.toString();
				escreveDocumento("Países: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			/*
			 * case "Conta": if(acaoRelatorios.textoSelecaoDecontas.isDisplayed()) {
			 * AcoesWeb.clicarIndicealeatorio(acaoRelatorios.selectContasRelPesonalizado);
			 * acaoRelatorios.btnSeguintecontas.click(); } break;
			 */
			}
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}
}
