package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fondo extends Elemento {
	
	private TipoFondo tipo;
	
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

	public TipoFondo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFondo tipo) {
		this.tipo = tipo;
	}

}
