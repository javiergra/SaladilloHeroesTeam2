package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Teletransporte extends Elemento {

	private TipoTeletransporte tipo;

	public Teletransporte(TipoTeletransporte tipo) {
		this(tipo, null);
	}

	public Teletransporte(TipoTeletransporte tipo, Dibujable fondo) {
		super(fondo);
		this.tipo = tipo;
	}

	@Override
	public Object clone() {
		return new Teletransporte(tipo, (Dibujable) fondo.clone());
	}

	@Override
	public String getNombreImagen() {
		return tipo.name();
	}

	public TipoTeletransporte getTipo() {
		return tipo;
	}

	public void setTipo(TipoTeletransporte tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + tipo + ")" + "@" + fondo;
	}
}
