package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Heroe extends Elemento {

	public Heroe() {
		super(null);
	}

	public Heroe(Dibujable fondo) {
		super(fondo);
	}

	@Override
	public Object clone() {
		return new Heroe((Dibujable) fondo.clone());
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + fondo;
	}
}
