package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.util.Direccion;
import es.iessaladillo.juegos.saladillo.util.Posicion;

public class AccionMover implements Accion{

	private MapaInterface mapa;
	private Direccion direccion;
	
	public AccionMover(Mapa mapa, Direccion direccion){
		this.mapa = mapa;
		this.direccion = direccion;
	}

	@Override
	public Object ejecutar() {
		int pX = mapa.getPosicionHeroe().getX() , pY = mapa.getPosicionHeroe().getY();
		if(direccion == Direccion.UP) pY = mapa.getPosicionHeroe().getY() - 1;
		else if(direccion == Direccion.DOWN) pY = mapa.getPosicionHeroe().getY() + 1;
		else if(direccion == Direccion.RIGHT) pX = mapa.getPosicionHeroe().getX() + 1;
		else pX =  mapa.getPosicionHeroe().getX() - 1;
		mapa.ponerElemento(new Posicion(pX, pY), mapa.obtenerPosicion(mapa.getPosicionHeroe()));
		return mapa;
	}

}
