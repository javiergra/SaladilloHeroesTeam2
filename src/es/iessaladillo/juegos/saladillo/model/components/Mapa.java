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
		return dibujables[posicion.getY()][posicion.getX()];
	}
	
	@Override
	public Posicion getPosicionHeroe() {
		return new Posicion(posicionHeroe.getY(),posicionHeroe.getX());
	}

	@Override
	public void ponerElemento(Posicion posicion, Dibujable dibujable) {
		
		try{
		int movimiento;
		Posicion posicionDibujable = new Posicion(posicion.getY(), posicion.getX());
		Posicion posicionHeroeOriginal = (Posicion) posicionHeroe.clone();
		Dibujable elementoEnMapa = dibujables[posicion.getY()][posicion.getX()];
		
		if(dibujable instanceof Heroe){
			
			if(elementoEnMapa instanceof Diamante){
				eliminarElemento(posicion);
				eliminarElemento(posicionHeroe);
				setPosicionHeroe(new Posicion(posicion.getY(), posicion.getX()));
				colocarElemento(posicion, dibujable);
				numDiamantes--;
			}
			else if(elementoEnMapa instanceof Fondo){
				colocarElemento(posicion, dibujable);
				eliminarElemento(posicionHeroe);
				setPosicionHeroe(new Posicion(posicion.getY(), posicion.getX()));
			}
			else if(elementoEnMapa instanceof Teletransporte){
				colocarElemento(posicion, dibujable);
				eliminarElemento(posicionHeroe);
				setPosicionHeroe(new Posicion(posicion.getY(), posicion.getX()));
				teletransportar();
			}
			else if (elementoEnMapa instanceof Fijo){
				if(((Fijo) elementoEnMapa).getTipo().isMovible()){
					elementoEnMapa = (Fijo) dibujables[posicion.getY()][posicion.getX()];
					colocarElemento(posicion, dibujable);
					eliminarElemento(posicionHeroe);
					movimiento = posicion.getY() - getPosicionHeroe().getY();
					setPosicionHeroe(new Posicion(posicion.getY(), posicion.getX()));
					if(movimiento == 1){
						if(sePuedeMover(new Posicion(posicion.getY() + 1, posicion.getX()))){
							eliminarElemento(new Posicion(posicion.getY() + 1, posicion.getX()));
							posicion.setY(posicion.getY() + 2);
							ponerElemento(new Posicion(posicion.getY(), posicion.getX()), elementoEnMapa);
						}
					}
					else if(movimiento == -1){
						if(sePuedeMover(new Posicion(posicion.getY() - 1, posicion.getX()))){
							eliminarElemento(new Posicion(posicion.getY(), posicion.getX()));
							posicion.setY(posicion.getY() - 2);
							ponerElemento(new Posicion(posicion.getY(), posicion.getX()), elementoEnMapa);
						}
					}
					else{
						colocarElemento(posicion, dibujable);
						movimiento = posicion.getX() - getPosicionHeroe().getX();
						if(movimiento == 1){
							if(sePuedeMover(new Posicion(posicion.getY() , posicion.getX() + 1))){
								eliminarElemento(new Posicion(posicion.getY(), posicion.getX()));
								posicion.setX(posicion.getX() + 2);
								ponerElemento(new Posicion(posicion.getY() ,posicion.getX()), (Fijo) obtenerPosicion(posicion));
							}
						}
						else if(movimiento == -1){
							if(sePuedeMover(new Posicion(posicion.getY() , posicion.getX() - 1)))
								eliminarElemento(new Posicion(posicion.getY(), posicion.getX()));
								posicion.setX(posicion.getX() - 2);
								ponerElemento(new Posicion(posicion.getY() , posicion.getX()) , (Fijo) obtenerPosicion(posicion));
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
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		}
		
		
	
	private void teletransportar(){
		boolean actualizar = true; 
		Posicion posicionTeletransportado = null;
		Heroe heroe = (Heroe) obtenerPosicion(getPosicionHeroe());
		Teletransporte teletransporte = (Teletransporte)heroe.getFondo();
		Iterator<Posicion> iteradorRojo = getPosicionesTeletransporteRojo().obtenerPosiciones();
		Iterator<Posicion> iteradorAzul = getPosicionesTeletransporteAzul().obtenerPosiciones();
		ArrayList<Posicion> listaDePosicionesRojo = new ArrayList<Posicion>();
		ArrayList<Posicion> listaDePosicionesAzul = new ArrayList<Posicion>();
		ArrayList<Posicion> listaDePosicionesTotal = new ArrayList<Posicion>();
		while (iteradorRojo.hasNext())
			listaDePosicionesRojo.add((Posicion)iteradorRojo.next());
		while (iteradorAzul.hasNext())
			listaDePosicionesAzul.add((Posicion)iteradorAzul.next());
		if(TipoTeletransporte.isRojo(teletransporte.getTipo().name())){
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
		
		if(obtenerPosicion(p).contieneFondo()){
			d.setFondo(obtenerPosicion(p));
			dibujables[p.getY()][p.getX()] = d;
		}
		else
			dibujables[p.getY()][p.getX()] = d;
		
	}

	public void eliminarElemento(Posicion posicion){
		int x=posicion.getY();
		int y=posicion.getX();
		
		if(!dibujables[y][x].contieneFondo())
			dibujables[y][x]=null;
		else{
			dibujables[y][x]=dibujables[y][x].getFondo();
		}
			
	}
	
	public boolean sePuedeMover(Posicion p){
		boolean movible = false;
		if(obtenerPosicion(p) instanceof Fijo) {
			if( !TipoFijo.isMovible(obtenerPosicion(p).getNombreImagen()))
				movible = true;
		}
		return movible;
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
