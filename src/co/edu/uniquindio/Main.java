package co.edu.uniquindio;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		AnalizadorLexico analizadorLexico = new AnalizadorLexico(null);
		List<Token> tokens = analizadorLexico.analizar();

		System.out.println("Tokens");
		for (Token token : tokens) {
			System.out.println(token);
		}
		
		System.out.println();
		AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(tokens);
		Nodo raiz = analizadorSintactico.analizar();
		
		System.out.println(raiz);
	}

}