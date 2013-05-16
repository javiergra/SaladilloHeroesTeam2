package es.iessaladillo.juegos.saladillo.model.components;

public class Teletransporte extends Elemento {

	private TipoTeletransporte tipo;

	
	public Teletransporte(TipoTeletransporte tipo) {
		this.tipo = tipo;
	}


	public TipoTeletransporte getTipo() {
		return tipo;
	}

	
}
