package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fondo implements Dibujable {
	
	private ElemFondo tipo;

	private Frente frente;
	
	@Override
	public String getNombreImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contieneFondo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dibujable getFondo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFondo(Dibujable dibujable) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNombreClase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object clone() {
		// TODO
		return null;
	}

	public Frente getFrente() {
		return frente;
	}

	public void setFrente(Frente frente) {
		this.frente = frente;
	}

	public ElemFondo getTipo() {
		return tipo;
	}

	public void setTipo(ElemFondo tipo) {
		this.tipo = tipo;
	}

}
