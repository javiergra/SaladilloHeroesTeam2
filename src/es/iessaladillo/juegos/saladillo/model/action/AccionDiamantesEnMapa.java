package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.model.components.Mapa;

public class AccionDiamantesEnMapa implements Accion {

	private int numDiamantes;
	
	public AccionDiamantesEnMapa(Mapa mapa) {
		this.numDiamantes = mapa.getNumDiamantes();
	}

	@Override
	public Object ejecutar() {
		return numDiamantes;
	}

}
