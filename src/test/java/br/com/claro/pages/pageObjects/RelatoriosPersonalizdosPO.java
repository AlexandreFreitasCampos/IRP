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
    @FindBy(xpath = "//td[text() = 'MK Music (Editora)']")
    public WebElement contaMKMusic;
    @FindBy(xpath = "//select[@id='customReports_recordersSelection']")
    public WebElement selectContas;
    @FindBy(xpath = "//*[@id='step-account-btn-next']")
    public WebElement btnSeguinteConta;
    @FindBy(xpath = "//*[@id='inlineCM']/../label")
    public WebElement servicoClaroMusica;
    @FindBy(xpath = "//label[@for='inlineRBT']")
    public WebElement servicoRBT;
    @FindBy(xpath = "//label[@for='inlineOTT']")
    public WebElement servicoOTT;
    @FindBy(xpath = "//p[text() = 'Seleção de OTT']")
    public WebElement selecaoOTT;
    @FindBy(xpath = "//button[@title='Nenhum selecionado']")
    public WebElement btnOTTNenhumSelecionado;
    @FindBy(xpath = "//label[@class='checkbox']/input")
    public WebElement todosOTT;
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
    @FindBy(xpath = "//*[@id='step-columns-btn-next']")
    public WebElement btnSeguinteColunas;
    @FindBy(xpath = "//button[@id='btn-reset-columns']")
    public WebElement btnResetColunas;
    @FindBy(xpath = "//label[@for='check-share-filter']")
    public WebElement btnFiltoShare;
    @FindBy(xpath = "//input[@id='share-artist']")
    public WebElement inputShareArtista;
    @FindBy(xpath = "//div[@id='step-account-content']")
    public WebElement txtContaSelecionada;
    @FindBy(xpath = "//div[@id='step-service-content']")
    public WebElement txtServicoSelecionado;
    @FindBy(xpath = "//div[@id='step-country-content']")
    public WebElement txtPaisSelecionado;;
    @FindBy(xpath = "//div[@id='step-period-content']")
    public WebElement txtPeriodoSelecionado;
    @FindBy(xpath = "//div[@id='step-report-type-content']")
    public WebElement txtTipoDeRelatorioEFiltro;
    @FindBy(xpath = "//div[@id='step-columns-content']/div/div[1]")
    public WebElement txtColunas;
    @FindBy(xpath = "//div[@id='step-columns-content']/div/div[2]")
    public WebElement txtFiltroshare;
    @FindBy(xpath = "//button[@id='step-summary-btn-next']")
    public WebElement btnGerar;
    @FindBy(xpath = "//button[@class='btn btn btn-default']")
    public WebElement btnOk;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped table-responsive-lg mt-2']/tbody/tr/td[1]")
    public WebElement txtRelatorioDePedidosPeriodo;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped table-responsive-lg mt-2']/tbody/tr/td[2]")
    public WebElement txtRelatorioDePedidosTipoDeRelatorio;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped table-responsive-lg mt-2']/tbody/tr/td[3]")
    public WebElement txtRelatorioDePedidosCatalogo;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped table-responsive-lg mt-2']/tbody/tr/td[4]")
    public WebElement txtRelatorioDePedidosQtdeRoyalties;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped table-responsive-lg mt-2']/tbody/tr/td[5]")
    public WebElement txtRelatorioDePedidosDtGeracao;
    @FindBy(xpath = "//span[@class='c-grid-columns__title']")
    public List<WebElement> nomeColunas;
    @FindBy(xpath = "//span[@id='download']")
    public WebElement btnDownloadRelatorio;
    @FindBy(xpath = "//span[@id='delete']")
    public WebElement btnExcluirRelatorio;
    @FindBy(xpath = "//div[@id='modal-footer']/button[2]")
    public WebElement btnConfirmaExclusaoRelatorio;
    @FindBy(xpath = "//button[@class='btn btn btn-default']")
    public List <WebElement> listaNenhumRegistro;
    @FindBy(xpath = "//button[text()='Ok']")
    public WebElement btnNenhumRegistro;
    @FindBy(xpath = "//button[text() = 'Sair']")
    public WebElement btnSair;
}
