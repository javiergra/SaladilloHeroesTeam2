package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.model.components.Mapa;

public class AccionPosicionesAActualizar implements Accion {

	Mapa mapa;
	
	public AccionPosicionesAActualizar(Mapa mapa) {
		this.mapa = mapa;
	}

	@Override
	public Object ejecutar() {
		return mapa.getPosicionesAActualizar();
	}
	

}
