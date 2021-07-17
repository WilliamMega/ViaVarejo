package pagePortalVVTest;

import core.BasePage;
import utils.Constantes;
import utils.Utils;

public class TelaInicialPage extends BasePage {
	
	public void entrarPortalVVTest(){
		
		dsl.escreverURL(Constantes.urlPortalVVTest);
		System.out.println("Entrando no Portal VVTest");
	}

	public void clicarOpcaoPesquisaQA(){
		
		String xpath = "//a[text()='Pesquisa – QA']";
		
		dsl.webDriverWaitLinkTextClickable(4, xpath);
		dsl.clicarBotaoXpath(xpath);
		Utils.wait(3);
		dsl.webDriverWaitName(2, "fname");
	}
}