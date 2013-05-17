/**
 * 
 */
package es.iessaladillo.juegos.saladillo.util;

import es.iessaladillo.juegos.saladillo.controller.*;
import es.iessaladillo.juegos.saladillo.model.components.*;

/**
 * @author Patricia
 *
 */

public class Mapa implements MapaInterface {
	Dibujable[][] dibujables;
	int numDiamantes;
	Posicion posicionHeroe;
	ConjuntoPosiciones posicionesAActualizar, posicionesTeletransporteAzul, posicionesTeletransporteRojo;
	
	 
	
	public Mapa(Dibujable[][] dibujables){
		construirMapa(dibujables);
	}
	
	
	@Override
	public Dibujable obtenerPosicion(Posicion posicion) {
		int x=posicion.getX();
		int y=posicion.getY();
		
		return dibujables[x][y];
	}

	
	@Override
	public Posicion getPosicionHeroe() {
		int x=posicionHeroe.getX();
		int y=posicionHeroe.getY();
		
		return new Posicion(x,y);
	}

	@Override
	public void ponerElemento(Posicion posicion, Dibujable dibujable) {
		int x=posicion.getX();
		int y=posicion.getY();
		
		if(dibujables[x][y]==null)
			dibujables[x][y]=dibujable;
		else{
			if(dibujable instanceof Fondo && dibujables[x][y].contieneFondo()==false)
				dibujables[x][y]=dibujable;
			
			else if(dibujable instanceof Diamante){
				
			}
				
		}
		

	}
	
	public void eliminarElemento(Posicion posicion){
		int x=posicion.getX();
		int y=posicion.getY();
		
		dibujables[x][y]=null;
	}
	
	public String toString(){
		String mapa="";
		
		return mapa;
	}
	
	public void construirMapa(Dibujable[][] dibujables){
		int i, j;
		
		for(i=0;i<dibujables.length;i++){
			for(j=0;j<dibujables[i].length;j++){
				
				if(dibujables[i][j] instanceof Diamante)
					numDiamantes++;
				else if(dibujables[i][j] instanceof Heroe)
					posicionHeroe=new Posicion(i,j);
				/*else if(dibujables[i][j] instanceof Teletransporte){
					if(((Teletransporte) dibujables[i][j]).getTipo())
						posicionesTeletransporteRojo.anhadirPosicion(new Posicion(i,j));
					else
						posicionesTeletransporteAzul.anhadirPosicion(new Posicion(i,j));
				}	*/
			}
		}
	}
	
	public Object clone(){
		return dibujables;
		
	}
	
}
