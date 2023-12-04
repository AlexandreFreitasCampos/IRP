package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.escreveDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveErroTexto;
import static br.com.claro.irp.utils.PDF.escreveStep;
import static br.com.claro.irp.utils.PDF.escreveSubTitulo;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.TiraPrint.screenShot;
import static org.junit.Assert.assertEquals;

import java.util.List;

import br.com.claro.irp.action.Action;
import br.com.claro.irp.pages.pageObjects.ContasPO;
import br.com.claro.irp.pages.world.World;
import br.com.claro.irp.utils.AcoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class ContasPA extends DriverFactory implements Action {

	World world = new World();
	ContasPO acaoConta = new ContasPO();
	AcoesWeb acoesWeb = new AcoesWeb();

	private String textorecebido;
	private Boolean elementoPresente;
	private List<String> listaEsperada;
	private List<String> listaRecebida;

	@Override
	public void getURL(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTexto(String string) {
		try {
			switch (string) {
			case "Nome da Conta":
				if (acaoConta.lblNomeDaConta.isDisplayed() && acaoConta.textoNomeDaConta.isDisplayed()) {
					escreveSubTitulo("Dados da conta:");
					escreveDocumento(acaoConta.lblNomeDaConta.getText() + ": " + acaoConta.textoNomeDaConta.getText());
				} else {
					escreveErroTexto(string, null);
				}
				break;
			case "ID Conta":
				if (acaoConta.lblIdDaConta.isDisplayed() && acaoConta.textoIdConta.isDisplayed()) {
					escreveDocumento(acaoConta.lblIdDaConta.getText() + ": " + acaoConta.textoIdConta.getText());
				} else {
					escreveErroTexto(string, null);
				}
				break;
			case "Razão social":
				if (acaoConta.lblRazaoSocial.isDisplayed() && acaoConta.textoRazaoSocial.isDisplayed()) {
					escreveDocumento(acaoConta.lblRazaoSocial.getText() + ": " + acaoConta.textoRazaoSocial.getText());
				} else {
					escreveErroTexto(string, null);
				}
				break;
			case "Moeda":
				if (acaoConta.lblMoeda.isDisplayed() && acaoConta.textoMoeda.isDisplayed()) {
					escreveDocumento(acaoConta.lblMoeda.getText() + ": " + acaoConta.textoMoeda.getText());
				} else {
					escreveErroTexto(string, null);
				}
				break;
			case "Pagamento mínimo":
				if (acaoConta.lblPagamentoMinimo.isDisplayed() && acaoConta.textoPagamentoMinimo.isDisplayed()) {
					escreveDocumento(
							acaoConta.lblPagamentoMinimo.getText() + ": " + acaoConta.textoPagamentoMinimo.getText());
				} else {
					escreveErroTexto(string, null);
				}
				break;
			case "Data de Cadastro":
				if (acaoConta.lblDataDeCadastro.isDisplayed() && acaoConta.textoDataDeCadastro.isDisplayed()) {
					escreveDocumento(
							acaoConta.lblDataDeCadastro.getText() + ": " + acaoConta.textoDataDeCadastro.getText());
				} else {
					escreveErroTexto(string, null);
				}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setTexto(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getComponente(String string) {
		// TODO Auto-generated method stub

	}

}
