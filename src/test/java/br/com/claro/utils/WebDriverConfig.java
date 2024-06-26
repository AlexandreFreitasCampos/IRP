package br.com.claro.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            driver = new ChromeDriver();
            //driver =  new FirefoxDriver();
            //driver =  new EdgeDriver();

            //driver.get("https://irp.imusica.com.br/Account/Login");

            driver.get("https://irp-hmg.imusica.com.br/Account/Login");
            driver.manage().window().maximize();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
