package br.com.claro.irp.pages.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;

public class MenuPO extends DriverFactory {
	public MenuPO(){
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()='IRP ']")
    public WebElement textoIRP;
    
    @FindBy(xpath = "//*[text()='Relatórios']")
    public WebElement menuRelatorios;

    @FindBy(xpath = "//*[text()='Faturamento']")
    public WebElement menuFaturamento;
    
    @FindBy(xpath = "//*[text()='Histórico de Faturas']")
    public WebElement menuHistóricoDeFaturas;
    
    @FindBy(xpath = "//*[text()='Admin']")
    public WebElement menuAdmin;    

    @FindBy(xpath = "//select[@id='culture']/option")
    public List<WebElement> listaIdiomas;

    @FindBy(xpath = "//div[@class='collapse navbar-collapse']/span")
    public WebElement textoOla;

    @FindBy(xpath = "//button[text()='Sair']")
    public WebElement btnSair;
}
