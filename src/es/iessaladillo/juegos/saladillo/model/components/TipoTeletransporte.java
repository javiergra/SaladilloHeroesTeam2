/**
 * 
 */
package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeraci�n que contiene todos los posibles colores que tendr� un teletransporte.
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
