package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeración que contiene todos los posibles tipos que adoptará un elemento del frente.
 *
 */
public enum TipoFijo {
	Arbol(false),
	Casa(false),
	Edificio(false),
	Edificio2(false),
	Matorral(false),
	RocaSuelo(false),
	BolaPiedra(false),
	Caja(true),
	PelotaAzul(true),
	PelotaNaranja(true),
	PelotaVerde(true),
	PelotaRoja(true);
	
	private boolean movible;

	private TipoFijo(boolean movible) {
		this.movible = movible;
	}

	public boolean isMovible() {
		return movible;
	}
	
	public static boolean isMovible(String tipo) {
		switch(tipo) {
		case "Caja":
		case "PelotaAzul":
		case "PelotaNaranja":
		case "PelotaVerde":
		case "PelotaRoja":
			return true;
			
		default:
			return false;
		}
	}
}
