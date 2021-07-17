package core;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class Ambiente {

	public static List<String> dadosAmbiente() {
		
		List<String> result = new ArrayList<String>();

		switch (Propriedades.ambiente) {
		case DESENVOLVIMENTO:
			result = Utils.lerArquivoTxt("Desenvolvimento.txt", "files_ambiente");
			break;
		case HOMOLOGACAO:
			result = Utils.lerArquivoTxt("Homologacao.txt", "files_environment");
			break;
		}
		return result;
	}
	
}