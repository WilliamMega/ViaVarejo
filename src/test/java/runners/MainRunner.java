package runners;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import core.DriverFactory;
import core.Propriedades;
import core.Propriedades.Ambientes;
import core.Propriedades.Browsers;
import core.Propriedades.TipoExecucao;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinitions.MasterHooks;

	//https://testingneeds.wordpress.com/2015/09/15/junit-runner-with-cucumberoptions/
	//https://cucumber.io/docs/guides/10-minute-tutorial/
	//https://www.baeldung.com/cucumber-scenario-outline

		@RunWith(Cucumber.class)
		@CucumberOptions(
			features = "src/test/java/resources/features/",
			glue = "stepDefinitions",
			tags = {"@Cadastro"},
			plugin = { "pretty"},
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			dryRun = false,
			strict = false
		)

	public class MainRunner extends AbstractTestNGCucumberTests {

		@Parameters({ "browser" , "tipoExecucao", "ambiente" })
		@BeforeMethod
		public static void iniciarTudo(@Optional("CHROME") Browsers browser, @Optional("LOCAL") TipoExecucao tipoExecucao,
		@Optional("HOMOLOGACAO") Ambientes ambiente) {

		Propriedades.ambiente = ambiente;
		Propriedades.browser = browser;
		Propriedades.tipoExecucao = tipoExecucao;

	}

	@AfterSuite
	public static void finalizartudo() throws IOException {
		System.out.println("AfterSuite........");
		DriverFactory.killDriver();
		MasterHooks.extent.flush();
	}
}