package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.*;
import static br.com.claro.irp.utils.TiraPrint.screenShot;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.claro.irp.action.Action;
import br.com.claro.irp.pages.pageObjects.RelatoriosPO;
import br.com.claro.irp.pages.world.World;
import br.com.claro.irp.utils.AcoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class RelatoriosPA extends DriverFactory implements Action {
	RelatoriosPO acao = new RelatoriosPO();
	AcoesWeb acoesWeb = new AcoesWeb();
	World world = new World();

	private String textorecebido;
	private Boolean elementoPresente;
	private List<String> listaEsperada;
	private List<String> listaRecebida;

	@Override
	public void getURL(String string) {
		try {
			switch (string) {
			case "https://irp.imusica.com.br/Recorders/Reports/Reports":
				criaDocumento("reportshome");
				insereCaBecalho();
				escreveTitulo("Validar a tela de 'Home'");
				escreveDocumento("Precondição:\nTer efetuado login no 'IRP'");
				escreveStep("Validar a 'URL' " + string);
				AcoesWeb.getURL(string);
				break;
			default:
				escreveStep("Validar a 'URL' " + string);
				AcoesWeb.getURL(string);
				break;
			}
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

	@Override
	public void getTexto(String string) {
		try {
			switch (string) {
			/*case "Nome da Conta":
				if(acao.lblNomeDaConta.isDisplayed() && acao.textoNomeDaConta.isDisplayed()) {
					escreveSubTitulo("Dados da conta:");
					escreveDocumento(acao.lblNomeDaConta.getText() + ": " + acao.textoNomeDaConta.getText());
				}else {
					escreveErroTexto(string, null);
				}
				break;	
			case "ID Conta":
				if(acao.lblIdDaConta.isDisplayed() && acao.textoIdConta.isDisplayed()) {
					escreveDocumento(acao.lblIdDaConta.getText() + ": " + acao.textoIdConta.getText());
				}else {
					escreveErroTexto(string, null);
				}
				break;		
			case "Razão social":
				if(acao.lblRazaoSocial.isDisplayed() && acao.textoRazaoSocial.isDisplayed()) {
					escreveDocumento(acao.lblRazaoSocial.getText() + ": " + acao.textoRazaoSocial.getText());
				}else {
					escreveErroTexto(string, null);
				}
				break;		
			case "Moeda":
				if(acao.lblMoeda.isDisplayed() && acao.textoMoeda.isDisplayed()) {
					escreveDocumento(acao.lblMoeda.getText() + ": " + acao.textoMoeda.getText());
				}else {
					escreveErroTexto(string, null);
				}
				break;			
			case "Pagamento mínimo":
				if(acao.lblPagamentoMinimo.isDisplayed() && acao.textoPagamentoMinimo.isDisplayed()) {
					escreveDocumento(acao.lblPagamentoMinimo.getText() + ": " + acao.textoPagamentoMinimo.getText());
				}else {
					escreveErroTexto(string, null);
				}
				break;				
			case "Data de Cadastro":
				if(acao.lblDataDeCadastro.isDisplayed() && acao.textoDataDeCadastro.isDisplayed()) {
					escreveDocumento(acao.lblDataDeCadastro.getText() + ": " + acao.textoDataDeCadastro.getText());
				}else {
					escreveErroTexto(string, null);
				}
				break;			*/
				
				
				
			case "Filtro de relatórios":
				escreveSubTitulo("Filtro de relatórios:");
				textorecebido = acao.textoFiltroDeRelatorios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Conta":
				textorecebido = acao.textoConta.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Serviço":
				textorecebido = acao.textoSerivico.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "País":
				textorecebido = acao.textoPais.getText();
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Período Inicial":
				textorecebido = acao.textoPeriodoInicial.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Período Final":
				textorecebido = acao.textoPeriodoFinal.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Status":
				textorecebido = acao.textoStatus.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Usamos cookies...":
				string = "Usamos cookies para garantir que você obtenha a melhor experiência em nosso site. Ao clicar em \"Aceitar\", "
						+ "você concorda que podemos usar esses cookies. Clique em políticas de privacidade para consultar mais informações.";
				textorecebido = acao.textoUsamosCookies.getText().replace(" Aceitar", "").replace("\n", " ");
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Troca de senha":
				textorecebido = acao.btnTrocaDeSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Registro de Usuários":
				textorecebido = acao.btnRegistroDeUsuarios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			case "Registro de usuário":
				Thread.sleep(5000);
				escreveStep("Validar a tela 'Registro de usuário'");
				screenShot();
				inserePrint();
				textorecebido = acao.textoRegistroDeUsuario.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Listagem de Usuários":
				textorecebido = acao.btnListagemDeUsuarios.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			case "Resetar 2FA":
				textorecebido = acao.btnResetar2FA.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Trocar Senha":
				textorecebido = acao.textoTrocarSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Título: " + textorecebido);
				break;	
			case "Senha atual":
				textorecebido = acao.textoSenhaAtual.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;		
			case "Nova senha":
				textorecebido = acao.textoNovaSenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;		
			case "Confirme a senha":
				textorecebido = acao.textoConfirmeASenha.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;		
			/*case "Salvar":
				textorecebido = acao.btnSalvar.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Botão: " + textorecebido);
				//Actions clicar = new Actions(getDriver());
				//clicar.click(acao.menuRelatorios);
				acao.menuRelatorios.click();
				break;	*/
			case "Nome":
				textorecebido = acao.textoNome.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Email":
				textorecebido = acao.textoEmail.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Usuário":
				textorecebido = acao.textoUsuario.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;
			case "Perfil":
				textorecebido = acao.textoPerfil.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			case "Gravadora/Editora":
				textorecebido = acao.textoGravadoraEditora.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			/*case "Serviço":
				textorecebido = acao.textoSerivico.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			case "País":
				textorecebido = acao.textoPais.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Texto: "+ textorecebido);
				break;	*/	
			}	
			
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

	@Override
	public void clicarBotao(String string) {
		/*try {
			switch (string) {
			case "Admin"  :
				escreveStep("Validar o menu 'Admin'");
				acao.menuAdmin.click();
				screenShot();
				inserePrint();
				break;
			case "Troca de senha"  :
				acao.btnTrocaDeSenha.click();
				acao.btnAceitar.click();
				escreveStep("Validar a tela de troca de 'Senha'");
				screenShot();
				inserePrint();
				break;	
			case "Registro de Usuários":
				acao.menuAdmin.click();
				acao.btnRegistroDeUsuarios.click();
				acoesWeb.aguardaElementoPresente(acao.textoNenhumSelecionado);
				break;		
			}	
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}*/

	}

	@Override
	public void setTexto(String string) {

	}

	@Override
	public void getComponente(String string) {
		try {
			switch (string) {
			/*case "Relatórios":
				elementoPresente = acao.menuRelatorios.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Relatórios'");
				} else {
					escreveErroComponente("Menu 'Relatórios'");
				}
				break;
			case "Faturamento":
				elementoPresente = acao.menuFaturamento.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Faturamento'");
				} else {
					escreveErroComponente("Menu 'Faturamento'");
				}
				break;	
			case "Histórico de Faturas":
				elementoPresente = acao.menuHistóricoDeFaturas.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Histórico de Faturas'");
				} else {
					escreveErroComponente("Menu 'Histórico de Faturas'");
				}
				break;		
			case "Admin":
				elementoPresente = acao.menuAdmin.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Menu 'Admin'");
				} else {
					escreveErroComponente("Menu 'Admin'");
				}
				break;
			case "Idiomas":
				acoesWeb.aguardaListaPresente(acao.listaIdiomas);
				listaEsperada = Arrays.asList("português (Brasil)", "inglês (Estados Unidos)", "espanhol (México)");

				listaRecebida = new ArrayList<>();
				for (WebElement paises : acao.listaIdiomas) {
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
				elementoPresente = acao.menuRelatorios.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				break;*/
			case "Lista conta":
				listaEsperada = Arrays.asList("Todos");
				listaRecebida = new ArrayList<>();
				for (WebElement contas : acao.listaContas) {
					listaRecebida.add(contas.getText());
				}

				escreveStep("Validar a lista de  'Contas'");
				acao.selectContas.click();
				screenShot();
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
				for (WebElement servicos : acao.listaServicos) {
					listaRecebida.add(servicos.getText());
				}

				escreveStep("Validar a lista de  'Serviços'");
				acao.selectServicos.click();
				screenShot();
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
				for (WebElement paises : acao.listaPaises) {
					listaRecebida.add(paises.getText());
				}

				escreveStep("Validar a lista de  'Países'");
				acao.selectPaises.click();
				screenShot();
				inserePrint();

				textorecebido = listaRecebida.toString();
				escreveDocumento("Países: " + textorecebido.replace("[", "").replace("]", ""));

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;
			case "período inicial":
				elementoPresente = acao.calendarioInicio.isDisplayed();
				if (elementoPresente) {
					escreveStep("Validar o 'Calendário inicial'");
					acao.calendarioInicio.click();
					screenShot();
					inserePrint();
				} else {
					escreveErroComponente("Calendário inicial não encontrado!!!");
				}
				break;
			case "período final":
				elementoPresente = acao.calendarioFim.isDisplayed();
				if (elementoPresente) {
					escreveStep("Validar o 'Calendário final'");
					acao.calendarioFim.click();
					screenShot();
					inserePrint();
				} else {
					escreveErroComponente("Calendário final não encontrado!!!");
				}
				break;
			case "status":
				listaEsperada = Arrays.asList("Todos", "Aguardando Liberação", "Liberado para download / Não baixado",
						"Baixado / Aguardando fatura", "Faturado / Aguardando Aprovação", "Fatura Aprovada",
						"Fatura Rejeitada", "Fatura Paga", "Enviado via FTP/Aguardando Fatura");

				listaRecebida = new ArrayList<>();
				for (WebElement status : acao.listaStatus) {
					listaRecebida.add(status.getText());
				}

				escreveStep("Validar a lista de  'Status'");
				acao.selectStatus.click();
				Thread.sleep(1000);
				screenShot();
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
				elementoPresente = acao.btnListar.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				break;
			case "Botão Aceitar":
				elementoPresente = acao.btnAceitar.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
				} else {
					escreveErroComponente(string);
				}
				break;
			case "Campo texto 'Nome'":
				elementoPresente = acao.campoTextoNome.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto 'Nome'");
				} else {
					escreveErroComponente("Campo texto 'Nome'");
				}
				break;
			case "Campo texto 'Email'":
				elementoPresente = acao.campoTextoEmail.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto 'Email'");
				} else {
					escreveErroComponente("Campo texto 'Email'");
				}
				break;
			case "Campo texto 'Usuário'":
				elementoPresente = acao.campoTextoUsuario.isDisplayed();
				if (elementoPresente) {
					escreveDocumento("Campo texto 'Usuário'");
				} else {
					escreveErroComponente("Campo texto 'Usuário'");
				}
				break;
			/*case "Botão Salvar":
				elementoPresente = acao.btnSalvar.isDisplayed();
				if (elementoPresente) {
					escreveDocumento(string);
					acao.menuRelatorios.click();
				} else {
					escreveErroComponente(string);
				}
				break;	*/
			case "Campo texto 'Perfil'":
				listaEsperada = Arrays.asList("iMusica", "Royalties", "Recorders", "Editors", "RecordersAndEditors");

				listaRecebida = new ArrayList<>();
				for (WebElement perfis : acao.listaPerfil) {
					listaRecebida.add(perfis.getText());
				}
				
				escreveStep("Validar a lista de  'Perfis'");
				acao.selectPerfil.click();
				screenShot();
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
				listaEsperada = Arrays.asList("Todos", "Dabliú Discos (Gravadora)", "zzz - Cogumelo (Gravadora) INOPERANTE", "Nikita Music (Editora/Gravadora)", "Rob Digital (Gravadora)");
							
				escreveStep("Validar a lista de  'Gravadoras/Editoras'");
				acao.selectGravadorEditora.click();
				Thread.sleep(1000);
				screenShot();
				inserePrint();
				
				listaRecebida = new ArrayList<String>(acoesWeb.listaGravadoras());
				
				textorecebido = listaRecebida.toString();
				escreveDocumento("Gravadoras/Editoras: " + textorecebido.replace("[", "").replace("]", "") + "...");

				for (int i = 0; i < listaRecebida.size(); i++) {
					if (!listaEsperada.get(i).equals(listaRecebida.get(i))) {
						escreveErroTexto(listaEsperada.get(i), listaRecebida.get(i));
					}
				}
				break;	
			case "Serviço":
				listaEsperada = Arrays.asList("Todos", "Claromusica", "RBT", "Combo Hits", "Tag", "iMusicaFM", "Claromusica Play", "iTunes USD",  "iTunes CAD", "iTunes MXN", 
						"iTunes All", "Deezer", "Spotify", "Youtube", "Google Play", "Facebook", "iTunes", "Apple Music", "Napster", "Pandora", "Outros OTTs", "Ott Unificado");
			
				escreveStep("Validar a lista de  'Serviços'");
				acao.selectServico.click();
				Thread.sleep(1000);
				screenShot();
				inserePrint();
	
				listaRecebida = new ArrayList<>();
				for (WebElement servico : acao.listaServicoRegistro) {
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
				listaEsperada = Arrays.asList("Todos", "ARGENTINA", "BRAZIL", "CHILE", "COLOMBIA", "COSTA RICA", "DOMINICAN REPUBLIC", "ECUADOR", "GUATEMALA", "HONDURAS", 
						"MEXICO", "NICARAGUA", "PANAMA", "PERU", "PARAGUAY", "EL SALVADOR", "URUGUAY");
				
				escreveStep("Validar a lista de  'Países'");
				acao.selectPais.click();
				Thread.sleep(1000);
				screenShot();
				inserePrint();
				
				listaRecebida = new ArrayList<>();
				for (WebElement pais : acao.listaPaisRegistro) {
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
			}	
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

}
