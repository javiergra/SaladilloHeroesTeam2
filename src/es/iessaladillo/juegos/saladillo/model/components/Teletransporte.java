package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Teletransporte extends Elemento {

	private TipoTeletransporte tipo;

	
	public Teletransporte(TipoTeletransporte tipo,Dibujable fondo) {
		super(fondo);
		this.tipo = tipo;
	}


	public TipoTeletransporte getTipo() {
		return tipo;
	}


	public void setTipo(TipoTeletransporte tipo) {
		this.tipo = tipo;
	}

	public Object clone() {
		return new Teletransporte(tipo, (Dibujable) fondo.clone());
	}
}
