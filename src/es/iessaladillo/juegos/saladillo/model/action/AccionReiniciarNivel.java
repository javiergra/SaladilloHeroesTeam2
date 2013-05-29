package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;

public class AccionReiniciarNivel implements Accion {

	private Mapa mapa;
	
	public AccionReiniciarNivel(MapaInterface mapaNuevo) {
		this.mapa = (Mapa) ((Mapa)mapaNuevo).clone();
	}
	
	@Override
	public Object ejecutar() {
		return mapa;
	}

}
