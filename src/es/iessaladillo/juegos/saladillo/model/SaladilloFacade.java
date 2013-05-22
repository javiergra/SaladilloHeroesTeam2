package es.iessaladillo.juegos.saladillo.model;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.action.AccionCargarMapa;
import es.iessaladillo.juegos.saladillo.model.action.AccionDiamantesEnMapa;
import es.iessaladillo.juegos.saladillo.model.action.AccionGetPosicionHeroe;
import es.iessaladillo.juegos.saladillo.model.action.AccionReiniciarNivel;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.model.delegate.SaladilloFacadeDelegate;
import es.iessaladillo.juegos.saladillo.util.ConjuntoPosiciones;
import es.iessaladillo.juegos.saladillo.util.Direccion;
import es.iessaladillo.juegos.saladillo.util.Entidad;
import es.iessaladillo.juegos.saladillo.util.Posicion;

public class SaladilloFacade implements SaladilloFacadeDelegate {
	
	private Mapa mapa;
	private Mapa mapaOriginal;
	
	@Override
	public MapaInterface mapaFromEntidades(Entidad[] entidades) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarMapa(Entidad[] entidades) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cargarMapa(MapaInterface mapa) {
		this.setMapa((Mapa) new AccionCargarMapa(mapa).ejecutar());
	}

	@Override
	public MapaInterface mover(Direccion direccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapaInterface reiniciarNivel() {
		return (Mapa) new AccionReiniciarNivel(mapaOriginal).ejecutar();
	}

	@Override
	public Posicion getPosicionHeroe() {
		return (Posicion) new AccionGetPosicionHeroe(mapa.getPosicionHeroe()).ejecutar();
	}

	@Override
	public int diamantesEnMapa() {
		return (int) new AccionDiamantesEnMapa(mapa).ejecutar();
	}

	@Override
	public ConjuntoPosiciones posicionesAActualizar() {
		// TODO Auto-generated method stub
		return null;
	}

	public MapaInterface getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

}
