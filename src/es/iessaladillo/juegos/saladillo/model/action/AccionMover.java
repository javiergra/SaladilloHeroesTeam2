package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;

public class AccionMover implements Accion{

	private MapaInterface mapa;
	
	public AccionMover(Mapa mapa){
		this.mapa = mapa;
	}

	@Override
	public Object ejecutar() {
		mapa.ponerElemento(mapa.getPosicionHeroe(), mapa.obtenerPosicion(mapa.getPosicionHeroe()));
		return mapa;
	}

}
