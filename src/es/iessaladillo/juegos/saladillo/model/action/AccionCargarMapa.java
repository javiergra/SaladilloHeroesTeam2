package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;

public class AccionCargarMapa implements Accion {
	
	private MapaInterface mapa;
	
	public AccionCargarMapa(MapaInterface mapa) {
		this.mapa = mapa;
	}
	
	@Override
	public Object ejecutar() {
		return mapa;
	}

}
