package Mutacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LerCodigo {

	public static void main(String[] args) {
		// a classe não deve possuir comentários 
		String linha;
		int mutanteI = 1;
		
		try {
			while (mutanteI < 4) {
				File java = new File(System.getProperty("user.dir") + "/src/Classe/ClasseTeste.java");
				Scanner ler = new Scanner(java);
				PrintWriter txt = new PrintWriter("mutante_" + mutanteI + ".txt");
				while (ler.hasNextLine()) {
					linha = ler.nextLine();
					if (mutanteI == 1) {
						linha = operacao(linha);
					} else if (mutanteI == 2) {
						linha = condicao(linha);
					} else if (mutanteI == 3) {
						linha = operacao(linha);
						linha = condicao(linha);
					}

					txt.println(linha);
					System.out.println(linha);
				}
				mutanteI++;
				txt.close();
			}

		} catch (FileNotFoundException e) {
			System.err.println("falha");
		}
		System.out.println("Atualize o projetoS");
	}
	
	
	
	static String operacao(String linha){
		if (linha.contains("/")) {
			linha = linha.replace("/", "*");
		} else if (linha.contains("*")) {
			linha = linha.replace("*", "/");
		}if (linha.contains("+")) {
			linha = linha.replace("+", "-");
		} else if (linha.contains("-"))
			linha = linha.replace("-", "+");
		return linha;
	}
	
	static String condicao(String linha){
		if (linha.contains("==")) {
			linha = linha.replace("==", "!=");
		} else if (linha.contains("!=")) {
			linha = linha.replace("!=", "==");
		}if (linha.contains(">=")) {
			linha = linha.replace(">=", "<");
		} else if (linha.contains("<")) {
			linha = linha.replace("<", ">=");
		}if (linha.contains("<=")) {
			linha = linha.replace("<=", ">");
		} else if (linha.contains(">"))
			linha = linha.replace(">", "<=");
		return linha;
	}

}
