package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Heroe extends Elemento {

	public Heroe(Dibujable fondo){
		super(fondo);
	}
	
	public Object clone() {
		return new Heroe(fondo);
	}
}
