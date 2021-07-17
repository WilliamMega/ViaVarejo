# Framework automação utilizando Selenium Web Driver e Cucumber na linguagem Java com projeto Maven.

Este projeto é um exemplo de framework de automação funcional para interface gráfica (UI) nos browsers Chrome e Firefox (Versões atuais) usando a ferramenta Selenium Web Driver na linguagem Java com Cucumber.

## Ferramentas utilizadas

- Instalar JDK - jdk1.8.0_211;
- Instalar Jre - jre1.8.0_211;
- Eclipse IDE com Maven (Maven Project) - Intellij 2019-03.2 ou Eclipse Version: 2019-03 (4.11.0)
- Instalar Git;

### Também é necessário que você tenha:

- Java no classpath (JAVA_HOME e PATH apontando para a pasta bin do Java)
Obs.: Projeto desenvolvido no Windows 10 Professional (64 bits)

### Suite de Teste:

/src/main/java/suites/SuiteTest.xml - Script para rodar os testes contemplados pela suite de teste de forma padrão
/src/main/java/suites/SuiteTestHeadLess.xml - Script para rodar os testes contemplados pela suite de teste na forma HeadLess

### Linguagem de programação:

Escrito em Java 8

### Execução:

Verificar se o browser Google Chrome está na versão "Chrome Versão Versão 91.0.4472.124 (Versão oficial) 64 bits".
Botão direito no arquivo "/src/main/java/suites/SuiteTest.xml" -> Run As -> TestNG Suite.

Obs.: Pode ser necessário atualizar a JRE para 1.8.0 e/ou atualizar as dependências do Maven (Botão direito no projeto -> Maven -> Update Project). 

### Autoria:

#### William Gomes Soares

#### Estrutura do projeto de automação:

Package core:

- Classes basicas para o projeto, tais como:
- Drive factory: responsável por invocar os browsers/drivers conforme sisetma operacional Linux e Windows;
- BasePage: responsável por instancias os metodos da classe DSL.
- DSL: Reuso e biblioteca dos metodos basicos para acesso aos elementos;
- ExtentReport: Relatorio que é gerado ao fim dos testes - Somente gerado quando é executado via suíte de teste;
- Propriedades: Enum das principais propriedades da automação, tais como: nome dos browsers, tipo de execução e ambientes;

Package page:

- As pages referente as interfaces do sistema.

Package stepDefinitions:

- Pasta onde os passos dos testes que serão executados (BDD).

Package suítes:

- Classes responsáveis pelas suítes de testes, podemos ter uma ou mais suítes e também podemos ter suíte das suítes de teste.

Package resources.features:

- Features das User Story utilizadas no BDD/

Package runners:

- Classes responsaveis pela execução e configuração das features.

Package utils:

- Constantes do projeto e metodos utils.

Package files_environment:

- Pasta utilizada para armazenar arquivos a serem utilizados no projeto (Arquivos comuns, planilhas, arquivo para upload e etc).

Package drivers:

- Existem uma pasta: windows -> com seus respectivos drivers.
- Onde é armazenado os drivers do browser Chrome (Poderia configurar para demais browsers).

Package report:

- Pasta onde será gerado o relatório do Extent Report, relatorio por detalhar o resultado da suíte executada.

Arquivo pom.xml:

- Arquivo Maven, responsável por gerenciar as dependências do projeto.
