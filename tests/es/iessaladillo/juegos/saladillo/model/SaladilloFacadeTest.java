package es.iessaladillo.juegos.saladillo.model;

import java.util.ArrayList;

import junit.framework.TestCase;
import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.util.CargadorNiveles;
import es.iessaladillo.juegos.saladillo.util.Direccion;
import es.iessaladillo.juegos.saladillo.util.Entidad;
import es.iessaladillo.juegos.saladillo.util.Posicion;

public class SaladilloFacadeTest extends TestCase {
	private static SaladilloFacade f = new SaladilloFacade();
	private static Mapa mapaPruebas;
	
	static {
		ArrayList<Entidad> list = CargadorNiveles.cargarNivel("src/1.lvl");
		
		mapaPruebas = (Mapa) f.mapaFromEntidades(list.toArray(new Entidad[list.size()]));
	}
	

	/*
	 *  Engloba los test de MapaFromEntidades, CargarMapa(Entidad[]), 
	 *  y CargarMapa(MapaInterface)
	 */
	public void testCargarMapa() {
		f.cargarMapa(mapaPruebas);
		
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
		f.cargarMapa(mapaPruebas);
		
		assertTrue(f.getMapaOriginal().equals(f.reiniciarNivel()));
	}
	
	public void testDiamantesEnMapa() {
		f.cargarMapa(mapaPruebas);
		
		assertTrue(f.diamantesEnMapa() == 4);
	}
	
	public void testPosicionHeroe() {
		f.cargarMapa(mapaPruebas);
		
		assertTrue(f.getPosicionHeroe().equals(new Posicion(1, 5)));
	}
	
	/*
	 * Engloba los casos de MapaToAscii y mover.
	 */
	public void testMapaToAscii() {
		f.cargarMapa(mapaPruebas);
		
		assertTrue(f.mapaToAscii(f.getMapa()).equals(
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
				"| $ | A | · | O | · | · | · | · | · | · | · | · | · | · |\n"));
		
		
		f.setMapa((Mapa) f.mover(Direccion.RIGHT));
		
		assertTrue(f.mapaToAscii(f.getMapa()).equals(
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | X | · | · | · | X | O | O | · | O | · | · | O | · |\n" +
				"| X | · | X | · | · | X | $ | · | A | O | · | O | $ | O |\n" +
				"| · | A | · | · | · | X | O | O | O | O | · | · | O | · |\n" +
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | · | @ | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| · | · | · | · | · | · | · | · | · | · | · | · | · | · |\n" +
				"| O | · | O | · | · | · | · | · | O | · | O | · | · | · |\n" +
				"| · | O | · | O | · | · | · | O | · | O | · | O | · | · |\n" +
				"| O | · | O | · | · | · | · | · | O | $ | O | · | O | · |\n" +
				"| · | O | · | O | · | · | · | O | O | O | O | O | · | · |\n" +
				"| O | O | O | O | · | · | · | · | · | · | · | · | · | · |\n" +
				"| $ | A | · | O | · | · | · | · | · | · | · | · | · | · |\n"));
	}
}
