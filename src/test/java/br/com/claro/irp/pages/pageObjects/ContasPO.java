package br.com.claro.irp.pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;

public class ContasPO extends DriverFactory{
	public ContasPO() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()='Nome da Conta']")
    public WebElement lblNomeDaConta;
    
    @FindBy(xpath = "//tr[2]/td[1]")
    public WebElement textoNomeDaConta;
    
    @FindBy(xpath = "//*[text()='ID Conta']")
    public WebElement lblIdDaConta;
    
    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement textoIdConta;
    
    @FindBy(xpath = "//*[text()='Razão social']")
    public WebElement lblRazaoSocial;
    
    @FindBy(xpath = "//tr[2]/td[3]")
    public WebElement textoRazaoSocial;
    
    @FindBy(xpath = "//*[text()='Moeda']")
    public WebElement lblMoeda;
    
    @FindBy(xpath = "//tr[4]/td[1]")
    public WebElement textoMoeda;
    
    @FindBy(xpath = "//*[text()='Pagamento mínimo']")
    public WebElement lblPagamentoMinimo;
    
    @FindBy(xpath = "//tr[4]/td[2]")
    public WebElement textoPagamentoMinimo;
    
    @FindBy(xpath = "//*[text()='Data de Cadastro']")
    public WebElement lblDataDeCadastro;
    
    @FindBy(xpath = "//tr[4]/td[3]")
    public WebElement textoDataDeCadastro;
}
