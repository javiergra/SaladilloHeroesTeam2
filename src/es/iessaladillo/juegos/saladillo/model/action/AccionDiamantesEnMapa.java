package es.iessaladillo.juegos.saladillo.model.action;

public class AccionDiamantesEnMapa implements Accion {

	private int numDiamantes;
	
	public AccionDiamantesEnMapa(int numDiamantes) {
		this.numDiamantes = numDiamantes;
	}

	@Override
	public Object ejecutar() {
		return numDiamantes;
	}

}
