/**
 * 
 */
package clases;

/**
 * @author Annais
 *
 */
public enum TipoFijo {
	ARBOL(false), CASA(false),EDIFICIO(false), EDIFICIO2(false), MATORRAL(false),ROCASUELO(false),
	CAJA(true), BOLAPIEDRA(true), PELOTAAZUL(true), PELOTANARANJA(true),
	PELOTAVERDE(true), PELOTAROJA(true);
	
	boolean movible;

	private TipoFijo(boolean movible) {
		this.movible = movible;
	}

}
