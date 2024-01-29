package br.com.claro.irp.pages.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;



public class HistoricoDeFaturasPO extends DriverFactory{
	
    public HistoricoDeFaturasPO(){
        PageFactory.initElements(getDriver(),  this);
    }    
   
    @FindBy(xpath = "//*[text() = 'Histórico de Faturas']")
    public WebElement menuHistorioDeFaturas;
    
    @FindBy(xpath = "//div[@class='card-header']")
    public WebElement textoFiltroDeFaturas;
    
    @FindBy(xpath = "//*[text() = 'País de Faturamento']")
    public WebElement textoPaisDeFaturamento;
    
    @FindBy(xpath = "//select[@id='revenueHistory_countryRevenue']/option")
    public List<WebElement> listaPaisDeFaturamento;
    
    @FindBy(xpath = "//*[text() = 'Moeda de Faturamento']")
    public WebElement textoMoedaDeFaturamento;
    
    @FindBy(xpath = "//select[@id='revenueHistory_currencyRevenue']/option")
    public List<WebElement> listaMoedaDeFaturamento;
    
    @FindBy(xpath = "//*[text() = 'Serviço']")
    public WebElement textoServiço;
    
    @FindBy(xpath = "//*[@id='form-revenueHistory']/div/div[3]/div/button/span")
    public WebElement textoNenhumSelecionadoServico;
    
    @FindBy(xpath = "//*[@id='form-revenueHistory']/div/div[3]/div/ul/li")
    public List<WebElement> listaServiço;
    
    @FindBy(xpath = "//*[text() = 'País']")
    public WebElement textoPais;
    
    @FindBy(xpath = "//*[@id='form-revenueHistory']/div/div[4]/div/button/span")
    public WebElement textoNenhumSelecionadoPais;
    
    @FindBy(xpath = "//*[@id='form-revenueHistory']/div/div[4]/div/ul/li")
    public List<WebElement> listaPais;
    
    @FindBy(xpath = "//*[text() = 'Período Inicial']")
    public WebElement textoPeriodoInicial;
    
    @FindBy(xpath = "//input[@name='revenue_firstPeriod']")
    public WebElement calendarioInicial;
    
    @FindBy(xpath = "//*[text() = 'Período Final']")
    public WebElement textoPeriodoFinal;
    
    @FindBy(xpath = "//input[@name='revenue_lastPeriod']")
    public WebElement calendarioFinal;
    
    @FindBy(xpath = "//*[text() = 'Tipo de Filtro']")
    public WebElement textoTipoDeFiltro;  
    
    @FindBy(xpath = "//*[@id='revenueHistory_filterType']/option")
    public List<WebElement> listaTipoDeFiltro;
    
    @FindBy(xpath = "//*[text() = 'Status']")
    public WebElement textoStatus;  
    
    @FindBy(xpath = "//*[@id='revenueHistory_status']/option")
    public List<WebElement> listaStatus;
    
    @FindBy(xpath = "//*[text() = 'Listar']")
    public WebElement botaoListar;
}
