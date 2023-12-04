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
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.claro.irp.action.Action;
import br.com.claro.irp.pages.pageObjects.FaturamentoPO;
import br.com.claro.irp.pages.world.World;
import br.com.claro.irp.utils.AcoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class FaturamentoPA extends DriverFactory implements Action {
	FaturamentoPO acaoFaturamento = new FaturamentoPO();
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
			case "":
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
			case "Instruções para faturamento":
				acaoFaturamento.menuFaturamento.click();
				acoesWeb.aguardaElementoPresente(acaoFaturamento.textoInstrucoesParaFaturamentos);
				escreveStep("Validar o menu 'Faturamento'");
				Thread.sleep(1000);
				screenShot();
				inserePrint();
				textorecebido = acaoFaturamento.textoInstrucoesParaFaturamentos.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Tela: " + textorecebido);
				acaoFaturamento.botaoOk.click();
				break;		
			case "Filtro de faturas":
				acoesWeb.aguardaElementoPresente(acaoFaturamento.textoFiltroDeFaturas);
				screenShot();
				inserePrint();
				escreveSubTitulo(string);
				textorecebido = acaoFaturamento.textoFiltroDeFaturas.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Tela: " + textorecebido);
				break;			
			case "País de Faturamento":
				textorecebido = acaoFaturamento.textoPaisDeFaturamento.getText();
				assertEquals(textorecebido, string);
				
				listaRecebida = new ArrayList<String>();
				
				for(WebElement pais : acaoFaturamento.listaPaisDeFaturamento) {
					listaRecebida.add(pais.getText().replace("[", "").replace("]", ""));
				}
				
				textorecebido = listaRecebida.get(0).toString();
				
				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;				
			case "Moeda de Faturamento":
				textorecebido = acaoFaturamento.textoMoedaDeFaturamento.getText();
				assertEquals(textorecebido, string);
				
				listaRecebida = new ArrayList<String>();
				
				for(WebElement moeda : acaoFaturamento.listaMoedaDeFaturamento) {
					listaRecebida.add(moeda.getText().replace("[", "").replace("]", ""));
				}
				
				textorecebido = listaRecebida.get(0).toString();
				
				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;					
			}	
			
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

	@Override
	public void clicarBotao(String string) {
		try {
			switch (string) {
			case ""  :
				break;		
			}	
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

	@Override
	public void setTexto(String string) {

	}

	@Override
	public void getComponente(String string) {
		try {
			switch (string) {
			case "":
				
				break;	
			}	
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}

}
