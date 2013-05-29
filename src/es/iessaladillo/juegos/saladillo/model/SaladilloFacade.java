package es.iessaladillo.juegos.saladillo.model;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.action.*;
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
		return (MapaInterface) new AccionMapaFromEntidades(entidades)
			.ejecutar();
	}

	@Override
	public void cargarMapa(Entidad[] entidades) {
		cargarMapa((MapaInterface) new AccionMapaFromEntidades(entidades)
		.ejecutar());
	}

	@Override
	public void cargarMapa(MapaInterface mapa) {
		this.mapa = ((Mapa) new AccionCargarMapa(mapa)
		.ejecutar());
		
		this.mapaOriginal = (Mapa) ((Mapa)mapa).clone();
	}

	@Override
	public MapaInterface mover(Direccion direccion) {
		return (MapaInterface) new AccionMover(mapa, direccion)
			.ejecutar();
	}

	@Override
	public MapaInterface reiniciarNivel() {	
		return (Mapa) new AccionReiniciarNivel(mapaOriginal)
			.ejecutar();
	}

	public Mapa getMapaOriginal() {
		return mapaOriginal;
	}

	@Override
	public Posicion getPosicionHeroe() {
		return (Posicion) new AccionGetPosicionHeroe(
				mapa.getPosicionHeroe())
			.ejecutar();
	}

	@Override
	public int diamantesEnMapa() {
		return (int) new AccionDiamantesEnMapa(mapa)
			.ejecutar();
	}

	@Override
	public ConjuntoPosiciones posicionesAActualizar() {
		return (ConjuntoPosiciones) new AccionPosicionesAActualizar(mapa)
			.ejecutar();
	}

	public MapaInterface getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	@Override
	public String mapaToAscii(MapaInterface mapa) {
		return (String) new AccionMapaToAscii(mapa)
			.ejecutar();
	}

}
