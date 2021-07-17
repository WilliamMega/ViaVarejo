package stepDefinitions;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;

import core.DriverFactory;
import core.ExtentReport;
import core.Propriedades;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHooks extends DriverFactory {
	
	public static ExtentReports extent;
	public static String testName;
	
	@Before
	public void setup(Scenario cenario) {
		
		String browserStr = Propriedades.browser.toString();
		String tipoExecucaoStr = Propriedades.tipoExecucao.toString();
		
		System.out.println("Before ........" + cenario.getName());
		System.out.println("O browser é " + browserStr);
		System.out.println("O tipo de execucao é " + tipoExecucaoStr);
		
		//Recuperar nome do Teste
		testName = cenario.getName()+"-"+browserStr+"-"+tipoExecucaoStr;
		
		System.out.println(testName);
		
		//Iniciar o relatorio
		extent = ExtentReport.StartReport(testName);
	}
	
	@After
	public void finalizar(Scenario result) throws IOException {
		
		System.out.println("After ........");
		
		//Validar Resultado dos Testes
		ExtentReport.ResultTest(result);
	
		//Atualizando relatório
		extent.flush();

		// Fechando Browser
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
		
	}
}