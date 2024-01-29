package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.*;
import static br.com.claro.irp.utils.TiraPrint.screenShot;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.claro.irp.pages.pageObjects.FaturamentoPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class FaturamentoPA extends DriverFactory {
	FaturamentoPO acaoFaturamento = new FaturamentoPO();
	br.com.claro.irp.utils.acoesWeb acoesWeb = new acoesWeb();

	private String textorecebido = acaoFaturamento.textoFiltroDeFaturas.getText();
	private final List<String> listaRecebida = new ArrayList<>();

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

				for (WebElement pais : acaoFaturamento.listaPaisDeFaturamento) {
					listaRecebida.add(pais.getText());
				}

				textorecebido = listaRecebida.get(0);

				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;
			case "Moeda de Faturamento":
				textorecebido = acaoFaturamento.textoMoedaDeFaturamento.getText();
				assertEquals(textorecebido, string);

				for (WebElement moeda : acaoFaturamento.listaMoedaDeFaturamento) {
					listaRecebida.add(moeda.getText());
				}

				textorecebido = listaRecebida.get(0);

				escreveDocumento(string + ": " + textorecebido.replace("[", "").replace("]", ""));
				break;
			case "Serviço":
				if (acaoFaturamento.textoServico.getText().equals(string)
						&& acaoFaturamento.textoNenhumSelecionadoServico.getText() != null) {
					escreveDocumento("Lista de serviços: " + acaoFaturamento.textoNenhumSelecionadoServico.getText());
				} else {
					escreveDocumento("Lista de serviços: " + acaoFaturamento.textoNenhumSelecionadoServico.getText()
							+ " não encontrado!!!");
				}
				break;
			case "País":
				if (acaoFaturamento.textoPais.getText().equals(string)
						&& acaoFaturamento.textoNenhumSelecionadoPais.getText() != null) {
					escreveDocumento("Lista de países: " + acaoFaturamento.textoNenhumSelecionadoPais.getText());
				} else {
					escreveDocumento("Lista de países: " + acaoFaturamento.textoNenhumSelecionadoPais.getText()
							+ " não encontrado!!!");
				}
				break;
			case "Período Inicial":
				textorecebido = acaoFaturamento.textoPeriodoInicial.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Calendário: " + textorecebido);
				break;
			case "Período Final":
				textorecebido = acaoFaturamento.textoPeriodoFinal.getText();
				assertEquals(textorecebido, string);
				escreveDocumento("Calendário: " + textorecebido);
				break;
                default:
                    throw new IllegalStateException("Unexpected value: " + string);
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
                textorecebido = acaoFaturamento.botaoListar.getText();
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
