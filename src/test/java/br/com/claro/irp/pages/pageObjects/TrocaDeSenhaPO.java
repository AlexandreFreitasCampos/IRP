package br.com.claro.irp.pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;

public class TrocaDeSenhaPO extends DriverFactory{
	public TrocaDeSenhaPO() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()='Admin']")
    public WebElement menuAdmin;
    
    @FindBy(xpath = "//*[text()='Troca de senha']")
    public WebElement menuTrocaDeSenha;
	
	@FindBy(xpath = "//*[text()='Trocar Senha']")
    public WebElement textoTrocarSenha;
	
	@FindBy(xpath = "//*[text()='Senha atual']")
    public WebElement textoSenhaAtual;
	
	@FindBy(xpath = "//form/div[1]/input[1]")
    public WebElement inputSenhaAtual;
	
	@FindBy(xpath = "//*[text()= 'Nova senha']")
    public WebElement textoNovaSenha;
	
	@FindBy(xpath = "//form/div[2]/input[1]")
    public WebElement inputNovaSenha;
	
	@FindBy(xpath = "//*[text() = 'Confirme a senha']")
    public WebElement textoConfirmeASenha;
	
	@FindBy(xpath = "//form/div[3]/input[1]")
    public WebElement inputConfirmeASenha;
	
	@FindBy(xpath = "//*[text() = 'Salvar']")
    public WebElement botaoSalvar;    
    
}
