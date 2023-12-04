package br.com.claro.irp.pages.pageObjects;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.claro.irp.utils.DriverFactory;

public class LoginPO extends DriverFactory{
	
    public String element;

    public LoginPO(){
        PageFactory.initElements(getDriver(),  this);
    }
     @FindBy(xpath = "//*[text() = 'Bem-vindo ao IRP']")
    public WebElement textoBemVindo;

    @FindBy(xpath = "//input[@placeholder='Usuário']")
    public WebElement inputUsuario;

    @FindBy(xpath = "//input[@placeholder='Senha']")
    public WebElement inputSenha;

    @FindBy(xpath = "/html/body/div/div[1]/section/form/div[3]/div/label")
    public WebElement textoLembrar;

    @FindBy(xpath = "//*[text() = 'Acessar']")
    public WebElement btnAcessar;

    @FindBy(xpath = "//*[text() = 'Esqueceu sua senha?']")
    public WebElement textoEsqueceuSenha;

    @FindBy(xpath = "//*[text() = '© 2023 - iMusica (Claro S.A.)']")
    public WebElement textoCopyright;

    @FindBy(xpath = "/html/body/div/footer/div/div[2]/a")
    public WebElement textoDownloadManual;

    @FindBy(xpath = "//*[text() = 'Idioma']")
    public WebElement textoIdioma;

    @FindBy(xpath = "//*[@id='cookieConsent']")
    public WebElement textoCookies;

    @FindBy(xpath = "//button[text() = 'Aceitar']")
    public WebElement btnAceitar;

    @FindBy(xpath = "//*[@id='requestCulture_RequestCulture_UICulture_Name']/option")
    public List<WebElement> filtroPaises;

    @FindBy(xpath = "//h2[text() = 'Autenticação de dois fatores']")
    public WebElement textoMFA;

    @FindBy(xpath = "//p[contains(text(), 'Seu login está')]")
    public WebElement textoLoginProtegido;

    @FindBy(xpath = "//label[text() = 'Código de autenticação']")
    public WebElement textoCodigoAutenticacao;


    @FindBy(xpath = "//input[@id='TwoFactorCode']")
    public WebElement inputCodigoAutenticacao;

    @FindBy(xpath = "/html/body/div/div[1]/div/form/div[2]/div/label")
    public WebElement textoLembrarMaquina;

    @FindBy(xpath = "//button[text() = 'Log in']")
    public WebElement btnLogin;

    @FindBy(xpath = "//p[contains(text(), 'Não possui acesso')]")
    public WebElement textoNaoPossuiAcesso;

    public void aguardaElementoPresente(WebElement elemento,  String string){
    new WebDriverWait(getDriver(),  Duration.of(15,  ChronoUnit.SECONDS)).until(ExpectedConditions.textToBePresentInElement(elemento,  string));
    }
}
