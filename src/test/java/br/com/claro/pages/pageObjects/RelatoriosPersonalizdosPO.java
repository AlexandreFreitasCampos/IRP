package br.com.claro.pages.pageObjects;

import br.com.claro.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RelatoriosPersonalizdosPO extends DriverFactory {
    public RelatoriosPersonalizdosPO(){
        PageFactory.initElements(getDriver(),  this);
    }
    @FindBy(xpath = "//p[.='Geração de Relátório em progresso...']")
    public WebElement relatoriosEmAndamento;
    @FindBy(xpath = "//*[text() ='Relatórios']")
    public WebElement menuRelatorios;
    @FindBy(xpath = "//*[text() ='Relatórios personalizados']")
    public WebElement menuRelatoriosPersonalizados;
    @FindBy(xpath = "//*[@id='account-type-recorder']")
    public WebElement inputContaGravadora;
    @FindBy(xpath = "//label[@for='account-type-recorder']")
    public WebElement labelContaGravadora;
    @FindBy(xpath = "//*[text() = 'Warner (Gravadora)']")
    public WebElement contaWarner;
    @FindBy(xpath = "//select[@id='customReports_recordersSelection']")
    public WebElement selectContas;
    @FindBy(xpath = "//*[@id='step-account-btn-next']")
    public WebElement btnSeguinteConta;
    @FindBy(xpath = "//*[@id='inlineCM']/../label")
    public WebElement servicoClaroMusica;
    @FindBy(xpath = "//label[@for='inlineRBT']")
    public WebElement servicoRBT;
    @FindBy(xpath = "//*[@id='step-service-btn-next']")
    public WebElement btnSeguinteServico;
    @FindBy(xpath = "//select[@id='customReports_countrySelection']")
    public WebElement selectPaises;
    @FindBy(xpath = "//option[text()='BRAZIL']")
    public WebElement paisBrasil;
    @FindBy(xpath = "//*[@id='step-country-btn-next']")
    public WebElement btnSeguintePais;
    @FindBy(xpath = "//input[@id='custonReports_firstPeriod']")
    public WebElement periodoInicial;
    @FindBy(xpath = "//input[@id='custonReports_lastPeriod']")
    public WebElement periodoFinal;
    @FindBy(xpath = "//*[@id='step-period-btn-next']")
    public WebElement btnSeguintePeriodo;
    @FindBy(xpath = "//div[@id='unit-report']")
    public WebElement btnRelatoriosUnificados;
    @FindBy(xpath = "//div[@id='multiple-report']")
    public WebElement btnRelatoriosMultiplos;
    @FindBy(xpath = "//label[@for='allCatalog']")
    public WebElement labelTodoOCatalogo;
    @FindBy(xpath = "//label[@for='reportTypeLabel']")
    public WebElement labelSelecionePorSelos;
    @FindBy(xpath = "//label[@for='reportTypeArtist']")
    public WebElement labelSelecionePorArtistas;
    @FindBy(xpath = "//label[@for='reportTypeAlbum']")
    public WebElement labelSelecionePorAlbuns;
    @FindBy(xpath = "//label[@for='reportTypetracks']")
    public WebElement labelSelecionePorFaixas;
    @FindBy(xpath = "//ul[@class='multiselect-container dropdown-menu show']/li/a/label/input")
    public List<WebElement> listaDeFiltros;
    @FindBy(xpath = "//*[@id='filter']/div/div/div/button")
    public WebElement btnNenhumSelecionado;
    @FindBy(xpath = "//*[@id='step-report-type-btn-next']")
    public WebElement btnSeguinteRelatorio;

    //@FindBy(xpath = "//div[@id='step-report-type-content']/div")
   // public WebElement tipoDeRelatorio;
}
