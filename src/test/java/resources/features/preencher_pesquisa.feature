#https://cucumber.io/docs/gherkin/reference/
#language:pt
@Cadastro
Funcionalidade: Preencher pesquisa com dados obrigatorios validos
				Como um usuario
				Gostaria de realizar um novo cadastro
				Requisitos:
				[ .... ]
				 
Cenario: Preencher pesquisa com dados obrigatórios válidos
	Dado que eu acesse a pagina da VV Test
	E acesse o menu Pesquisa - QA
	Quando eu preencher todos os campos obrigatorios 
	Entao deve ser direcionado para uma página de sucesso