package es.iessaladillo.juegos.saladillo.util;

import java.util.ArrayList;
import java.util.Iterator;

public class ConjuntoPosiciones {
	
	private ArrayList <Posicion> posiciones;

	public ConjuntoPosiciones() {
		posiciones = new ArrayList<Posicion>();
	}

	public	void anhadirPosicion(Posicion posicion){
		posiciones.add(posicion);
	}

	public Iterator <Posicion> obtenerPosiciones(){
		return posiciones.iterator();
	}

    public boolean estaVacio(){
    	return posiciones.isEmpty();
    }
    
    public Object clone() {
    	return new ConjuntoPosiciones() {{
    		for (Posicion p : posiciones) {
    			anhadirPosicion((Posicion) p.clone());
    		}
    	}};
    }

}
