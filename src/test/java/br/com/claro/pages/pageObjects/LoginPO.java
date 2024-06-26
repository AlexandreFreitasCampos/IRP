package br.com.claro.pages.pageObjects;

import br.com.claro.steps.StepsDefinition;
import br.com.claro.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO extends StepsDefinition {

    public LoginPO(){
        PageFactory.initElements(getDriver(),  this);
    }
    @FindBy(xpath = "//*[text()='Aceitar']")
    public WebElement btnAceitar;
    @FindBy(xpath = "//input[@placeholder='Usuário']")
    public WebElement inputUsuario;

    @FindBy(xpath = "//input[@placeholder='Senha']")
    public WebElement inputSenha;

    @FindBy(xpath = "//*[text() = 'Acessar']")
    public WebElement btnAcessar;

    @FindBy(xpath = "//input[@id='TwoFactorCode']")
    public WebElement inputCodigoAutenticacao;
    @FindBy(xpath = "//button[text() = 'Log in']")
    public WebElement btnLogin;

}
