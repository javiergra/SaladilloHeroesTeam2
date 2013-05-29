package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Diamante extends Elemento {

	public Diamante(Dibujable fondo){
		super(fondo);
	}
	
	public Object clone() {
		return new Diamante((Dibujable) fondo.clone());
	}
}
