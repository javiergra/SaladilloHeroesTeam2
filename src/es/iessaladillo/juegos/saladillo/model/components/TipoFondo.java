package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeración que contiene todos los posibles tipos que adoptará un elemento del fondo.
 *
 */
public enum TipoFondo { 
	CaminoArena,
	CaminoArenaCombinadoD,
	CaminoArenaCombinadoL,
	CaminoArenaCombinadoR,
	CombinadoU,
	CaminoArenaCurvaLD,
	CaminoArenaCurvaLU,
	CaminoArenaCurvaRU, 
	CaminoArenaCurvaRD,
	CaminoArenaHorizontal,
	CaminoArenaVertical,
	Carretera,
	Cesped, 
	CespedCombinadoD,
	CespedCombinadoL,
	CespedCombinadoR,
	CespedCombinadoU, 
	CespedCurvaLD,
	CespedCurvaLU,
	CespedCurvaRD,
	CespedCurvaRU,
	CespedHorizontal, 
	CespedSendero,
	CespedSenderoCurvaLD,
	CespedSenderoCurvaLU,
	CespedSenderoCurvaRD, 
	CespedSenderoCurvaRU,
	CespedSenderoHorizontal,
	CespedSenderoVertical,
	CespedVertical, 
	CaminoArenaCespedCurvaLD,
	CaminoArenaCespedCurvaLU,
	CaminoArenaCespedCurvaRD, 
	CaminoArenaCespedCurvaRU,
	CaminoArenaGravillaLD,
	CaminoArenaGravillaLU, 
	CaminoArenaGravillaRD,
	CaminoArenaGravillaRU;
	
	public static TipoFondo getTipo(String s) {
		switch(s) {
		case "CaminoArena": return CaminoArena;
		case "CaminoArenaCombinadoD": return CaminoArenaCombinadoD;
		case "CaminoArenaCombinadoL": return CaminoArenaCombinadoL;
		case "CaminoArenaCombinadoR": return CaminoArenaCombinadoR;
		case "CombinadoU": return CombinadoU;
		case "CaminoArenaCurvaLD": return CaminoArenaCurvaLD;
		case "CaminoArenaCurvaLU": return CaminoArenaCurvaLU;
		case "CaminoArenaCurvaRU": return CaminoArenaCurvaRU;
		case "CaminoArenaCurvaRD": return CaminoArenaCurvaRD;
		case "CaminoArenaHorizontal": return CaminoArenaHorizontal;
		case "CaminoArenaVertical": return CaminoArenaVertical;
		case "Carretera": return Carretera;
		case "Cesped": return Cesped;
		case "CespedCombinadoD": return CespedCombinadoD;
		case "CespedCombinadoL": return CespedCombinadoL;
		case "CespedCombinadoR": return CespedCombinadoR;
		case "CespedCombinadoU": return CespedCombinadoU;
		case "CespedCurvaLD": return CespedCurvaLD;
		case "CespedCurvaLU": return CespedCurvaLU;
		case "CespedCurvaRD": return CespedCurvaRD;
		case "CespedCurvaRU": return CespedCurvaRU;
		case "CespedHorizontal": return CespedHorizontal;
		case "CespedSendero": return CespedSendero;
		case "CespedSenderoCurvaLD": return CespedSenderoCurvaLD;
		case "CespedSenderoCurvaLU": return CespedSenderoCurvaLU;
		case "CespedSenderoCurvaRD": return CespedSenderoCurvaRD;
		case "CespedSenderoCurvaRU": return CespedSenderoCurvaRU;
		case "CespedSenderoHorizontal": return CespedSenderoHorizontal;
		case "CespedSenderoVertical": return CespedSenderoVertical;
		case "CespedVertical": return CespedVertical;
		case "CaminoArenaCespedCurvaLD": return CaminoArenaCespedCurvaLD;
		case "CaminoArenaCespedCurvaLU": return CaminoArenaCespedCurvaLU;
		case "CaminoArenaCespedCurvaRD": return CaminoArenaCespedCurvaRD;
		case "CaminoArenaCespedCurvaRU": return CaminoArenaCespedCurvaRU;
		case "CaminoArenaGravillaLD": return CaminoArenaGravillaLD;
		case "CaminoArenaGravillaLU": return CaminoArenaGravillaLU;
		case "CaminoArenaGravillaRD": return CaminoArenaGravillaRD;
		case "CaminoArenaGravillaRU": return CaminoArenaGravillaRU;
		}
		
		return null;
	}
}
