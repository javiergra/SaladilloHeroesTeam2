package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.util.Posicion;

public class AccionGetPosicionHeroe implements Accion {

	private Posicion posicion;
	
	public AccionGetPosicionHeroe(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public Object ejecutar() {
		return posicion;
	}

}
