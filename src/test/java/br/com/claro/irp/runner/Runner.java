package br.com.claro.irp.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features =  {
				"src/test/resources/irp/features/teste.feature"
				     }
		, glue =  "br.com.claro.irp.steps"
		, tags =  ""
		, plugin =  {"pretty",  "json:target/cucumber.json"}			  
		, monochrome =  false //não coloca a tela colorida
		, snippets =  SnippetType.CAMELCASE //Remove o _ no nome dos métodos
		, dryRun =  false //Valida se os steps estão corretos sem executar os testes
		)

public class Runner {
	@AfterClass
	public static void fecharBrowser() {
		//DriverFactory.killDriver();
	}
}
