package co.edu.uniquindio;

import java.util.Arrays;
import java.util.List;

import co.edu.uniquindio.categoriaslexicas.Cadena;
import co.edu.uniquindio.categoriaslexicas.Identificador;
import co.edu.uniquindio.categoriaslexicas.OperadorConcatenacion;

/**
 * Analizador Léxico
 */
public class AnalizadorLexico {
	
	// Se dan los tokens para la siguiente cadena:
	// c @ " mas otra cosa" @ "dimelo" @ otro
	private List<Token> tokens = Arrays.asList(
		new Token(Identificador.class, 			"c"),
		new Token(OperadorConcatenacion.class, 	"@"),
		new Token(Cadena.class, 				" mas otra cosa"),
		new Token(OperadorConcatenacion.class, 	"@"),
		new Token(Cadena.class, 				"dimelo"),
		new Token(OperadorConcatenacion.class, 	"@"),
		new Token(Identificador.class, 			"otro")
	);
	
	public AnalizadorLexico(String[] codigoAnalizar) {
	}
	
	public List<Token> getTokens() {
		return tokens;
	}
	
	public List<Token> analizar() {
		return getTokens();
	}

}