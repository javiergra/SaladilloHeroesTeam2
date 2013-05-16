package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Elemento implements Dibujable {

	private Dibujable fondo;
		
	@Override
	public String getNombreImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contieneFondo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dibujable getFondo() {
		return fondo;
	}

	@Override
	public void setFondo(Dibujable dibujable) {
		this.fondo = fondo;
		
	}

	@Override
	public String getNombreClase() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object clone() {
		// TODO
		return null;
	}

}
