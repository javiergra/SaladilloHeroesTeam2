package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;

public class AccionReiniciarNivel implements Accion {

	private MapaInterface mapa;
	
	public AccionReiniciarNivel(MapaInterface mapaOriginal) {
		this.mapa = (MapaInterface) ((Mapa) mapaOriginal).clone();
	}
	
	@Override
	public Object ejecutar() {
		return new AccionCargarMapa(mapa).ejecutar();
	}

}
