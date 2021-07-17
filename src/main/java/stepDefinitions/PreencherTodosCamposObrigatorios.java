package stepDefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pagePortalVVTest.TelaInicialPage;
import pagePortalVVTest.PreencherTodosCamposObrigatoriosPage;

public class PreencherTodosCamposObrigatorios {
	
	TelaInicialPage telaInicialPage = new TelaInicialPage();
	PreencherTodosCamposObrigatoriosPage preencherTodosCamposObrigatoriosPage = new PreencherTodosCamposObrigatoriosPage();
	
	@Dado("^que eu acesse a pagina da VV Test$")
	public void queEuAcesseAPaginaDaVVTest() {
		telaInicialPage.entrarPortalVVTest();
	}

	@E("^acesse o menu Pesquisa - QA$")
	public void acesseOMenuPesquisaQA() throws Throwable {
		telaInicialPage.clicarOpcaoPesquisaQA();
	}

	@Quando("^eu preencher todos os campos obrigatorios$")
	public void euPreencherTodosOsCamposObrigatorios() throws Throwable {
		preencherTodosCamposObrigatoriosPage.informarTodosCamposObrigatorios();
	}

	@Entao("^deve ser direcionado para uma página de sucesso$")
	public void deveSerDirecionadoParaUmaPáginaDeSucesso() throws Throwable {
		preencherTodosCamposObrigatoriosPage.aguardarMensagemSucesso();
	}
}