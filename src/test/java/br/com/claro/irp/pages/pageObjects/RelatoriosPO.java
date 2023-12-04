package br.com.claro.irp.pages.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.claro.irp.utils.DriverFactory;



public class RelatoriosPO extends DriverFactory{
	
    public RelatoriosPO(){
        PageFactory.initElements(getDriver(),  this);
    }    
   
    @FindBy(xpath = "//div[@class='card-header']     ")
    public WebElement textoFiltroDeRelatorios;
    
    @FindBy(xpath = "//*[text()='Conta']")
    public WebElement textoConta;
    
    @FindBy(xpath = "//*[@id='account']")
    public WebElement selectContas;
    
    @FindBy(xpath = "//*[@id='account']/option    ")
    public List<WebElement> listaContas;
    
    @FindBy(xpath = "//*[text()='Serviço']")
    public WebElement textoSerivico;
    
    @FindBy(xpath = "//*[@id='service']")
    public WebElement selectServicos;
    
    @FindBy(xpath = "//*[@id='service']/option")
    public List<WebElement> listaServicos;
    
    @FindBy(xpath = "//*[text()='País']")
    public WebElement textoPais;
    
    @FindBy(xpath = "//*[@id='country']")
    public WebElement selectPaises;
    
    @FindBy(xpath = "//*[@id='country']/option")
    public List<WebElement> listaPaises;
    
    @FindBy(xpath = "//*[text()='Período Inicial']")
    public WebElement textoPeriodoInicial;
    
    @FindBy(xpath = "//*[@id='firstPeriod']")
    public WebElement calendarioInicio;
    
    @FindBy(xpath = "//*[text()='Período Final']")
    public WebElement textoPeriodoFinal;
    
    @FindBy(xpath = "//*[@id='lastPeriod']")
    public WebElement calendarioFim;
    
    @FindBy(xpath = "//*[text()='Status']")
    public WebElement textoStatus;
    
    @FindBy(xpath = "//*[@id='statusReport']")
    public WebElement selectStatus;
    
    @FindBy(xpath = "//*[@id='statusReport']/option")
    public List<WebElement> listaStatus;
    
    @FindBy(xpath = "//*[text()='Listar']")
    public WebElement btnListar;
    
    @FindBy(xpath = "//*[@id='cookieConsent']")
    public WebElement textoUsamosCookies;
    
    @FindBy(xpath = "//*[text()='Aceitar']")
    public WebElement btnAceitar;
    
    @FindBy(xpath = "//*[text()='Troca de senha']")
    public WebElement btnTrocaDeSenha;
    
    @FindBy(xpath = "//*[text()='Registro de Usuários']")
    public WebElement btnRegistroDeUsuarios;
    
    @FindBy(xpath = "//*[text()='Listagem de Usuários']")
    public WebElement btnListagemDeUsuarios;
    
    @FindBy(xpath = "//*[text()='Resetar 2FA']")
    public WebElement btnResetar2FA;
    
    @FindBy(xpath = "//*[text()='Trocar Senha']")
    public WebElement textoTrocarSenha;
    
    @FindBy(xpath = "//*[text()='Senha atual']")
    public WebElement textoSenhaAtual;
    
    @FindBy(xpath = "//*[text()='Nova senha']")
    public WebElement textoNovaSenha;
    
    @FindBy(xpath = "//*[text()='Confirme a senha']")
    public WebElement textoConfirmeASenha;
    
    @FindBy(xpath = "//*[text()='Salvar']")
    public WebElement btnSalvar;
    
    @FindBy(xpath = "//*[text()='Registro de usuário ']")
    public WebElement textoRegistroDeUsuario;
    
    @FindBy(xpath = "//*[text()='Nome']")
    public WebElement textoNome;
    
    @FindBy(xpath = "//*[text()='Email']")
    public WebElement textoEmail;
    
    @FindBy(xpath = "//*[text()='Usuário']")
    public WebElement textoUsuario;
    
    @FindBy(xpath = "//*[text()='Perfil']")
    public WebElement textoPerfil;
    
    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement campoTextoNome;
    
    @FindBy(xpath = "//*[@id='Email']")
    public WebElement campoTextoEmail;
    
    @FindBy(xpath = "//*[@id='Email']")
    public WebElement campoTextoUsuario;
    
    @FindBy(xpath = "//*[@id='SelectProfile']")
    public WebElement selectPerfil;
    
    @FindBy(xpath = "//*[@id='SelectProfile']/option")
    public List<WebElement> listaPerfil;
    
    @FindBy(xpath = "//*[text()='Gravadora/Editora']")
    public WebElement textoGravadoraEditora;
    
    @FindBy(xpath = "//*[text()='Serviço']")
    public WebElement textoServico;
    
    @FindBy(xpath = "//span[text()='Nenhum selecionado']")
    public WebElement textoNenhumSelecionado;
    
    @FindBy(xpath = "//form[@name='form-createuser']/div[2]/div[1]/div/ul/li/a/label")
    public List<WebElement> listaGravadoraEditora;
    
    @FindBy(xpath = "//form[@name='form-createuser']/div[2]/div[2]/div/ul/li/a/label")
    public List<WebElement> listaServicoRegistro;
    
    @FindBy(xpath = "//form[@name='form-createuser']/div[2]/div[3]/div/ul/li/a/label")
    public List<WebElement> listaPaisRegistro;
    
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/form/div[2]/div[1]/div/button")
    public WebElement selectGravadorEditora;
    
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/form/div[2]/div[2]/div/button")
    public WebElement selectServico;
    
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/form/div[2]/div[3]/div/button")
    public WebElement selectPais;
    
    
    
    
}
