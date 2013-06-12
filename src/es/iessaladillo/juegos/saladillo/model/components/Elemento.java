package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Elemento implements Dibujable {

	protected Dibujable fondo;

	public Elemento() {
		this.fondo = null;
	}

	public Elemento(Dibujable fondo) {
		this.fondo = fondo;
	}

	@Override
	public Object clone() {
		return new Elemento((Dibujable) fondo.clone());
	}

	@Override
	public boolean contieneFondo() {
		return (fondo != null) ? true : false;
	}

	@Override
	public Dibujable getFondo() {
		return fondo;
	}

	@Override
	public String getNombreClase() {
		return getClass().getSimpleName();
	}

	@Override
	public String getNombreImagen() {
		return getClass().getSimpleName();
	}

	@Override
	public void setFondo(Dibujable fondo) {
		this.fondo = fondo;

	}
}
