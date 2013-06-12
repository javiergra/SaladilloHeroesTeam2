package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fondo extends Elemento {

	private TipoFondo tipo;

	public Fondo(TipoFondo tipo) {
		this(tipo, null);
	}

	public Fondo(TipoFondo tipo, Dibujable fondo) {
		super(fondo);
		this.tipo = tipo;
	}

	@Override
	public Object clone() {
		return new Fondo(tipo, null);
	}

	@Override
	public boolean contieneFondo() {
		return false;
	}

	@Override
	public Dibujable getFondo() {
		return null;
	}

	@Override
	public String getNombreImagen() {
		return tipo.name();
	}

	public TipoFondo getTipo() {
		return tipo;
	}

	@Override
	public void setFondo(Dibujable fondo) {
		this.fondo = fondo;

	}

	public void setTipo(TipoFondo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + tipo + ")" + "@" + fondo;
	}

}
