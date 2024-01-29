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

import br.com.claro.irp.pages.pageObjects.HistoricoDeFaturasPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class HistoricoDeFaturasPA extends DriverFactory{
	HistoricoDeFaturasPO acaoHistoricoFaturas = new HistoricoDeFaturasPO();
	br.com.claro.irp.utils.acoesWeb acoesWeb = new acoesWeb();
	
	private String textorecebido;
	private final List<String> listaRecebida = new ArrayList<>();

	public void getTexto(String string) {
		try {
			switch (string) {
			case "Filtro de faturas":
				acaoHistoricoFaturas.menuHistorioDeFaturas.click();
				acoesWeb.aguardaElementoPresente(acaoHistoricoFaturas.textoNenhumSelecionadoServico);
				escreveStep("Validar o menu 'Histórico de Faturas'");
				screenShot();
				inserePrint();
				escreveSubTitulo(string);
				textorecebido = acaoHistoricoFaturas.textoFiltroDeFaturas.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Tela: " + textorecebido);
				break;			
			case "País de Faturamento":
				textorecebido = acaoHistoricoFaturas.textoPaisDeFaturamento.getText();
				assertEquals(textorecebido, string);
				
				for(WebElement pais : acaoHistoricoFaturas.listaPaisDeFaturamento) {
					listaRecebida.add(pais.getText());
				}
				
				textorecebido = listaRecebida.get(0);
				
				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;				
			case "Moeda de Faturamento":
				textorecebido = acaoHistoricoFaturas.textoMoedaDeFaturamento.getText();
				assertEquals(textorecebido, string);
				
				for(WebElement moeda : acaoHistoricoFaturas.listaMoedaDeFaturamento) {
					listaRecebida.add(moeda.getText());
				}
				
				textorecebido = listaRecebida.get(0);
				
				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;	
			case "Serviço":
				if(acaoHistoricoFaturas.textoServico.getText().equals(string) && acaoHistoricoFaturas.textoNenhumSelecionadoServico.getText() != null) {
					escreveDocumento("Lista de serviços: " + acaoHistoricoFaturas.textoNenhumSelecionadoServico.getText());
				}else {
					escreveDocumento("Lista de serviços: " + acaoHistoricoFaturas.textoNenhumSelecionadoServico.getText() + " não encontrado!!!");
				}
				break;	
			case "País":
				if(acaoHistoricoFaturas.textoPais.getText().equals(string) && acaoHistoricoFaturas.textoNenhumSelecionadoPais.getText() != null) {
					escreveDocumento("Lista de países: " + acaoHistoricoFaturas.textoNenhumSelecionadoPais.getText());
				}else {
					escreveDocumento("Lista de países: " + acaoHistoricoFaturas.textoNenhumSelecionadoPais.getText() + " não encontrado!!!");
				}
				break;		
			case "Período Inicial":
				textorecebido = acaoHistoricoFaturas.textoPeriodoInicial.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Calendário: " + textorecebido);
				break;	
			case "Período Final":
				textorecebido = acaoHistoricoFaturas.textoPeriodoFinal.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Calendário: " + textorecebido);
				break;	
			case "Tipo de Filtro":
				textorecebido = acaoHistoricoFaturas.textoTipoDeFiltro.getText();
				assertEquals(textorecebido, string);
				
				for(WebElement filtro : acaoHistoricoFaturas.listaTipoDeFiltro) {
					listaRecebida.add(filtro.getText());
				}
				
				textorecebido = listaRecebida.get(0);
				
				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;	
			case "Status":
				textorecebido = acaoHistoricoFaturas.textoStatus.getText();
				assertEquals(textorecebido, string);
				
				for(WebElement status : acaoHistoricoFaturas.listaStatus) {
					listaRecebida.add(status.getText());
				}
				
				textorecebido = listaRecebida.get(0);
				
				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
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
            if (string.equals("Botão Listar")) {
                textorecebido = acaoHistoricoFaturas.botaoListar.getText();
                assertEquals(textorecebido, string.replace("Botão ", ""));
                escreveDocumento("Botão: " + textorecebido);
            }
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}
}
