package core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;

import cucumber.api.Scenario;
import gherkin.formatter.model.Result;
import utils.Constantes;
import utils.Utils;

public class ExtentReport {
	
	protected static ExtentReports extent;
	protected static ExtentTest logger;
	protected static ExtentTest extentTest;
	protected static ExtentSparkReporter sparkReporter;
	public static String time = new SimpleDateFormat(Constantes.formatoDataFile).format(new Date());

	public final static String nameReport = "ExtentReport_Automation_ViaVarejo_Portal_VVTest_" + time + ".HTML";

	public static String diretorioReport = "";
	public static String diretorioReportDefault = System.getProperty("user.dir") + File.separator + "report";
	public static String diretorioReportBackup = System.getProperty("user.dir") + File.separator + "report"
			+ File.separator + "backup";

	public static ExtentReports StartReport(String testName) {

		// Para criar o relatorio somente uma vez

		if (extent == null) {

			diretorioReport = System.getProperty("user.dir") + File.separator + "report" + File.separator + nameReport;

			sparkReporter = new ExtentSparkReporter(diretorioReport);
			sparkReporter.config().setDocumentTitle("Relatório de automação - Portal VV Test");
			sparkReporter.config().setReportName("Relatório de automação");
			sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
			sparkReporter.config().setEncoding("utf-8");
			sparkReporter.config().setProtocol(Protocol.HTTPS);
			sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH-mm-ss");
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}

		logger = extent.createTest(testName);

		return extent;
	}

	public static void ResultTest(Scenario cenario) throws IOException {

		//https://static.javadoc.io/info.cukes/cucumber-core/1.2.5/cucumber/api/Scenario.html

		//String getStatus()
		//Returns:
		//the most severe status of the Scenario's Steps. One of "passed", "undefined", "pending", "skipped", "failed"

		if (cenario.isFailed()) {

			String base64Screenshot = null;

			logger.fail("O caso de teste falhou, favor analizar o erro! <br>");
			base64Screenshot = Utils.createScreenshot64();
			logger.fail("Print do erro, clique ao lado para ver o erro: ",
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
			logError(cenario);
		}
		
		if (cenario.getStatus() == "passed") {
			logger.pass("Teste com Sucesso.");
		}
		
		if (cenario.getStatus() == "skipped") {
			logger.skip("Teste ignorado");
		}
	}

	private static void logError(Scenario cenario) {
		Field field = FieldUtils.getField(((Scenario) cenario).getClass(), "stepResults", true);
		field.setAccessible(true);

		try {
			@SuppressWarnings("unchecked")
			ArrayList<Result> results = (ArrayList<Result>) field.get(cenario);

			for (Result result : results) {
				if (result.getError() != null)
					logger.fail(result.getError());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
