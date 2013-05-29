package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Elemento implements Dibujable {

	protected Dibujable fondo;
	
	@Override
	public String getNombreImagen() {
		return null;
	}

	@Override
	public boolean contieneFondo() {
		return (fondo==null) ? false:true;
	}

	@Override
	public Dibujable getFondo() {
		return fondo;
	}

	@Override
	public void setFondo(Dibujable fondo) {
		this.fondo = fondo;
		
	}

	@Override
	public String getNombreClase() {
		return getClass().getSimpleName();
	}

	public Object clone() {
		return new Elemento((Dibujable) fondo.clone());
	}

	public Elemento(Dibujable fondo) {
		this.fondo = fondo;
	}
		

}
