/**
 * 
 */
package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeración que contiene todos los posibles colores que tendrá un teletransporte.
 *
 */
public enum TipoTeletransporte {
	TeletransporteRojo, TeletransporteAzul;
	
	/**
	 * 
	 * @return <code>true</code> si es rojo.
	 */
	public static boolean isRojo(String s) {
		return (s.toLowerCase().equals("teletransporterojo")) ? true : false;
	}
}
