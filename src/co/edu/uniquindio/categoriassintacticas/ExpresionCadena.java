package co.edu.uniquindio.categoriassintacticas;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.AnalizadorSintactico;
import co.edu.uniquindio.Derivacion;
import co.edu.uniquindio.Nodo;
import co.edu.uniquindio.Token;
import co.edu.uniquindio.categoriaslexicas.OperadorConcatenacion;

public class ExpresionCadena implements CategoriaSintactica {

	/*
	 * <ExpresionCadena> ::= <TerminoC> OperadorConcatenacion <TerminoC> | <TerminoC>
	 */
	@Override
	public Derivacion construir(AnalizadorSintactico contexto) {
		
		// Antes de tratar analizar se establece el BT.
		contexto.establecerRegresoBacktracking();
		
		List<Nodo> nodos = new ArrayList<Nodo>();
		
		// Se trata de aceptar la primera producción
		// <TerminoC> OperadorConcatenacion <TerminoC>
		TerminoC terminoC1 = new TerminoC();
		Derivacion terminoC1Derivado = terminoC1.construir(contexto);
		if(terminoC1Derivado != null) {
			
			nodos.add(terminoC1Derivado);
			
			Token candidatoOperadorConcatenacion = contexto.getTokenActual();
			if(		candidatoOperadorConcatenacion != null &&
					candidatoOperadorConcatenacion.getTipoToken().equals(OperadorConcatenacion.class)) {
				
				nodos.add(candidatoOperadorConcatenacion);
				
				contexto.irSiguienteToken();
				
				TerminoC terminoC2 = new TerminoC();
				Derivacion terminoC2Derivado = terminoC2.construir(contexto);
				
				if(terminoC2Derivado != null) {
					nodos.add(terminoC2Derivado);
				}
			}
		}
		
		// Si encontró que se puede derivar de la primera producción
		if(nodos.size() == 3) {
			Derivacion derivacionResultante = new Derivacion(getClass());
			derivacionResultante.setHijos(nodos);
			return derivacionResultante;
		}
		
		// Sino se regresa al punto de backtracking y se mira la otra producción
		// <TerminoC>
		nodos.clear();
		contexto.regresarBacktracking();
		
		TerminoC terminoC3 = new TerminoC();
		Derivacion terminoC3Derivado = terminoC3.construir(contexto);
		if(terminoC3 != null) {
			nodos.add(terminoC3Derivado);
		}
		
		// Si encontró que se puede derivar de la primera producción
		if(nodos.size() == 1) {
			Derivacion derivacionResultante = new Derivacion(getClass());
			derivacionResultante.setHijos(nodos);
			return derivacionResultante;
		}
		
		return null;
	}

}
