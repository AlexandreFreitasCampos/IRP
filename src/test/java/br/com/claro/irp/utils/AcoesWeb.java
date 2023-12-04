package br.com.claro.irp.utils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcoesWeb extends DriverFactory {
	public static String getURL(String string) {
		String textorecebido = getDriver().getCurrentUrl();
		try {
			Assert.assertEquals(string, textorecebido);
			PDF.escreveDocumento("URL " + textorecebido);
		} catch (AssertionError e) {
			PDF.escreveErroTexto(string, textorecebido);
		}
		return textorecebido;
	}

	public void aguardaElementoPresente(WebElement elemento) {
		new WebDriverWait(getDriver(), Duration.of(30, ChronoUnit.SECONDS))
				.until(ExpectedConditions.elementToBeClickable((elemento)));
	}

	public List<WebElement> aguardaListaPresente(List<WebElement> elemento) {
		return new WebDriverWait(getDriver(), Duration.of(30, ChronoUnit.SECONDS))
				.until(ExpectedConditions.visibilityOfAllElements(elemento));

	}

	public List<String> listaGravadoras() {
		List<String> gravadoras = new ArrayList<>();
		
		for (int i = 2; i <= 6; i++) {
			String elemento = driver
					.findElement(
							By.xpath("//form[@name='form-createuser']/div[2]/div[1]/div/ul/li[" + i + "]/a/label"))
					.getText();
			gravadoras.add(elemento);
		}
		return gravadoras;

	}
}
