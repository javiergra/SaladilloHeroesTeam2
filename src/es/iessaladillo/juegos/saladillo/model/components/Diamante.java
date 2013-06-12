package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Diamante extends Elemento {

	public Diamante() {
		super(null);
	}

	public Diamante(Dibujable fondo) {
		super(fondo);
	}

	@Override
	public Object clone() {
		return new Diamante((Dibujable) fondo.clone());
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + fondo;
	}
}
