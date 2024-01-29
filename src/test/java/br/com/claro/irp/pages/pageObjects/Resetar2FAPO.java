package br.com.claro.irp.pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;

public class Resetar2FAPO extends DriverFactory{
	public Resetar2FAPO() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//*[text() = 'Admin']")
	public WebElement menuAdmin; 
	
	@FindBy(xpath = "//*[text() = 'Resetar 2FA']")
	public WebElement menuResetar2FA; 
	
	@FindBy(xpath = "//div[@class='alert alert-warning']")
    public WebElement textoAlerta;
    
    @FindBy(xpath = "//button[@class='btn btn-danger']")
    public WebElement botaoRedefinir;
    
    
}
