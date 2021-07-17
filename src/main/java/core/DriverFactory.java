package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;

import core.Propriedades.TipoExecucao;
import utils.Constantes;

public class DriverFactory {

	protected static WebDriver driver;
	private static Platform platform;
	
	protected DriverFactory() {
	}

	public static WebDriver getDriver() {
		
		if(Propriedades.tipoExecucao == TipoExecucao.LOCAL){
		
				if (driver == null) {
					switch (Propriedades.browser) {
					case CHROME:
						executeChrome();
						break;
					case FIREFOX:
						executeFirefox();
						break;
					default:
						break;
					}
				}
		}
		
		if (Propriedades.tipoExecucao == TipoExecucao.HEADLESS) {

			if (driver == null) {
				switch (Propriedades.browser) {
					case CHROME:
						executeChromeHeadLess();
						System.out.println("Abriu Browser HeadLess");
						break;
					case FIREFOX:
						executeFirefoxHeadLess();
						break;
				default:
					break;
				}

				driver.manage().window().maximize();
			}

		}

		//https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
		//https://app.saucelabs.com/dashboard/onboarding
		//Automated Tests
		//https://app.saucelabs.com/dashboard/tests


		//https://saucelabs.com/blog/selenium-tips-uploading-files-in-remote-webdriver
		if (Propriedades.tipoExecucao == TipoExecucao.NUVEM) {

			if (driver == null) {
				DesiredCapabilities cap = null;
				switch (Propriedades.browser) {
					case CHROME:
						cap = DesiredCapabilities.chrome();
						cap.setCapability("platform", "Windows 10");
						cap.setCapability("version", "74.0");
						break;
					case FIREFOX:
						cap = DesiredCapabilities.firefox();
						cap.setCapability("platform", "Windows 10");
						cap.setCapability("version", "67.0");
						break;
					case IE:
						cap = DesiredCapabilities.internetExplorer();
						break;
					case EDGE:
						cap = DesiredCapabilities.edge();
						break;
				}

				try {
					cap.setCapability("name", "Remote File Upload using Selenium 2's FileDetectors");
					driver = new RemoteWebDriver(new URL("http://WilliamSoares:fcfd1351-de71-454b-b91b-14483d801a41@ondemand.saucelabs.com:80/wd/hub"), cap);
					((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				} catch (MalformedURLException e) {
					System.err.println("Falha ao conectar a NUVEM");
				}
				driver.get(Constantes.urlPortalVVTest);
				System.out.println("Abriu Browser Nuvem");
			}
		}

		return driver;
	}
	
	public static void executeChrome(){
		
		//Path Download - Inicio
		
		String downloadFilepath = Constantes.downloadPathDriver;
		
	    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    chromePrefs.put("download.default_directory", downloadFilepath);
	    
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("prefs", chromePrefs);
	    options.addArguments("--test-type");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--start-maximized");
	    
	    //Path Download - Fim

		String driverpathChrome = getReportFileLocation();
		System.setProperty("webdriver.chrome.driver", driverpathChrome);
		
		driver = new ChromeDriver(options);
	}

	public static void executeChromeHeadLess(){
		
		//Path Download - Inicio
		
		String downloadFilepath = Constantes.downloadPathDriver;
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    chromePrefs.put("download.default_directory", downloadFilepath);

		String driverpathChrome = getReportFileLocation();
		System.setProperty("webdriver.chrome.driver", driverpathChrome);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
	    options.addArguments("--test-type");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--start-maximized");
	    
	    //Path Download - Fim
	    
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
	}

	public static void executeFirefoxHeadLess(){

		String driverpathFirefox = getReportFileLocation();
		System.setProperty("webdriver.gecko.driver", driverpathFirefox);
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--headless");
		options.addArguments("--start-maximized");
		
		driver = new FirefoxDriver(options);
	}


	public static void executeFirefox(){

		String driverpathFirefox = getReportFileLocation();
		System.setProperty("webdriver.gecko.driver", driverpathFirefox);
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("--start-maximized");
		
		driver = new FirefoxDriver(options);
	}

    private static Platform getCurrentPlatform () {
        
    	if (platform == null) {
        	
            String operSys = System.getProperty("os.name").toLowerCase();
            System.out.println(operSys.toUpperCase());
            
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            	} else {
                platform = Platform.LINUX;
            	}
        }
        
        return platform;
    }
    
    private static String getReportFileLocation () {
        String reportFileLocation = null;
        
        String browser = Propriedades.browser.toString();
        platform = getCurrentPlatform();
        
        if ((platform.toString().equals("WINDOWS")) && (browser.equals("CHROME"))) {
        	reportFileLocation = Constantes.pathDriverWindows + Constantes.chromeDriverWindows;
        }
        
        if ((platform.toString().equals("WINDOWS")) && (browser.equals("FIREFOX"))) {
        	reportFileLocation = Constantes.pathDriverWindows + Constantes.fireforDriverWindows;
        }
        
        if ((platform.toString().equals("LINUX")) && (browser.equals("CHROME"))) {
        	reportFileLocation = Constantes.pathDriverLinux + Constantes.chromeDriverLinux;
        }
        
        if ((platform.toString().equals("LINUX")) && (browser.equals("FIREFOX"))) {
        	reportFileLocation = Constantes.pathDriverLinux + Constantes.firefoxDriverLinux;
        }
        
        return reportFileLocation;
    }
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();			
			driver = null;
		}
	}
}
