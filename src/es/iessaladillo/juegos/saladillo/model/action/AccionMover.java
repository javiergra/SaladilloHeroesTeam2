package es.iessaladillo.juegos.saladillo.model.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.model.components.Diamante;
import es.iessaladillo.juegos.saladillo.model.components.Fijo;
import es.iessaladillo.juegos.saladillo.model.components.Fondo;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.model.components.Teletransporte;
import es.iessaladillo.juegos.saladillo.util.ConjuntoPosiciones;
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

	private void mover() {

		ConjuntoPosiciones cPosiciones = new ConjuntoPosiciones();
		mapa.setPosicionesAActualizar(cPosiciones); // Cada vez que se mueve hay que borrar las posiciones actualizadas anteriormente.
		Dibujable heroe = mapa.obtenerPosicion(mapa.getPosicionHeroe());
		Posicion posicionMover, posicionPelota, posicionTeletransporte;
		Dibujable d;

		posicionMover = posicionAMoverse(mapa.getPosicionHeroe());

		if (posicionValida(posicionMover)) {

			d = mapa.obtenerPosicion(posicionMover);

			if (d instanceof Fondo) {
				
				mapa.ponerElemento(posicionMover, heroe);
				cPosiciones.anhadirPosicion(posicionMover);
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				cPosiciones.anhadirPosicion(mapa.getPosicionHeroe());
				mapa.setPosicionHeroe(posicionMover);
				
				if(heroe.getFondo() instanceof Teletransporte) heroe.setFondo(heroe.getFondo().getFondo());
				
			}

			else if (d instanceof Diamante) {
				mapa.eliminarElemento(posicionMover);
				mapa.setNumDiamantes(mapa.getNumDiamantes() - 1);
				mapa.ponerElemento(posicionMover, heroe);
				cPosiciones.anhadirPosicion(posicionMover);
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				cPosiciones.anhadirPosicion(mapa.getPosicionHeroe());
				mapa.setPosicionHeroe(posicionMover);
				
				if(heroe.getFondo() instanceof Teletransporte) heroe.setFondo(heroe.getFondo().getFondo());
			}

			else if (d instanceof Fijo) {
				if (((Fijo) d).isMovible()) {
					
					posicionPelota = posicionAMoverse(posicionMover);

					if(posicionValida(posicionPelota)
							&& mapa.obtenerPosicion(posicionPelota) instanceof Fondo){
						
						mapa.ponerElemento(posicionPelota, d);
						cPosiciones.anhadirPosicion(posicionPelota);
						mapa.eliminarElemento(posicionMover);
						cPosiciones.anhadirPosicion(posicionMover);
						mapa.ponerElemento(posicionMover, heroe);
						mapa.eliminarElemento(mapa.getPosicionHeroe());
						cPosiciones.anhadirPosicion(mapa.getPosicionHeroe());
						mapa.setPosicionHeroe(posicionMover);
						
						
						if(heroe.getFondo() instanceof Teletransporte) heroe.setFondo(heroe.getFondo().getFondo());
					}
		
				}
			}
			
			else{ // en caso de que sea un teletransporte.
				
				posicionTeletransporte = teletransportar(((Teletransporte) d).getTipo().name(), posicionMover);
				mapa.ponerElemento(posicionTeletransporte, heroe);
				cPosiciones.anhadirPosicion(posicionTeletransporte);
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				mapa.eliminarElemento(mapa.getPosicionHeroe());
				cPosiciones.anhadirPosicion(mapa.getPosicionHeroe());
				mapa.setPosicionHeroe(posicionTeletransporte);
				
				}
			
			mapa.setPosicionesAActualizar(cPosiciones);// al final del movimiento hay que guardar las posiciones que hay que actualizar.
				
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
		
		if(listaPosiciones.size() <= 1) {
			return posicionTeletransporte;
		} else {
			Random r = new Random();
			
			while(true) {
				pT = listaPosiciones.get(r.nextInt(listaPosiciones.size()));
				
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
	
	private boolean posicionValida(Posicion p) {
		return p.getX() >= 0
				&& p.getX() < mapa.getDibujables().length
				&& p.getY() >= 0
				&& p.getY() < mapa.getDibujables().length;
	}
}
