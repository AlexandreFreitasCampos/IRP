package br.com.claro.irp.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.claro.irp.pages.pageObjects.RelatoriosPO;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class acoesWeb extends DriverFactory {
	RelatoriosPO acaoRelatorios = new RelatoriosPO();
	public void getURL(String string) {
		String textorecebido = getDriver().getCurrentUrl();
		try {
			Assert.assertEquals(string, textorecebido);
			PDF.escreveDocumento("URL " + textorecebido);
		} catch (AssertionError e) {
			PDF.escreveErroTexto(string, textorecebido);
		}
	}

	public void aguardaElementoPresente(WebElement elemento) {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfAllElements((elemento)));
	}
	public List<WebElement> aguardaListaPresente(List<WebElement> elemento) {
		return new WebDriverWait(getDriver(), 10)
				.until(ExpectedConditions.visibilityOfAllElements(elemento));

	}
	public boolean validarContaExistente() {
		if (!getDriver().findElements(By.xpath("//*[@id='step-account-content']/div")).isEmpty()) {
			return true;
		} else {
			return false;
		}
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
	
	public static void clicarContaAleatoria(WebElement elemento) {
		Select select = new Select(elemento);
        int intervaloInicio = 0;
        int intervaloFim = select.getOptions().size() - 1;
        
               
        // Crie uma instância da classe Random
        Random random = new Random();

        // Gere um número aleatório dentro do intervalo
        int indiceAleatorio = random.nextInt(intervaloFim - intervaloInicio + 1);
        
        select.selectByIndex(indiceAleatorio);
	}
	
	public static String pegarUmMesAnterior() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate mesAnterior = dataAtual.minusMonths(1);
		String mes = mesAnterior.toString().substring(5, 7);
		
		List<String> meses = new ArrayList<String>();
		meses.add("Jan");
		meses.add("Fev");
		meses.add("Mar");
		meses.add("Abr");
		meses.add("Mai");
		meses.add("Jun");
		meses.add("Jul");
		meses.add("Ago");
		meses.add("Set");
		meses.add("Out");
		meses.add("Nov");
		meses.add("Dez");
		
		return meses.get(Integer.parseInt(mes) - 1);
	}
	
	public static String pegarDoisMesesAnteriores() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate mesAnterior = dataAtual.minusMonths(2);
		String mes = mesAnterior.toString().substring(5, 7);
		
		List<String> meses = new ArrayList<String>();
		meses.add("Jan");
		meses.add("Fev");
		meses.add("Mar");
		meses.add("Abr");
		meses.add("Mai");
		meses.add("Jun");
		meses.add("Jul");
		meses.add("Ago");
		meses.add("Set");
		meses.add("Out");
		meses.add("Nov");
		meses.add("Dez");
		return meses.get(Integer.parseInt(mes) - 1);
	}
	
	public static String pegarTresMesesAnteriores() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate mesAnterior = dataAtual.minusMonths(3);
				
		String mes = mesAnterior.toString().substring(5, 7);
		
		List<String> meses = new ArrayList<String>();
		meses.add("Jan");
		meses.add("Fev");
		meses.add("Mar");
		meses.add("Abr");
		meses.add("Mai");
		meses.add("Jun");
		meses.add("Jul");
		meses.add("Ago");
		meses.add("Set");
		meses.add("Out");
		meses.add("Nov");
		meses.add("Dez");
		return meses.get(Integer.parseInt(mes) - 1);
	}
	
	public static void selecionarUmMesAnterior() {
		String mesAnterior = pegarUmMesAnterior();
		if(mesAnterior == "Dez") {
			getDriver().findElement(By.xpath("//*[@id='custonReports_lastPeriod']")).click();
			WebElement elemento = getDriver().findElement(By.xpath("//th[@class='prev']"));

			JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
	        jsExecutor.executeScript("arguments[0].click();", elemento);
		}
		getDriver().findElement(By.xpath("//*[text() = '" + mesAnterior + "']")).click();
	}
	
	public static void selecionarDoisMesesAnteriores() {
		String mesAnterior = pegarDoisMesesAnteriores();
		if(mesAnterior == "Nov" || mesAnterior == "Dez") {
			getDriver().findElement(By.xpath("//th[@class='prev']")).click();
		}
		getDriver().findElement(By.xpath("//*[text() = '" + mesAnterior + "']")).click();
	}
	
	public static void selecionarTresMesesAnteriores() {
		String mesAnterior = pegarTresMesesAnteriores();
				
		if(mesAnterior == "Out" || mesAnterior == "Nov" || mesAnterior == "Dez") {
			getDriver().findElement(By.xpath("//*[@id='custonReports_firstPeriod']")).click();
			
			WebElement elemento = getDriver().findElement(By.xpath("//th[@class='prev']"));

			JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
	        jsExecutor.executeScript("arguments[0].click();", elemento);
		} 
		getDriver().findElement(By.xpath("//*[text() = '" + mesAnterior + "']")).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		somar1();
	}
	
	public static void somar1() {
		for(int i = 0; i<=100; i++) {
			System.out.println(i);
		}
		
		int i = 0;
		while(i <= 500) {
			i++;
			System.out.println(i);
		}
		
		
		i = 1;
		do {
			i++;
			System.out.println(i);
		}while(i <= 200);
	}
	
	
	
}
