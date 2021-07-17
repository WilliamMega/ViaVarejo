package pagePortalVVTest;

import java.util.Locale;
import com.github.javafaker.Faker;
import core.BasePage;

public class PreencherTodosCamposObrigatoriosPage extends BasePage {
	
	Faker faker = new Faker(new Locale("pt-BR"));
	
	public void informarTodosCamposObrigatorios() {
		dsl.escreverName("fname", faker.name().firstName());
		dsl.escreverName("lname", faker.name().lastName());
		dsl.escreverName("email", "teste@gmail.com");
		dsl.escreverXpath("//label[contains(text(),'Confirmação de email')]/following::input[1]"
				, "teste@gmail.com");
		dsl.escreverName("phone", faker.numerify("##-#####-####"));
		dsl.clicarRadioXpath("//label[contains(text(),'31-49')]");
		dsl.clicarRadioXpath("//label[contains(text(),'Liderança')]");
		dsl.escreverXpath("//label[contains(text(),'Qual linguagem de programação te interessa')]/following::input[1]"
				, "Java, C# and JS");
		dsl.escreverXpath("//label[contains(text(),'Escreva resumidamente um plano para sua carreira')]/following::textarea[1]"
				, "O plano de carreira é um instrumento de gestão que propicia aos colaboradores um horizonte no qual é possível evoluir, "
						+ "agraciando-os com gratulações e estabilidade, e motivando-os a crescer cada vez como profissional e como pessoa.");
		
		dsl.clicarBotaoXpath("//input[@value = 'Enviar']");
		
	}
	
	public void aguardarMensagemSucesso() {
		dsl.webDriverWaitXPath(4, "//p[contains(text(),'Pesquisa para o profissional da área de Qualidade:')]");
	}

}