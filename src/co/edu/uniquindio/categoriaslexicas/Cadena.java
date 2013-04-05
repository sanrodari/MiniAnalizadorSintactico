package co.edu.uniquindio.categoriaslexicas;

import co.edu.uniquindio.AnalizadorLexico;
import co.edu.uniquindio.Token;

public class Cadena implements CategoriaLexica {

	@Override
	public Token aceptar() {
		return null;
	}

	@Override
	public void setAnalizador(AnalizadorLexico analizadorLexico) {
	}

}
