package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fijo extends Elemento {

	private TipoFijo tipo;
	
	public String getNombreImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contieneFondo() {
		// TODO Auto-generated method stub
		return false;
	}

	public Dibujable getFondo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFondo(Dibujable dibujable) {
		// TODO Auto-generated method stub

	}

	public String getNombreClase() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object clone() {
		// TODO
		return null;
	}

	public TipoFijo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFijo tipo) {
		this.tipo = tipo;
	}
}
