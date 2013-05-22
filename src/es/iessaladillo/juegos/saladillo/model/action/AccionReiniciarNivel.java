package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;

public class AccionReiniciarNivel implements Accion {

	private MapaInterface mapa;
	
	public AccionReiniciarNivel(MapaInterface mapaOriginal) {
		this.mapa = mapaOriginal;
	}
	
	@Override
	public Object ejecutar() {
		return mapa;
	}

}
