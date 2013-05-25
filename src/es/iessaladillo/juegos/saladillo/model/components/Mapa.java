/**
 * 
 */
package es.iessaladillo.juegos.saladillo.model.components;

import java.util.ArrayList;
import java.util.Iterator;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.util.ConjuntoPosiciones;
import es.iessaladillo.juegos.saladillo.util.Posicion;

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
		
		int movimiento;
		Fijo elementoMovible;
		Posicion posicionDibujable = new Posicion(posicion.getX(), posicion.getY());
		Posicion posicionHeroeOriginal = (Posicion) posicionHeroe.clone();
		Dibujable elementoEnMapa = dibujables[posicion.getX()][posicion.getY()];
		
		if(dibujable instanceof Heroe){
			
			if(elementoEnMapa instanceof Diamante){
				eliminarElemento(posicion);
				eliminarElemento(posicionHeroe);
				setPosicionHeroe(new Posicion(posicion.getX(), posicion.getY()));
				colocarElemento(posicion, dibujable);
				numDiamantes--;
			}
			else if(elementoEnMapa instanceof Fondo){
				colocarElemento(posicion, dibujable);
				eliminarElemento(posicionHeroe);
				setPosicionHeroe(new Posicion(posicion.getX(), posicion.getY()));
			}
			else if(elementoEnMapa instanceof Teletransporte){
				colocarElemento(posicion, dibujable);
				eliminarElemento(posicionHeroe);
				setPosicionHeroe(new Posicion(posicion.getX(), posicion.getY()));
				teletransportar();
			}
			else{
				if(((Fijo) elementoEnMapa).getTipo().isMovible()){
					elementoMovible = (Fijo) dibujables[posicion.getX()][posicion.getY()];
					colocarElemento(posicion, dibujable);
					eliminarElemento(posicionHeroe);
					movimiento = posicion.getX() - getPosicionHeroe().getX();
					setPosicionHeroe(new Posicion(posicion.getX(), posicion.getY()));
					if(movimiento == 1){
						if(sePuedeMover(new Posicion(posicion.getX() + 1, posicion.getY()))){
							eliminarElemento(new Posicion(posicion.getX() + 1, posicion.getY()));
							ponerElemento(new Posicion(posicion.getX() + 1, posicion.getY()), elementoMovible);
						}
					}
					else if(movimiento == -1){
						if(sePuedeMover(new Posicion(posicion.getX() - 1, posicion.getY()))){
							eliminarElemento(new Posicion(posicion.getX(), posicion.getY()));
							ponerElemento(new Posicion(posicion.getX() - 1, posicion.getY()), elementoMovible);
						}
					}
					else{
						elementoMovible = (Fijo) dibujables[posicion.getX()][posicion.getY()];
						colocarElemento(posicion, dibujable);
						movimiento = posicion.getY() - getPosicionHeroe().getY();
						if(movimiento == 1){
							if(sePuedeMover(new Posicion(posicion.getX(), posicion.getY() + 1))){
								eliminarElemento(new Posicion(posicion.getX(), posicion.getY()));
								ponerElemento(new Posicion(posicion.getX(), posicion.getY() + 1), elementoMovible);
							}
						}
						else if(movimiento == -1){
							if(sePuedeMover(new Posicion(posicion.getX(), posicion.getY() - 1)))
								eliminarElemento(new Posicion(posicion.getX(), posicion.getY()));
								ponerElemento(new Posicion(posicion.getX(), posicion.getY() - 1), elementoMovible);
							}
						}
					}
				}
				
			}
		else
			colocarElemento(posicion, dibujable);
			posicionesAActualizar.anhadirPosicion(posicionHeroeOriginal);
			posicionesAActualizar.anhadirPosicion(posicionHeroe);
			posicionesAActualizar.anhadirPosicion(posicionDibujable);
		
		}
		
	
	private void teletransportar(){
		boolean actualizar = true; 
		Posicion posicionTeletransportado = null;
		Heroe heroe = (Heroe) dibujables[posicionHeroe.getX()][posicionHeroe.getY()];
		Teletransporte teletransporte = (Teletransporte)dibujables[posicionHeroe.getX()][posicionHeroe.getY()].getFondo();
		TipoTeletransporte tipo = teletransporte.getTipo();
		Iterator<Posicion> iteradorRojo = getPosicionesTeletransporteRojo().obtenerPosiciones();
		Iterator<Posicion> iteradorAzul = getPosicionesTeletransporteAzul().obtenerPosiciones();
		ArrayList<Posicion> listaDePosicionesRojo = new ArrayList<Posicion>();
		ArrayList<Posicion> listaDePosicionesAzul = new ArrayList<Posicion>();
		ArrayList<Posicion> listaDePosicionesTotal = new ArrayList<Posicion>();
		while (iteradorRojo.hasNext())
			listaDePosicionesRojo.add((Posicion)iteradorRojo.next());
		while (iteradorAzul.hasNext())
			listaDePosicionesAzul.add((Posicion)iteradorAzul.next());
		if(TipoTeletransporte.isRojo(tipo.name())){
			if(listaDePosicionesRojo.size()>1){
				do{
					posicionTeletransportado = listaDePosicionesRojo.get((int) Math.random()*listaDePosicionesRojo.size());
				}while(posicionTeletransportado == getPosicionHeroe());
			}
			else if(!listaDePosicionesAzul.isEmpty()) {
				do{
					posicionTeletransportado = listaDePosicionesTotal.get((int) Math.random()*listaDePosicionesTotal.size());
				}while(posicionTeletransportado == getPosicionHeroe());
			}
			else{
				actualizar = false;
			}
		}
		else{
			if(listaDePosicionesAzul.size()>1){
				do{
					posicionTeletransportado = listaDePosicionesAzul.get((int) Math.random()*listaDePosicionesRojo.size());
				}while(posicionTeletransportado == getPosicionHeroe());
			}
			else if(!listaDePosicionesAzul.isEmpty()){
				do{
					posicionTeletransportado = listaDePosicionesTotal.get((int) Math.random()*listaDePosicionesTotal.size());
				}while(posicionTeletransportado == getPosicionHeroe());
			}
			else{
				actualizar = false;
			}
		}
		if(actualizar){
			eliminarElemento(posicionHeroe);
			colocarElemento(posicionTeletransportado, heroe);
			posicionesAActualizar.anhadirPosicion(posicionHeroe);
			posicionesAActualizar.anhadirPosicion(posicionTeletransportado);
		}
	}
	
	private void colocarElemento(Posicion p, Dibujable d) {
		
		if(d.contieneFondo()){
			d.setFondo(dibujables[p.getX()][p.getY()]);
			dibujables[p.getX()][p.getY()] = d;
		}
		else
			dibujables[p.getX()][p.getY()] = d;
		
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
	
	public boolean sePuedeMover(Posicion p){
		if(dibujables[p.getX()][p.getY()] instanceof Fijo)
			return false;
		else
			return true;
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
