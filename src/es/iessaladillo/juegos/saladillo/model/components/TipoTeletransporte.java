/**
 * 
 */
package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeración que contiene todos los posibles colores que tendrá un teletransporte.
 *
 */
public enum TipoTeletransporte {
	TELETRANSPORTEROJO, TELETRANSPORTEAZUL;
	
	/**
	 * 
	 * @return <code>true</code> si es rojo.
	 */
	public static boolean getTipo(String s) {
		return (s.toLowerCase().equals("rojo")) ? true : false;
	}
}
