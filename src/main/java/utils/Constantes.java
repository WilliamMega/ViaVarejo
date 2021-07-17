package utils;

import java.io.File;

public class Constantes {
	
	//Config Properties file
	
	public final static String config_propertires = System.getProperty("user.dir") +
										File.separator + "configs" + File.separator + "extension-config.xml";
	
	//Path Drivers
	
	public static final String pathDriverWindows = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "windows" + File.separator;

	public static final String pathDriverLinux = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "linux" + File.separator;
	
	//Drivers
	
	public static final String chromeDriverWindows = "chromedriver.exe";

	public static final String fireforDriverWindows = "geckodriver.exe";
	
	public static final String chromeDriverLinux = "chromedriver";

	public static final String firefoxDriverLinux = "geckodriver";
	
	//Download Path Driver
	
	public static final String downloadPathDriver = System.getProperty("user.dir") + File.separator + "files_environment" + File.separator;

	//URL Portal de Multas - User e Pass
	
	public static final String urlPortalVVTest = "http://www.lourencodemonaco.com.br/vvtest/";
	
	//Formata de Data
	
    public static final String formatoDataWindows = "dd/MM/yyyy";
    
    public static final String formatoDataHoraWindows = "dd/MM/yyyy HH-mm-ss";
    
    public static final String formatoDataFile = "dd-MM-yyyy_HH-mm-ss";
    
    public static final String formatoHoraDataBancoDados = "yyyy-MM-dd";
    
    public static final String formatoHoraDataHoraBancoDados = "yyyy-MM-dd HH-mm-ss";
    
    //Constantes DTO
    
    public static final String teste = "teste";
    
}