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
	
	/**
	 * 
	 * @param s <code>String</code> que refleja el tipo de Elemento a buscar
	 * @return Objeto enumerado o <code>null</code> en caso de que no sea Tipo Fijo.
	 */
	public static TipoFijo getTipo(String s) {
		switch(s) {
		case "Caja": return Caja;
		case "PelotaAzul": return PelotaAzul;
		case "PelotaRoja": return PelotaRoja;
		case "PelotaVerde": return PelotaVerde;
		case "PelotaNaranja": return PelotaNaranja;
		case "BolaPiedra": return BolaPiedra;
		case "Arbol": return Arbol;
		case "Casa": return Casa;
		case "Edificio": return Edificio;
		case "Edificio2": return Edificio2;
		case "Matorral": return Matorral;
		case "RocaSuelo": return RocaSuelo;
		}
		
		return null;
	}
}
