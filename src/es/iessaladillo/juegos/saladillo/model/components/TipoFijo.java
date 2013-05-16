package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeración que contiene todos los posibles tipos que adoptará un elemento del frente.
 *
 */
public enum TipoFijo {
	ARBOL(false),
	CASA(false),
	EDIFICIO(false),
	EDIFICIO2(false),
	MATORRAL(false),
	ROCASUELO(false),
	CAJA(true),
	BOLAPIEDRA(true),
	PELOTAAZUL(true),
	PELOTANARANJA(true),
	PELOTAVERDE(true),
	PELOTAROJA(true);
	
	private boolean movible;

	private TipoFijo(boolean movible) {
		this.movible = movible;
	}

	public boolean isMovible() {
		return movible;
	}
	
	public static boolean isMovible(String tipo) {
		switch(tipo) {
		case "CAJA":
		case "BOLAPIEDRA":
		case "PELOTAAZUL":
		case "PELOTANARANJA":
		case "PELOTAVERDE":
		case "PELOTAROJA":
			return true;
			
		/*
		 * Esto no sirve de nada, por el simple hecho del uso de "default";
		 * si no es ninguno anterior, será irremediablemente falso.
		
		case "CASA":
		case "EDIFICIO":
		case "EDIFICIO2":
		case "MATORRAL":
		case "ROCASUELO":
		
		 */

		default:
			return false;
		}
	}
}
