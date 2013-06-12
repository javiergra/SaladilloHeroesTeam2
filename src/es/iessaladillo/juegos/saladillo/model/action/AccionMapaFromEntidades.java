package es.iessaladillo.juegos.saladillo.model.action;

import static es.iessaladillo.juegos.saladillo.interfaz.util.GlobalValues.XMAX;
import static es.iessaladillo.juegos.saladillo.interfaz.util.GlobalValues.YMAX;
import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.model.components.Diamante;
import es.iessaladillo.juegos.saladillo.model.components.Fijo;
import es.iessaladillo.juegos.saladillo.model.components.Fondo;
import es.iessaladillo.juegos.saladillo.model.components.Heroe;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.model.components.Teletransporte;
import es.iessaladillo.juegos.saladillo.model.components.TipoFijo;
import es.iessaladillo.juegos.saladillo.model.components.TipoFondo;
import es.iessaladillo.juegos.saladillo.model.components.TipoTeletransporte;
import es.iessaladillo.juegos.saladillo.util.Entidad;

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
			
			if(s.equals("Heroe") ||
					s.equals("Heroina")) {
				d = new Heroe();
				
			} else if (s.equals("Diamante")) {
				d = new Diamante();
				
			} else if (s.matches("Teletransporte.*")) {
				TipoTeletransporte tt = (TipoTeletransporte.isRojo(s) ?
					TipoTeletransporte.TeletransporteRojo :
					TipoTeletransporte.TeletransporteAzul);
				
				d = new Teletransporte(tt);
				
			} else {
				TipoFijo tfijo = TipoFijo.getTipo(s);
				
				if (tfijo != null) {
					d = new Fijo(tfijo);
					
				} else {
					// No habrá problemas
					d = new Fondo(TipoFondo.getTipo(s));
					
				}
			}
			
			// De no haber dibujable en el array, pone el elemento directamente en el array.
			if((c = dibujables[e.getY()][e.getX()]) == null) {
				dibujables[e.getY()][e.getX()] = d;
				
			} else if(d instanceof Fondo) {
				c.setFondo(d);
				dibujables[e.getY()][e.getX()] = c;
				
			} else {
				d.setFondo(c);
				dibujables[e.getY()][e.getX()] = d;
				
			}
		}
		
		return new Mapa(dibujables);
	}
}
