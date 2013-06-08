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
		boolean movible;
		
		if(tipo.equals("Caja") || tipo.equals("PelotaAzul") || tipo.equals("PelotaNaranja") || tipo.equals("PelotaVerde") || tipo.equals("PelotaRoja"))
			movible = true;
		else
			movible = false;
		
		return movible;
	}
	
	/**
	 * 
	 * @param s <code>String</code> que refleja el tipo de Elemento a buscar
	 * @return Objeto enumerado o <code>null</code> en caso de que no sea Tipo Fijo.
	 */
	public static TipoFijo getTipo(String s) {
		TipoFijo t = null;
		
		if(s.equals("Caja")) t = Caja;
		else if(s.equals("PelotaAzul")) t = PelotaAzul;
		else if(s.equals("PelotaRoja")) t = PelotaRoja;
		else if(s.equals("PelotaVerde")) t = PelotaVerde;
		else if(s.equals("PelotaNaranja")) t = PelotaNaranja;
		else if(s.equals("BolaPiedra")) t = BolaPiedra;
		else if(s.equals("Arbol")) t = Arbol;
		else if(s.equals("Casa")) t = Casa;
		else if(s.equals("Edificio")) t = Edificio;
		else if(s.equals("Edificio2")) t = Edificio2;
		else if(s.equals("Matorral")) t = Matorral;
		else if(s.equals("RocaSuelo")) t = RocaSuelo;
		
		return t;
	}
}
