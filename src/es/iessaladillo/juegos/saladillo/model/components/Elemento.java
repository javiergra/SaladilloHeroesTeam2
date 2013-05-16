package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Elemento implements Dibujable {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFondo(Dibujable dibujable) {
		// TODO Auto-generated method stub
		
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
