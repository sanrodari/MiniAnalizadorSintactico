package co.edu.uniquindio.categoriassintacticas;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.AnalizadorSintactico;
import co.edu.uniquindio.Derivacion;
import co.edu.uniquindio.Nodo;
import co.edu.uniquindio.Token;
import co.edu.uniquindio.categoriaslexicas.Cadena;
import co.edu.uniquindio.categoriaslexicas.Identificador;

public class TerminoC implements CategoriaSintactica {

	/*
	 * <TerminoC>  ::= Identificador | Cadena
	 */
	@Override
	public Derivacion construir(AnalizadorSintactico contexto) {
		contexto.establecerRegresoBacktracking();
		List<Nodo> nodos = new ArrayList<Nodo>();

		// Se trata de aceptar la primera producción
		// Identificador
		Token candidatoIdentificador = contexto.getTokenActual();
		if(		candidatoIdentificador != null && 
				candidatoIdentificador.getTipoToken().equals(Identificador.class)) {
			contexto.irSiguienteToken();
			nodos.add(candidatoIdentificador);
		}
		
		// Si encontró que se puede derivar de la primera producción
		if(nodos.size() == 1) {
			Derivacion derivacion = new Derivacion(getClass());
			derivacion.setHijos(nodos);
			return derivacion;
		}
		
		// Sino se regresa al punto de backtracking y se mira la otra producción
		// Cadena
		nodos.clear();
		contexto.regresarBacktracking();
		
		Token candidatoCadena = contexto.getTokenActual();
		if(		candidatoCadena != null &&
				candidatoCadena.getTipoToken().equals(Cadena.class)) {
			contexto.irSiguienteToken();
			nodos.add(candidatoCadena);
		}
		
		// Si encontró que se puede derivar de la segunda producción
		if(nodos.size() == 1) {
			Derivacion derivacion = new Derivacion(getClass());
			derivacion.setHijos(nodos);
			return derivacion;
		}
		
		// TODO Auto-generated method stub
		return null;
	}


}
