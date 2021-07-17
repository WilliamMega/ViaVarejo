package core;
import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utils;

public class DSL {
	
	/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public void escreverXpathInputFile(String xpath, String texto){
		getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
	}
	
	public void escreverIdInputFile(String id, String texto){
		getDriver().findElement(By.id(id)).sendKeys(texto);
	}
	
	public void escreverName(String name, String texto){
		escrever(By.name(name), texto);
	}

	public void escreverXpath(String xpath, String texto){
		escrever(By.xpath(xpath), texto);
	}
	
	public String obterValorCampoXpathConteudo(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	/********* Escrever URL System ************/
	
	public void escreverURL(String urlSystem) {
		getDriver().get(urlSystem);
	}
	
	public void fecharBrowser() {
		killDriver();
	}
	
	/********* Radio e Check ************/
	

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadioXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	public boolean isRadioMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarCheckName(String name) {
		getDriver().findElement(By.name(name)).click();
	}
	
	public void clicarCheckXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public boolean isCheckMarcadoXpath(String xpath){
		return getDriver().findElement(By.xpath(xpath)).isSelected();
	}
	
	/********* WebDriver - Wait ************/
	
	public void webDriverWaitXPathClickable(int time, String xpath){
		
		//Espera
		
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	
	}
	
	public void webDriverWaitLinkTextClickable(int time, String xpath){
		
		//Espera
		
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void webDriverWaitXPathVisibility(int time, String xpath){
		
		//Espera
		
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	
	}
	
	public void webDriverWaitXPath(int time, String xpath){
	
		//Espera
		
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	
	}
	
	public void webDriverWaitId(int time, String id){
		
		//Espera
		
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	
	}
	
	public void webDriverWaitName(int time, String name){
		
		//Espera
		
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	
	}
	
		//Espera sem tempo
	
	public void webDriverWaitXPathNoTime(String xpath){
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	
	}
	
	/********* Refresh ************/
	
	public void wedDriverRefresh (){
		getDriver().navigate().refresh();
	}	
	
	/********* Combo ************/
	
	public void selecionarComboXpath(String xpath, String valor) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("id"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}

	/********* Click ************/	
	
	public void clicarCampoSelecao(String xpath1, String xpath2) {
		getDriver().findElement(By.xpath(xpath1)).click();
		Utils.wait(2);
		getDriver().findElement(By.xpath(xpath2)).click();
		Utils.wait(2);
	}	
	
	public void clicarSugestaoText(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
		Utils.wait(2);
	}
	
	/********* Botao ************/
	
	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarBotaoXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String obterAtributoBotaoXpath(String xpath, String atributo) {
		return getDriver().findElement(By.xpath(xpath)).getAttribute(atributo);
	}
	
	public void clicarBotaoName(String name) {
		getDriver().findElement(By.name(name)).click();
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public void clicarPartialLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public String obterTextoXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}
	
	/********* Value ************/
	
	public String obterValue(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public String obterValueXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getAttribute("value");
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Utils DSL ************/
	
	public void mandarTABXpath (String Xpath) {
		getDriver().findElement(By.xpath(Xpath)).sendKeys(Keys.TAB);
	}
	
	public void mandarTABName (String name) {
		getDriver().findElement(By.name(name)).sendKeys(Keys.TAB);
	}
	
	public void mandarEnterXpath (String Xpath) {
		getDriver().findElement(By.xpath(Xpath)).sendKeys(Keys.ENTER);
	}
	
	public void mandarBackSpaceXpath (String Xpath) {
		getDriver().findElement(By.xpath(Xpath)).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
	} 
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	public void trocarAba(int pos) {
		
		//0 - Atual
		//1 - Proxima
		
	    List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
	    getDriver().switchTo().window(windowHandles.get(pos));
	}
	
	/*********  Action Driver   ************/
	
	public void actionMoveDriverXPath(String xpath) {
		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(xpath))).perform();
	}
	
	public void actionDriverXPath(String xpath) {
		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(xpath))).click().perform();
	}
	
	public void doubleClickDriverXPath(String xpath) {
		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(xpath))).doubleClick().perform();
	}
	
	/************** JS *********************/
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	public void rolarTopoDaPagina() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	
	public void rolarFinalDaPagina() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/*********  TR   ************/
	
	public void clicarElement(String xpath, int pos) {
		List<WebElement> l = getDriver().findElements(By.xpath(xpath));
		
		l.get(pos).click();
	}
	
	public List<WebElement> obterElementos(String xpath) {
		return getDriver().findElements(By.xpath(xpath));
	}
	
	public WebElement obterElemento(String xpath) {
		return getDriver().findElement(By.xpath(xpath));
	}
	
	/*********  Retornar Tamanho WebElement   ************/
	
	public int tamanhoWebElement(String xpath) {
		List<WebElement> list = getDriver().findElements(By.xpath(xpath));
		
		int tam = list.size();
		
		return tam;
	}
	
	public int tamanhoWebElementID(String id) {
		List<WebElement> list = getDriver().findElements(By.id(id));
		
		int tam = list.size();
		
		return tam;
	}
	
}