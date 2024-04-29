package br.com.claro.runner;

import br.com.claro.utils.DriverFactory;
import br.com.claro.utils.PDF;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features =  {
				"src/test/resources/features/irp.feature"
				     }
		, glue =  "br.com.claro.steps"
		, tags =  ""
		, plugin =  {"pretty",  "json:target/cucumber.json"}			  
		, monochrome =  false //não coloca a tela colorida
		, snippets =  SnippetType.CAMELCASE //Remove o _ no nome dos métodos
		, dryRun =  false //Valida se os steps estão corretos sem executar os testes
		)

public class Runner {
	@AfterClass
	public static void fecharBrowser() {
		PDF.salvaDocumento();
		//DriverFactory.killDriver();
	}
}
