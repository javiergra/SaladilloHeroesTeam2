package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.model.components.*;
import es.iessaladillo.juegos.saladillo.util.Entidad;
import static es.iessaladillo.juegos.saladillo.interfaz.util.GlobalValues.XMAX;
import static es.iessaladillo.juegos.saladillo.interfaz.util.GlobalValues.YMAX;

public class AccionMapaFromEntidades implements Accion {
	private Entidad[] entidades;

	public AccionMapaFromEntidades(Entidad[] entidades) {
		this.entidades = entidades;
	}

	@Override
	public Object ejecutar() {
		Dibujable[][] dibujables = new Dibujable[YMAX][XMAX];

		for (Entidad e : entidades) {
			String s = e.getTipo();
			Dibujable c, d = null;
			
			if(s.equals("Heroe")) {
				d = new Heroe(null);
				
			} else if (s.equals("Diamante")) {
				d = new Diamante(null);
				
			} else if (s.matches("Teletransporte.*")) {
				TipoTeletransporte tt = (TipoTeletransporte.getTipo(s) ?
					TipoTeletransporte.TeletransporteRojo :
					TipoTeletransporte.TeletransporteAzul);
				
				d = new Teletransporte(tt, null);
				
			} else {
				TipoFijo tfijo;
				TipoFondo tfondo;
				
				if ((tfijo = TipoFijo.getTipo(s)) != null) {
					d = new Fijo(tfijo, null);
					
				} else if ((tfondo = TipoFondo.getTipo(s)) != null) {
					d = new Fondo(tfondo, null);
					
				}
			}
			
			// De no haber dibujable en el array, pone el elemento directamente en el array.
			if((c = dibujables[e.getY()][e.getX()]) == null) {
				c = d;
				
			} else {
				d.setFondo(c);
				dibujables[e.getY()][e.getX()] = d;
			}
		}
		
		return new Mapa(dibujables);
	}
}
