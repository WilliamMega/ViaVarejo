package core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		CHROME,
		FIREFOX,
		IE, 
		EDGE
	}
	
	public static TipoExecucao tipoExecucao = TipoExecucao.LOCAL;
	
	public enum TipoExecucao {
		LOCAL,
		GRID,
		HEADLESS,
		NUVEM
	}
	
	public static Ambientes ambiente = Ambientes.HOMOLOGACAO;
	
	public enum Ambientes {
		HOMOLOGACAO,
		DESENVOLVIMENTO
	}

}