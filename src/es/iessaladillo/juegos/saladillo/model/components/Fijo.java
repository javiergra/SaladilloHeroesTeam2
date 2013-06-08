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

	public boolean isMovible() {
		return tipo.isMovible();
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
	
	public Fijo(Dibujable fondo) {
		super(fondo);
	}


	public Object clone() {
		Fijo f = new Fijo(null);
		if(this.contieneFondo()){
			f.setFondo((Dibujable) this.fondo.clone());
			f.setTipo(this.tipo);
		}
		else
			f.setTipo(this.tipo);
		return f;		
	}
}



