/**
 * 
 */
package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import static es.iessaladillo.juegos.saladillo.interfaz.util.GlobalValues.XMAX;
import static es.iessaladillo.juegos.saladillo.interfaz.util.GlobalValues.YMAX;
import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.util.ConjuntoPosiciones;
import es.iessaladillo.juegos.saladillo.util.Posicion;

public class Mapa implements MapaInterface, Cloneable {
	private Dibujable[][] dibujables;
	private int numDiamantes;
	private Posicion posicionHeroe;
	private ConjuntoPosiciones posicionesAActualizar, posicionesTeletransporteAzul, posicionesTeletransporteRojo;

	public Mapa(Dibujable[][] dibujables) {
		this.dibujables = dibujables;

		posicionesAActualizar = new ConjuntoPosiciones();
		posicionesTeletransporteAzul = new ConjuntoPosiciones();
		posicionesTeletransporteRojo = new ConjuntoPosiciones();

		construirMapa();
	}

	@Override
	public Dibujable obtenerPosicion(Posicion posicion) {
		return dibujables[posicion.getY()][posicion.getX()];
	}

	@Override
	public Posicion getPosicionHeroe() {
		return posicionHeroe;
	}

	@Override
	public void ponerElemento(Posicion posicion, Dibujable dibujable) {
		int x = posicion.getX(), y = posicion.getY();

		if (!dibujables[y][x].contieneFondo()) {
			dibujables[y][x] = dibujable;
			
		} else {
			dibujable.setFondo(dibujables[y][x]);
			dibujables[y][x] = dibujable;
			
		}
	}

	public void eliminarElemento(Posicion posicion) {
		int x = posicion.getX(), y = posicion.getY();

		if (!dibujables[y][x].contieneFondo()){
			dibujables[y][x] = null;
		} else {
			dibujables[y][x] = dibujables[y][x].getFondo();
		}
	}

	private void construirMapa() {
		for (int i, j = 0; j < dibujables.length; j++) {
			for (i = 0; i < dibujables[j].length; i++) {
				if (dibujables[j][i] instanceof Diamante) {
					numDiamantes++;
				
				} else if (dibujables[j][i] instanceof Heroe) {
					posicionHeroe = new Posicion(i, j);
				
				} else if (dibujables[j][i] instanceof Teletransporte) {
					Teletransporte t = (Teletransporte) dibujables[j][i];
					
					if (TipoTeletransporte.isRojo(t.getTipo().name())) {
						posicionesTeletransporteRojo.anhadirPosicion(new Posicion(i, j));
						
					} else {
						posicionesTeletransporteAzul.anhadirPosicion(new Posicion(i, j));
					
					}
				}
			}
		}
	}

	public Object clone() {
		Mapa mapa = new Mapa();
		
		Dibujable[][] dibujables = new Dibujable[YMAX][XMAX];
		
		for(int i, j = 0; j < this.dibujables.length; j++) {
			for (i = 0; i < this.dibujables[j].length; i++) {
				dibujables[j][i] = (Dibujable) this.dibujables[j][i].clone();
			}
		}
		
		mapa.setDibujables(dibujables);
		
		mapa.setNumDiamantes(numDiamantes);
		
		mapa.setPosicionesAActualizar(posicionesAActualizar);
		
		mapa.setPosicionesTeletransporteAzul(posicionesTeletransporteAzul);
		
		mapa.setPosicionesTeletransporteRojo(posicionesTeletransporteRojo);
		
		mapa.setPosicionHeroe(posicionHeroe);

		return mapa;

	}

	public Dibujable[][] getDibujables() {
		return dibujables;
	}

	public void setDibujables(Dibujable[][] dibujables) {
		this.dibujables = dibujables;
	}

	public int getNumDiamantes() {
		return numDiamantes;
	}

	public void setNumDiamantes(int numDiamantes) {
		this.numDiamantes = numDiamantes;
	}

	public ConjuntoPosiciones getPosicionesAActualizar() {
		return posicionesAActualizar;
	}

	public void setPosicionesAActualizar(
			ConjuntoPosiciones posicionesAActualizar) {
		this.posicionesAActualizar = posicionesAActualizar;
	}

	public ConjuntoPosiciones getPosicionesTeletransporteAzul() {
		return posicionesTeletransporteAzul;
	}

	public void setPosicionesTeletransporteAzul(
			ConjuntoPosiciones posicionesTeletransporteAzul) {
		this.posicionesTeletransporteAzul = posicionesTeletransporteAzul;
	}

	public ConjuntoPosiciones getPosicionesTeletransporteRojo() {
		return posicionesTeletransporteRojo;
	}

	public void setPosicionesTeletransporteRojo(
			ConjuntoPosiciones posicionesTeletransporteRojo) {
		this.posicionesTeletransporteRojo = posicionesTeletransporteRojo;
	}

	public void setPosicionHeroe(Posicion posicionHeroe) {
		this.posicionHeroe = posicionHeroe;
	}

	private Mapa() {
		super();
	}

}
