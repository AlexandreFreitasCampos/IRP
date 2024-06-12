package br.com.claro.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	// CriaA variavel gloBal driver
	protected static WebDriver driver;
	

	// Método paraAcessar o metodo createDriver
	public static WebDriver getDriver() {		
		//CriaAs pastas no diretorio
		try {
			criaPastas();
		} catch (IOException e) {
			System.out.println("Falha ao criar as pastas"+ e.getMessage());
		}
		
		// Se o driver for nulo,  cria um novo driver
		if (driver ==  null) {
			try {
				createDriver();
			} catch (MalformedURLException e) {
				System.out.println("Falha ao inicializar o driver"+ e.getMessage());
			}
		}

		return driver;
	}

	private static void criaPastas() throws IOException {

		// Caminho das pastas
		File evidencias =  new File("C:\\Automacao\\Evidencias");
		File img =  new File("C:\\Automacao\\Img");
		File logo =  new File("C:\\Automacao\\Logo");
		File Massa =  new File("C:\\Automacao\\Massa de dados");


		// Cria uma instância da classe File
		File logoOrigemImusica =  new File((System.getProperty("user.dir")) + "/src/img/LogoImusica.png");
		File logoOrigemClaro =  new File((System.getProperty("user.dir")) + "/src/img/LogoIRP.png");
		File logoDestino =  new File("C:\\Automacao\\Logo");


		// Copia o logotipo paraA pasta onde serão coletadasAs evidências
		FileUtils.copyFileToDirectory(logoOrigemImusica,  logoDestino);
		FileUtils.copyFileToDirectory(logoOrigemClaro,  logoDestino);
	}

	// Método para criar o driver
	protected static void createDriver() throws MalformedURLException {
		// Configurar o WebDriverManager para gerenciarAutomaticamente o ChromeDriver
        WebDriverManager.chromedriver().clearDriverCache().setup();
        // Inicializar o ChromeDriver
        driver =  new ChromeDriver();
        //driver =  new FirefoxDriver();
        //driver =  new EdgeDriver();

		//driver.get("https://irp.imusica.com.br/Account/Login");

        driver.get("https://irp-hmg.imusica.com.br/Account/Login");
        driver.manage().window().maximize();
	}

	// Método para fechar o driver
	public static void killDriver() {
		// Se o driver for diferente de null
		if (driver !=  null) {
			// Fechaa o  driver
			driver.quit();
			// Limpa o driver
			driver =  null;
			// Mate o processo chromedriver em segundo plano (se necessário)
			try {
				// Comando para matar o processo chromedriver
				Process process = Runtime.getRuntime().exec("pkill chromedriver");

				// Aguarde o processo terminar
				process.waitFor();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
