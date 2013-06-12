package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fijo extends Elemento {

	private TipoFijo tipo;

	public Fijo(TipoFijo tipo) {
		this(tipo, null);
	}

	public Fijo(TipoFijo tipo, Dibujable fondo) {
		super(fondo);
		this.tipo = tipo;
	}

	@Override
	public Object clone() {
		Fijo f = new Fijo(null);
		if (this.contieneFondo()) {
			f.setFondo((Dibujable) fondo.clone());
			f.setTipo(tipo);
		} else
			f.setTipo(tipo);
		return f;
	}

	@Override
	public Dibujable getFondo() {
		return fondo;
	}

	@Override
	public String getNombreImagen() {
		return tipo.name();
	}

	public TipoFijo getTipo() {
		return tipo;
	}

	public boolean isMovible() {
		return tipo.isMovible();
	}

	@Override
	public void setFondo(Dibujable fondo) {
		this.fondo = fondo;
	}

	public void setTipo(TipoFijo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + tipo + ")" + "@" + fondo;
	}
}