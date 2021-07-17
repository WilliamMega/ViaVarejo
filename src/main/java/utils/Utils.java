package utils;

import static core.DriverFactory.getDriver;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Utils {
	
	public static String geraCPF() {

		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;

		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);

		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		int valor2 = (soma2 / 11) * 11;

		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + "." + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + "." + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9) + "-";

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		numeroGerado = numerosContatenados + nDigResult;

		System.out.println("CPF Gerado " + numeroGerado);

		return numeroGerado;
	}

	public static String geraCNPJ() {

		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;

		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);
		int n10 = numeroAleatorio.nextInt(10);
		int n11 = numeroAleatorio.nextInt(10);
		int n12 = numeroAleatorio.nextInt(10);

		int soma = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4
				+ n1 * 5;

		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3
				+ n3 * 4 + n2 * 5 + n1 * 6;

		int valor2 = (soma2 / 11) * 11;

		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + "." + String.valueOf(n3) + String.valueOf(n4)
				+ String.valueOf(n5) + "." + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8) + "/"
				+ String.valueOf(n9) + String.valueOf(n10) + String.valueOf(n11) + String.valueOf(n12) + "-";

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		numeroGerado = numerosContatenados + nDigResult;
		System.out.println("CNPJ gerado: " + numeroGerado);
		return numeroGerado;
	}

	public static int randomInt(int qtd, int param) {

		Random gerador = new Random();
		int num = 0;

		for (int i = 0; i < qtd; i++) {
			num = num + (gerador.nextInt(param));
		}

		return num;
	}

	public static void wait(int timeSeconds) {

		try {
			Thread.sleep(timeSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String createScreenshot(String testName) throws IOException {

		// Gerando ScreenShot ao final dos testes

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + "screenshot"
				+ File.separator + testName + " " + timestamp() + ".jpg";
		// String path = FileUtils.copyFile(arquivo, new File("target" + File.separator
		// + "screenshot" +
		// File.separator + testName.getMethodName() + " " + timestamp() + ".jpg"));
		File destination = new File(path);

		try {
			FileUtils.copyFile(arquivo, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}

		return path;
	}

	public static String createScreenshot64() throws IOException {

		// Gerando ScreenShot ao final dos testes

		 String base64Screenshot = null;

		base64Screenshot = "data:image/jpg;base64, " + ((TakesScreenshot) getDriver()).
		            getScreenshotAs(OutputType.BASE64);

		return base64Screenshot;
	}
	
	private static Random rand = new Random();

	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	public static String stringAleatoria(int nCaracter) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < nCaracter; i++) {
			int ch = rand.nextInt(letras.length);
			sb.append(letras[ch]);
		}

		return sb.toString();
	}
	
	public static String stringSomenteLetras(int nCaracter) {

		SecureRandom secureRandom = new SecureRandom();
		
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder generatedString = new StringBuilder();
		
		for (int i = 0; i < nCaracter; i++) {
		        int randonSequence = secureRandom .nextInt(CHARACTERS.length());
		        generatedString.append(CHARACTERS.charAt(randonSequence));
		}

		return generatedString.toString();
	}

	public static void clickTeclaEnter() {

		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(1500);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void ctrlA() {

		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(1500);

			robot.keyPress(KeyEvent.VK_CONTROL);
			wait(1);
			robot.keyPress(KeyEvent.VK_A);

			wait(1);

			robot.keyRelease(KeyEvent.VK_A);
			wait(1);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static void ctrlC() {

		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(1500);

			robot.keyPress(KeyEvent.VK_CONTROL);
			wait(1);
			robot.keyPress(KeyEvent.VK_C);

			wait(1);

			robot.keyRelease(KeyEvent.VK_C);
			wait(1);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static void ctrlV() {

		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(1500);

			robot.keyPress(KeyEvent.VK_CONTROL);
			wait(1);
			robot.keyPress(KeyEvent.VK_V);

			wait(1);

			robot.keyRelease(KeyEvent.VK_V);
			wait(1);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static String copyCtrlC() {

		String newString = "";

		try {
			newString = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newString;
	}

	public static String AddFileWindow(String file) {

		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + "files_ambiente" + File.separator + file;
		StringSelection ss = new StringSelection(pathFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		return pathFile;
	}
	
	public static String diaAtual() {
		return new SimpleDateFormat("dd").format(new Date());
	}

	public static String timestamp() {
		return new SimpleDateFormat(Constantes.formatoDataHoraWindows).format(new Date());
	}
	
	public static String getDataAtualHoraDataBancoDados() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constantes.formatoHoraDataBancoDados);
		LocalDate localDate = LocalDate.now();
		return (dtf.format(localDate));
	}

	public static String getDataAtual() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constantes.formatoDataWindows);
		LocalDate localDate = LocalDate.now();
		return (dtf.format(localDate));
	}
	
	public static boolean compararDatas(String date1, String date2) {
		
		//date1 = data atual
		//date2 - outra data
	
		LocalDate dt1 = LocalDate.parse(date1);
		LocalDate dt2 = LocalDate.parse(date2);
		
		if (dt2.isBefore(dt1)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static String obterDataDiferencaDias(int dias) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);

		Date date = cal.getTime();

		DateFormat dateFormat = new SimpleDateFormat(Constantes.formatoDataWindows);
		String dataFormatada = dateFormat.format(date);

		return dataFormatada;
	}
	
	public static String obterDataDiferencaData(String data, int dias) {

		DateFormat dateFormat = new SimpleDateFormat(Constantes.formatoHoraDataBancoDados);
		
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime(dateFormat.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.add(Calendar.DATE, dias);
		Date date = cal.getTime();
		String dataFormatada = dateFormat.format(date);

		return dataFormatada;
	}
	
	public static String obterDataDiferencaDataFormatoWindows(String data, int dias) {

		DateFormat dateFormat = new SimpleDateFormat(Constantes.formatoDataWindows);
		
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime(dateFormat.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.add(Calendar.DATE, dias);
		Date date = cal.getTime();
		String dataFormatada = dateFormat.format(date);

		return dataFormatada;
	}	
	
	public static String dataAtualDiaSemana() {

		Calendar cal = Calendar.getInstance();
		return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];

	}

	public static int diferencaEntreDatas(String date1, String date2) {

		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.formatoDataWindows);
		int diferencaDias = 0;

		try {
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			long differenceMilliSeconds = d2.getTime() - d1.getTime();
			diferencaDias = (int) (differenceMilliSeconds / 1000 / 60 / 60 / 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return diferencaDias;

	}
	
	public static String diferencaEntreDatasBancoDeDados(String date1, String date2) {
		
		//2016-10-17 00:00:00.000
		//2019-04-04 00:00:00.000
		
		String data = null;
		String newDate;
		Date d = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.formatoHoraDataBancoDados);
		int diferencaDias = 0;
		
		date1 = date1.split(" ")[0];
		date2 = date2.split(" ")[0];
		
		if (date1.equals(date2)) {
			data = date1;
		} else {
			try {
				Date d1 = sdf.parse(date1);
				Date d2 = sdf.parse(date2);
				long differenceMilliSeconds = d2.getTime() - d1.getTime();
				diferencaDias = (int) (differenceMilliSeconds / 1000 / 60 / 60 / 24);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (diferencaDias > 1) {
				data = obterDataDiferencaData(date2, -1);
			}
		}
		
		//Convertendo formato de data
		
		try {
			d = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		sdf.applyPattern(Constantes.formatoDataWindows);
		newDate = sdf.format(d);

		return newDate;

	}

	public static List<String> lerArquivoTxt(String fileTxt, String pasta) {

		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + pasta + File.separator + fileTxt;

		List<String> listaString = new ArrayList<String>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(pathFile));

			for (String linha = br.readLine(); linha != null; linha = br.readLine()) {

				listaString.add(linha);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaString;

	}

	public static List<String> lerArquivoCvs(String fileCvs, String separator, String pasta) {

		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + pasta + File.separator + fileCvs;

		List<String> listaString = new ArrayList<String>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(pathFile));

			for (String linha = br.readLine(); linha != null; linha = br.readLine()) {

				listaString.add(linha);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		String resultado = listaString.toString();
		resultado = resultado.replace("[", "");
		resultado = resultado.replace("]", "");

		StringTokenizer substr = new StringTokenizer(resultado);

		List<String> listaStringFormatada = new ArrayList<String>();

		while (substr.hasMoreElements()) {
			listaStringFormatada.add(substr.nextToken(separator));
		}

		return listaStringFormatada;

	}
	
	//Arquivo XLS
	
	public static List<Integer> retornarQtdeLinhasColunasPlanilhaExcelXls(String fileXls, String pasta) {

		List<Integer> list = new ArrayList<Integer>();
		
		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + pasta + File.separator + fileXls;

		Workbook wb = null;
		Sheet sheet = null;
		
			try {
				wb = Workbook.getWorkbook(new File(pathFile));
				sheet = wb.getSheet(0);
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


		list.add(sheet.getRows()); //Linhas
		list.add(sheet.getColumns()); //Colunas
		
		return list;
		
	}
	
	public static String[][] lerArquivoXls(String fileXls, String pasta, int x, int y) {

		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + pasta + File.separator + fileXls;

		Workbook wb = null;
		Sheet sheet = null;
		
			try {
				wb = Workbook.getWorkbook(new File(pathFile));
				sheet = wb.getSheet(0);
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		String l[][] = new String[x][y];
		// O primeiro cochete é referente ao numero de linhas.
		// O segundo cochete é referente ao numero de colunas.

		for (int i = 0; i < x; i++) {
			
			for (int j = 0; j < y; j++) {
				Cell a = sheet.getCell(j, i); //Coluna, Linhas
				String as = a.getContents();
				l[i][j] = as;
			}
		}

		wb.close();

		return l;
	}
	
	//Arquivo XLSX
	
	@SuppressWarnings({ "resource", "unused", "rawtypes" })
	public static List<Integer> retornarQtdeLinhasColunasPlanilhaExcel(String fileXls, String pasta)
			throws BiffException, IOException {

		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + pasta + File.separator + fileXls;

		InputStream ExcelFileToRead = new FileInputStream(pathFile);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;
		XSSFCell cellRow;

		Iterator rows = sheet.rowIterator();

		int a = 0; // linhas
		int b = 0; // colunas

		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			Iterator cellsRow = row.cellIterator();
			
			if (cellsRow.hasNext()) {
				cellRow = (XSSFCell) cellsRow.next();
				if (!cellRow.getStringCellValue().isEmpty()) {
					String str = (cellRow.getStringCellValue());
					a++;
				}
			}

			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				if (!cell.getStringCellValue().isEmpty()) {
					String str = (cell.getStringCellValue());
					b++;
				}
			}
		}
		
		b = b/a;
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		
		return list;
	}
	
	@SuppressWarnings({ "resource", "unused", "rawtypes", "deprecation" })
	public static String[][] lerArquivoXlsx(String fileXls, String pasta, int x, int y) throws BiffException, IOException {
		// int x: É referente ao numero de linhas.
		// int y: É referente ao numero de colunas.

		String path = System.getProperty("user.dir");
		String pathFile = path + File.separator + pasta + File.separator + fileXls;

		String l[][] = new String[x][y];
		// O primeiro cochete é referente ao numero de linhas.
		// O segundo cochete é referente ao numero de colunas.

		InputStream ExcelFileToRead = new FileInputStream(pathFile);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook();

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		int a = 0; // linhas
		int b = 0; // colunas

		// while (rows.hasNext())
		while (a < x) {
			if (b == y) {
				b = 0;
			}

			row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			// while (cells.hasNext())
			while (b < y) {
				cell = (XSSFCell) cells.next();

				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {

					String str = (cell.getStringCellValue());
					l[a][b] = cell.getStringCellValue();
				}

				b++;
			}
			a++;
		}

		return l;

	}

}