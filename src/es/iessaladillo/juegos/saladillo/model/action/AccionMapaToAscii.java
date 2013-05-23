package es.iessaladillo.juegos.saladillo.model.action;

import es.iessaladillo.juegos.saladillo.controller.Dibujable;
import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.components.Diamante;
import es.iessaladillo.juegos.saladillo.model.components.Fijo;
import es.iessaladillo.juegos.saladillo.model.components.Heroe;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.model.components.Teletransporte;
import es.iessaladillo.juegos.saladillo.model.components.TipoTeletransporte;

public class AccionMapaToAscii implements Accion {

	private Mapa mapa;
	
	public AccionMapaToAscii(MapaInterface mapa) {
		this.mapa = (Mapa)mapa;
	}

	@Override
	public Object ejecutar() {
		String s=new String();
		int i,j;
		int tam=mapa.getDibujables().length;
		
		s+=("1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 |");
		
		for (i=0;i<tam;i++) {
			s+=(i+1)+" |";
			for (j=0;j<tam;j++) {
				Dibujable d = mapa.getDibujables()[i][j];
				if (d instanceof Diamante) s+="$ |";
				else if (d instanceof Heroe) s+="@ |";
				else if (d instanceof Teletransporte) {
					if (((Teletransporte) d).getTipo()==TipoTeletransporte.TeletransporteRojo) s+="R |";
					else s+="A |";
				}
				else if (d instanceof Fijo) {
					if (((Fijo) d).getTipo().isMovible()) s+="O |";
					else s+="X |";
				}
				else s+="� |";
				s+="\n";
			}
		}
		
		return s;
	}

}
