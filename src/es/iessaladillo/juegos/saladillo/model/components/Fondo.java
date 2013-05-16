package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fondo extends Elemento {
	
	private TipoFondo tipo;
	
	public String getNombreImagen() {
		return tipo.name();
	}

	public Dibujable getFondo() {
		return null;
	}

	public void setFondo(Dibujable fondo) {
		this.fondo=fondo;

	}
	
	public Object clone(){
		Fondo f=(Fondo) super.clone();
		return f;
	}

	public TipoFondo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFondo tipo) {
		this.tipo = tipo;
	}

	public Fondo(TipoFondo tipo, Dibujable fondo) {
		super(fondo);
		this.tipo = tipo;
	}

}
