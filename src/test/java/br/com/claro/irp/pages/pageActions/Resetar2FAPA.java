package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.escreveDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveErroTexto;
import static br.com.claro.irp.utils.PDF.escreveSubTitulo;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.PDF.salvaDocumento;
import static br.com.claro.irp.utils.TiraPrint.screenShot;

import org.junit.Assert;

import br.com.claro.irp.pages.pageObjects.Resetar2FAPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;

public class Resetar2FAPA extends DriverFactory {

	private Resetar2FAPO acaoResetar = new Resetar2FAPO();
	private br.com.claro.irp.utils.acoesWeb acoesWeb = new acoesWeb();

	private String textorecebido;
	
	public void getTexto(String string) {
		try {
			switch (string) {
			case "Se você reiniciar sua chave de autenticação":
				string = "Se você reiniciar sua chave de autenticação, seu aplicativo de autenticação não "
						+ "funcionará até que seja reconfigurado.\n"
						+ "Este processo desativará a autenticação em dois-fatores e também irá reiniciar "
						+ "os códigos de recuperação. Se não completar a configuração do aplicativo de autenticação"
						+ ", você perderá acesso a sua conta.";
				acaoResetar.menuAdmin.click();
				acaoResetar.menuResetar2FA.click();
				acoesWeb.aguardaElementoPresente(acaoResetar.botaoRedefinir);
				textorecebido = acaoResetar.textoAlerta.getText();
				Assert.assertEquals(textorecebido, string);
				screenShot();
				inserePrint();
				escreveSubTitulo("Resetar 2FA");
				escreveDocumento("Texto: " + string);
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
			case "Redefinir chave de autenticação":
				textorecebido = acaoResetar.botaoRedefinir.getText();
				Assert.assertEquals(textorecebido, string);
				escreveDocumento("Botão: " + string);
				salvaDocumento();
				killDriver();
				break;
				
			}

		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}
}
