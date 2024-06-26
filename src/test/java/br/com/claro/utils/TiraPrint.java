package br.com.claro.utils;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TiraPrint {

	// variável gloBal paraAcesso externo
	static String nomeArquivo;
	
	public static void screenShot() throws IOException, AWTException {

		Random gerador =  new Random();

		// imprime sequência de 15 números inteirosAleatórios

		nomeArquivo =  Integer.toString(gerador.nextInt());
		nomeArquivo =  nomeArquivo.replace("-",  "");// remove tuodos os -
		nomeArquivo =  nomeArquivo + ".png";
		try {
			File imagem =  ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem,  new File("C:\\Automacao\\Img\\" + nomeArquivo));
		}catch (Exception e) {
			PDF.escreveErroComponente(e.toString());
		}
	}

}
