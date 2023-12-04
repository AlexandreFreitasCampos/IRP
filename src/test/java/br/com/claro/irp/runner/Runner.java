package br.com.claro.irp.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import br.com.claro.irp.utils.DriverFactory;
import br.com.claro.irp.utils.PDF;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features =  {
				"src/test/resources/irp/features/01_validar_telas_sistema.feature"
				//,"src/test/resources/irp/features/02_login.feature"		
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
		PDF.salvaDocumento();
		//DriverFactory.killDriver();
	}
}
