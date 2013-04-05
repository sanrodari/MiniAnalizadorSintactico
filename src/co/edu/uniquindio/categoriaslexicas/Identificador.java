package co.edu.uniquindio.categoriaslexicas;

import co.edu.uniquindio.AnalizadorLexico;
import co.edu.uniquindio.Token;

public class Identificador implements CategoriaLexica {

	@Override
	public void setAnalizador(AnalizadorLexico analizadorLexico) {
	}

	@Override
	public Token aceptar() {
		return null;
	}

}
