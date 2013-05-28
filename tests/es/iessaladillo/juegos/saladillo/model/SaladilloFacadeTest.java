package es.iessaladillo.juegos.saladillo.model;

import java.util.ArrayList;

import junit.framework.TestCase;
import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.util.CargadorNiveles;
import es.iessaladillo.juegos.saladillo.util.Entidad;

public class SaladilloFacadeTest extends TestCase {
	private static SaladilloFacade f = new SaladilloFacade();
	private static Entidad[] entidades;
	
	static {
		ArrayList<Entidad> list = CargadorNiveles.cargarNivel("src/1.lvl");
		
		entidades = list.toArray(new Entidad[list.size()]);
	}
	

	/*
	 *  Engloba los test de MapaFromEntidades, CargarMapa(Entidad[]), 
	 *  y CargarMapa(MapaInterface)
	 */
	public void testCargarMapa() {
		f.cargarMapa(entidades);
		
		Mapa mapa = (Mapa) f.getMapa();
		
		assertTrue(mapa != null);
		
		for(Dibujable[] da : mapa.getDibujables()) {
			for(Dibujable d : da) {
				assertTrue(d != null);
			}
		}
	}
	/*
	 * No funcionará porque Mapa no tiene el método equals.
	 * He decidido no implementarlo porque depende de
	 * clases que escapan del paquete Model
	 */
	public void testReiniciarNivel() {
		f.cargarMapa(entidades);
		
		assertTrue(f.getMapaOriginal().equals(f.reiniciarNivel()));
	}
	
	public void testDiamantesEnMapa() {
		f.cargarMapa(entidades);
		
		assertTrue(f.diamantesEnMapa() == 4);
	}
	
	public void testMapaToAscii() {
		f.cargarMapa(entidades);
		
		String mapa = 
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | X | · | · | · | X | O | O | · | O | · | · | O | · |\n" +
				"| X | · | X | · | · | X | $ | · | A | O | · | O | $ | O |\n" +
				"| · | A | · | · | · | X | O | O | O | O | · | · | O | · |\n" +
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | @ | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| O | · | O | · | · | · | · | · | O | · | O | · | · | · |\n" +
				"| · | O | · | O | · | · | · | O | · | O | · | O | · | · |\n" +
				"| O | · | O | · | · | · | · | · | O | $ | O | · | O | · |\n" +
				"| · | O | · | O | · | · | · | O | O | O | O | O | · | · |\n" +
				"| O | O | O | O | · | · | · | · | · | · | · | · | · | · |\n" +
				"| $ | A | · | O | · | · | · | · | · | · | · | · | · | · |\n";
		
		assertTrue(f.mapaToAscii(f.getMapa()).equals(mapa));
	}
}
