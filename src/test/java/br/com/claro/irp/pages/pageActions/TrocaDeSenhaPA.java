package br.com.claro.irp.pages.pageActions;

import static br.com.claro.irp.utils.PDF.escreveDocumento;
import static br.com.claro.irp.utils.PDF.escreveErroComponente;
import static br.com.claro.irp.utils.PDF.escreveErroTexto;
import static br.com.claro.irp.utils.PDF.escreveStep;
import static br.com.claro.irp.utils.PDF.escreveSubTitulo;
import static br.com.claro.irp.utils.PDF.inserePrint;
import static br.com.claro.irp.utils.TiraPrint.screenShot;

import org.junit.Assert;

import br.com.claro.irp.pages.pageObjects.TrocaDeSenhaPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;


public class TrocaDeSenhaPA extends DriverFactory{

	private TrocaDeSenhaPO acaoTrocaDeSenha = new TrocaDeSenhaPO();
	private br.com.claro.irp.utils.acoesWeb acoesWeb = new acoesWeb();

	private String textorecebido;
	
	public void getTexto(String string) {
		try {
			switch (string) {
			case "Trocar Senha":
				escreveStep(" Validar o menu 'Admin'");
				acaoTrocaDeSenha.menuAdmin.click();
				screenShot();
				inserePrint();
				acaoTrocaDeSenha.menuTrocaDeSenha.click();
				acoesWeb.aguardaElementoPresente(acaoTrocaDeSenha.botaoSalvar);
				screenShot();
				inserePrint();
				escreveSubTitulo("Trocar senha");
				textorecebido = acaoTrocaDeSenha.textoTrocarSenha.getText();
				Assert.assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + string);
				break;
			case "Senha atual":
				textorecebido = acaoTrocaDeSenha.textoSenhaAtual.getText();
				Assert.assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;	
			case "Nova senha":
				textorecebido = acaoTrocaDeSenha.textoNovaSenha.getText();
				Assert.assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
				break;		
			case "Confirme a senha":
				textorecebido = acaoTrocaDeSenha.textoConfirmeASenha.getText();
				Assert.assertEquals(textorecebido, string);
				escreveDocumento("Texto: " + textorecebido);
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
			case "Botão Salvar":
				textorecebido = acaoTrocaDeSenha.botaoSalvar.getText();
				Assert.assertEquals(textorecebido, string.replace("Botão ", ""));
				escreveDocumento("Botão " + textorecebido);
				break;
			}	
		} catch (AssertionError e) {
			escreveErroTexto(string, textorecebido);
		} catch (Exception e) {
			escreveErroComponente(e.getMessage());
		}

	}
}
