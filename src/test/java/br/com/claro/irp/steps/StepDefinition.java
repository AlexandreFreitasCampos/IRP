package br.com.claro.irp.steps;

import br.com.claro.irp.pages.pageActions.PageFactory;
import br.com.claro.irp.pages.world.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
    World world =  new World();

    @Given("que acessei a classe {string}")
    public void queAcesseiAClasse(String string) throws ClassNotFoundException {
        world.pageAction = PageFactory.pegarTela(string);
    }
    @When("valido a URL {string}")
    public void validoAURL(String string) {
        world.pageAction.getURL(string);
    }
    @When("valido o texto {string}")
    public void validoOTexto(String string) {
        world.pageAction.getTexto(string);
    }
    @When("escrevo o texto {string}")
    public void escrevoOTexto(String string) {
        world.pageAction.setTexto(string);
    }

    @When("valido o componente {string}")
    public void validoOComponente(String string) {
        world.pageAction.getComponente(string);
    }
    @Then("clico no botao {string}")
    public void clicoNoBotao(String string) {
        world.pageAction.clicarBotao(string);
    }
}
