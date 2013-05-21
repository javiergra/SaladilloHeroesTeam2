package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;

public class Fijo extends Elemento {

	private TipoFijo tipo;
	
	public String getNombreImagen() {
		return tipo.name();
	}

	public Dibujable getFondo() {
		return fondo;
	}

	public void setFondo(Dibujable fondo) {
		this.fondo=fondo;
	}


	public TipoFijo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFijo tipo) {
		this.tipo = tipo;
	}

	public Fijo(TipoFijo tipo, Dibujable fondo) {
		super(fondo);
		this.tipo = tipo;
	}
	
	public Object clone() {
		return new Fijo(tipo, fondo);
		
	}
}
