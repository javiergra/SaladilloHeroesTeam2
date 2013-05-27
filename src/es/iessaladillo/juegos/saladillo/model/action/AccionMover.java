package es.iessaladillo.juegos.saladillo.model.action;

import java.util.ArrayList;
import java.util.Iterator;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.model.components.Diamante;
import es.iessaladillo.juegos.saladillo.model.components.Fijo;
import es.iessaladillo.juegos.saladillo.model.components.Fondo;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.model.components.Teletransporte;
import es.iessaladillo.juegos.saladillo.util.Direccion;
import es.iessaladillo.juegos.saladillo.util.Posicion;

public class AccionMover implements Accion {

	private Mapa mapa;
	private Direccion direccion;

	public AccionMover(Mapa mapa, Direccion direccion) {
		this.mapa = mapa;
		this.direccion = direccion;
	}

	@Override
	public Object ejecutar() {
		mover();
		return mapa;
	}

	public void mover() {

		Dibujable heroe = mapa.obtenerPosicion(mapa.getPosicionHeroe());
		Posicion posicionMover, posicionPelota, posicionTeletransporte;
		Dibujable d;

		posicionMover = posicionAMoverse(mapa.getPosicionHeroe());

		if (posicionMover.getX() >= 0
				&& posicionMover.getX() < mapa.getDibujables().length
				&& posicionMover.getY() >= 0
				&& posicionMover.getY() < mapa.getDibujables().length) {

			d = mapa.obtenerPosicion(posicionMover);

			if (d instanceof Fondo) {
				
				//if(heroe.getFondo() instanceof Teletransporte){
					//heroe.setFondo(heroe.getFondo().getFondo());
				//}
				
				mapa.ponerElemento(posicionMover, heroe);
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				mapa.setPosicionHeroe(posicionMover);
				
			}

			else if (d instanceof Diamante) {
				mapa.eliminarElemento(posicionMover);
				mapa.setNumDiamantes(mapa.getNumDiamantes() - 1);
				mapa.ponerElemento(posicionMover, heroe);
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				mapa.setPosicionHeroe(posicionMover);
			}

			else if (d instanceof Fijo) {
				if (((Fijo) d).isMovible()) {
					
					posicionPelota = posicionAMoverse(posicionMover);

					if(posicionPelota.getX() >= 0
							&& posicionPelota.getX() < mapa.getDibujables().length
							&& posicionPelota.getY() >= 0
							&& posicionPelota.getY() < mapa.getDibujables().length
							&& mapa.obtenerPosicion(posicionPelota) instanceof Fondo){
						
						mapa.ponerElemento(posicionPelota, d);
						mapa.eliminarElemento(posicionMover);
						mapa.ponerElemento(posicionMover, heroe);
						mapa.eliminarElemento(mapa.getPosicionHeroe());
						mapa.setPosicionHeroe(posicionMover);
						
					}
		
				}
			}
			
			else{ // en caso de que sea un teletransporte.
				
				posicionTeletransporte = teletransportar(((Teletransporte) d).getTipo().name(), posicionMover);
				mapa.ponerElemento(posicionTeletransporte, heroe);
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				mapa.setPosicionHeroe(posicionTeletransporte);
				
				}
				
			}
				
			
				

		}
	
	private Posicion teletransportar(String tipo, Posicion posicionTeletransporte){
		
		Iterator<Posicion> it;
		ArrayList <Posicion> listaPosiciones = new ArrayList<Posicion>();
		Posicion pT;
		
		if(tipo.equals("Rojo")){
			it = mapa.getPosicionesTeletransporteRojo().obtenerPosiciones();
			
		} else {
			it = mapa.getPosicionesTeletransporteAzul().obtenerPosiciones();
			
		}
		
		while(it.hasNext()){
			listaPosiciones.add(it.next());
		}
		
		if(listaPosiciones.size() <= 1)
			return posicionTeletransporte;
		else{
			
			while(true) {
				pT = listaPosiciones.get((int)Math.random() * listaPosiciones.size());
				
				if(!posicionTeletransporte.equals(pT)) return pT;
			}
		
		}
	}
	
	private Posicion posicionAMoverse(Posicion p){
		
		Posicion posicionAMoverse;
		
		if (direccion == Direccion.UP)
			posicionAMoverse = new Posicion(p.getX(),
					p.getY() - 1);
		else if (direccion == Direccion.DOWN)
			posicionAMoverse = new Posicion(p.getX(),
					p.getY() + 1);
		else if (direccion == Direccion.RIGHT)
			posicionAMoverse = new Posicion(p.getX() + 1,
					p.getY());
		else
			// se considera la dirección hacia la izquierda.
			posicionAMoverse = new Posicion(p.getX() - 1,
					p.getY());
		
		return posicionAMoverse;
		
	}
}
