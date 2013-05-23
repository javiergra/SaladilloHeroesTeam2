/**
 * 
 */
package es.iessaladillo.juegos.saladillo.model.components;

import es.iessaladillo.juegos.saladillo.controller.*;
import es.iessaladillo.juegos.saladillo.util.*;

public class Mapa implements MapaInterface, Cloneable {
	private Dibujable[][] dibujables;
	private int numDiamantes;
	private Posicion posicionHeroe;
	private ConjuntoPosiciones posicionesAActualizar, posicionesTeletransporteAzul, posicionesTeletransporteRojo;
		
	public Mapa(Dibujable[][] dibujables){
		this.dibujables = dibujables;
		
		posicionesAActualizar = new ConjuntoPosiciones();
		posicionesTeletransporteAzul = new ConjuntoPosiciones();
		posicionesTeletransporteRojo = new ConjuntoPosiciones();
		
		construirMapa();
	}
	
	@Override
	public Dibujable obtenerPosicion(Posicion posicion) {
		return dibujables[posicion.getX()][posicion.getY()];
	}
	
	@Override
	public Posicion getPosicionHeroe() {
		return new Posicion(posicionHeroe.getX(),posicionHeroe.getY());
	}

	@Override
	public void ponerElemento(Posicion posicion, Dibujable dibujable) {
		int x=posicion.getX();
		int y=posicion.getY();
		
		if(dibujables[x][y]==null)
			dibujables[x][y]=dibujable;
		else{
			if(dibujable instanceof Heroe){
				if(dibujables[x][y].contieneFondo() && dibujables[x][y] instanceof Teletransporte){
					dibujable.setFondo(dibujables[x][y]);
					dibujables[x][y]=dibujable;
					posicionHeroe=new Posicion(x,y);
				}
				
				else{
					if(!dibujables[x][y].contieneFondo()){
						dibujable.setFondo(dibujables[x][y]);
						dibujables[x][y]=dibujable;
						posicionHeroe=new Posicion(x,y);
					}
				}
					
			}
			
			else if(dibujable instanceof Diamante){
				if(!dibujables[x][y].contieneFondo()){
					dibujable.setFondo(dibujables[x][y]);
					dibujables[x][y]=dibujable;
					numDiamantes++;
				}
			}
			
			else if(dibujable instanceof Teletransporte){
				
				switch(((Teletransporte) dibujable).getTipo().toString().toLowerCase()){
				case "teletransporterojo":
					if(!dibujables[x][y].contieneFondo()){
						dibujable.setFondo(dibujables[x][y]);
						dibujables[x][y]=dibujable;
						posicionesTeletransporteRojo.anhadirPosicion(new Posicion(x,y));
					}
					break;
				case "teletransporteazul":
					if(!dibujables[x][y].contieneFondo()){
						dibujable.setFondo(dibujables[x][y]);
						dibujables[x][y]=dibujable;
						posicionesTeletransporteAzul.anhadirPosicion(new Posicion(x,y));
					}
					break;
				}
			}
			
			else if (dibujable instanceof Fijo){
				if(!dibujables[x][y].contieneFondo()){
					dibujable.setFondo(dibujables[x][y]);
					dibujables[x][y]=dibujable;
				}
			}
			
			else if (dibujable instanceof Fondo){
				dibujables[x][y].setFondo(dibujable);
			}
				
		}
		

	}
	
	public void eliminarElemento(Posicion posicion){
		int x=posicion.getX();
		int y=posicion.getY();
		
		if(!dibujables[x][y].contieneFondo())
			dibujables[x][y]=null;
		else{
			dibujables[x][y]=dibujables[x][y].getFondo();
		}
			
	}
	
	public void construirMapa(){
		int i, j;
		
		for(i=0;i<dibujables.length;i++){
			for(j=0;j<dibujables[i].length;j++){
				
				if(dibujables[i][j] instanceof Diamante)
					numDiamantes++;
				else if(dibujables[i][j] instanceof Heroe)
					posicionHeroe=new Posicion(i,j);
				else if(dibujables[i][j] instanceof Teletransporte){
					Teletransporte t = (Teletransporte) dibujables[i][j];
					if(TipoTeletransporte.isRojo(t.getTipo().name())){
						posicionesTeletransporteRojo.anhadirPosicion(new Posicion(i, j));
					}
					else posicionesTeletransporteAzul.anhadirPosicion(new Posicion(i, j));
				}
			}
		}
	}
	
	public Object clone(){
		Mapa mapa = new Mapa();
		mapa.setDibujables(dibujables.clone());
		mapa.setNumDiamantes(numDiamantes);
		mapa.setPosicionesAActualizar((ConjuntoPosiciones) posicionesAActualizar.clone());
		mapa.setPosicionesTeletransporteAzul((ConjuntoPosiciones)posicionesTeletransporteAzul.clone());
		mapa.setPosicionesTeletransporteRojo((ConjuntoPosiciones)posicionesTeletransporteRojo.clone());
		mapa.setPosicionHeroe((Posicion)posicionHeroe.clone());
		
		return mapa;
		
	}


	public Dibujable[][] getDibujables() {
		return dibujables;
	}


	public void setDibujables(Dibujable[][] dibujables) {
		this.dibujables = dibujables;
	}


	public int getNumDiamantes() {
		return numDiamantes;
	}


	public void setNumDiamantes(int numDiamantes) {
		this.numDiamantes = numDiamantes;
	}


	public ConjuntoPosiciones getPosicionesAActualizar() {
		return posicionesAActualizar;
	}


	public void setPosicionesAActualizar(ConjuntoPosiciones posicionesAActualizar) {
		this.posicionesAActualizar = posicionesAActualizar;
	}


	public ConjuntoPosiciones getPosicionesTeletransporteAzul() {
		return posicionesTeletransporteAzul;
	}


	public void setPosicionesTeletransporteAzul(
			ConjuntoPosiciones posicionesTeletransporteAzul) {
		this.posicionesTeletransporteAzul = posicionesTeletransporteAzul;
	}


	public ConjuntoPosiciones getPosicionesTeletransporteRojo() {
		return posicionesTeletransporteRojo;
	}


	public void setPosicionesTeletransporteRojo(
			ConjuntoPosiciones posicionesTeletransporteRojo) {
		this.posicionesTeletransporteRojo = posicionesTeletransporteRojo;
	}


	public void setPosicionHeroe(Posicion posicionHeroe) {
		this.posicionHeroe = posicionHeroe;
	}


	private Mapa() {
		super();
	}
	
}
