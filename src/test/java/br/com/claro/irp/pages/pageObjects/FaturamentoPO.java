package br.com.claro.irp.pages.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;



public class FaturamentoPO extends DriverFactory{
	
    public FaturamentoPO(){
        PageFactory.initElements(getDriver(),  this);
    }    
   
    @FindBy(xpath = "//*[text() = 'Faturamento']")
    public WebElement menuFaturamento;
    
    @FindBy(xpath = "//*[text() = 'Instruções para faturamento']")
    public WebElement textoInstrucoesParaFaturamentos;
    
    @FindBy(xpath = "//*[text() = 'Ok']")
    public WebElement botaoOk;
    
    @FindBy(xpath = "//div[@class='card-header']")
    public WebElement textoFiltroDeFaturas;
    
    @FindBy(xpath = "//*[text() = 'País de Faturamento']")
    public WebElement textoPaisDeFaturamento;
    
    @FindBy(xpath = "//select[@id='revenue_countryRevenue']/option")
    public List<WebElement> listaPaisDeFaturamento;
    
    @FindBy(xpath = "//*[text() = 'Moeda de Faturamento']")
    public WebElement textoMoedaDeFaturamento;
    
    @FindBy(xpath = "//select[@id='revenue_currencyRevenue']/option")
    public List<WebElement> listaMoedaDeFaturamento;
    
    @FindBy(xpath = "//*[text() = 'Serviço']")
    public WebElement textoServiço;
    
    @FindBy(xpath = "//select[@id='revenue_currencyRevenue']/option")
    public List<WebElement> listaServiço;
    
    
}
