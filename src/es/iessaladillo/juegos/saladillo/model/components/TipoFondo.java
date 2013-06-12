package es.iessaladillo.juegos.saladillo.model.components;

/**
 * Enumeración que contiene todos los posibles tipos que adoptará un elemento
 * del fondo.
 * 
 */
public enum TipoFondo {
	CaminoArena, CaminoArenaCombinadoD, CaminoArenaCombinadoL, CaminoArenaCombinadoR, CaminoArenaCombinadoU, CaminoArenaCurvaLD, CaminoArenaCurvaLU, CaminoArenaCurvaRU, CaminoArenaCurvaRD, CaminoArenaHorizontal, CaminoArenaVertical, Carretera, Cesped, CespedCombinadoD, CespedCombinadoL, CespedCombinadoR, CespedCombinadoU, CespedCurvaLD, CespedCurvaLU, CespedCurvaRD, CespedCurvaRU, CespedHorizontal, CespedSendero, CespedSenderoCurvaLD, CespedSenderoCurvaLU, CespedSenderoCurvaRD, CespedSenderoCurvaRU, CespedSenderoHorizontal, CespedSenderoVertical, CespedVertical, CaminoArenaCespedCurvaLD, CaminoArenaCespedCurvaLU, CaminoArenaCespedCurvaRD, CaminoArenaCespedCurvaRU, CaminoArenaGravillaCurvaRU, CaminoArenaGravillaLD, CaminoArenaGravillaLU, CaminoArenaGravillaRD, CaminoArenaGravillaRU;

	public static TipoFondo getTipo(String s) {
		TipoFondo t = null;

		if (s.equals("CaminoArena"))
			t = CaminoArena;
		else if (s.equals("CaminoArenaCombinadoD"))
			t = CaminoArenaCombinadoD;
		else if (s.equals("CaminoArenaCombinadoL"))
			t = CaminoArenaCombinadoL;
		else if (s.equals("CaminoArenaCombinadoR"))
			t = CaminoArenaCombinadoR;
		else if (s.equals("CaminoArenaCombinadoU"))
			t = CaminoArenaCombinadoU;
		else if (s.equals("CaminoArenaCurvaLD"))
			t = CaminoArenaCurvaLD;
		else if (s.equals("CaminoArenaCurvaLU"))
			t = CaminoArenaCurvaLU;
		else if (s.equals("CaminoArenaCurvaRU"))
			t = CaminoArenaCurvaRU;
		else if (s.equals("CaminoArenaCurvaRD"))
			t = CaminoArenaCurvaRD;
		else if (s.equals("CaminoArenaHorizontal"))
			t = CaminoArenaHorizontal;
		else if (s.equals("CaminoArenaVertical"))
			t = CaminoArenaVertical;
		else if (s.equals("Carretera"))
			t = Carretera;
		else if (s.equals("Cesped"))
			t = Cesped;
		else if (s.equals("CespedCombinadoD"))
			t = CespedCombinadoD;
		else if (s.equals("CespedCombinadoL"))
			t = CespedCombinadoL;
		else if (s.equals("CespedCombinadoR"))
			t = CespedCombinadoR;
		else if (s.equals("CespedCombinadoU"))
			t = CespedCombinadoU;
		else if (s.equals("CespedCurvaLD"))
			t = CespedCurvaLD;
		else if (s.equals("CespedCurvaLU"))
			t = CespedCurvaLU;
		else if (s.equals("CespedCurvaRD"))
			t = CespedCurvaRD;
		else if (s.equals("CespedCurvaRU"))
			t = CespedCurvaRU;
		else if (s.equals("CespedHorizontal"))
			t = CespedHorizontal;
		else if (s.equals("CespedSendero"))
			t = CespedSendero;
		else if (s.equals("CespedSenderoCurvaLD"))
			t = CespedSenderoCurvaLD;
		else if (s.equals("CespedSenderoCurvaLU"))
			t = CespedSenderoCurvaLU;
		else if (s.equals("CespedSenderoCurvaRD"))
			t = CespedSenderoCurvaRD;
		else if (s.equals("CespedSenderoCurvaRU"))
			t = CespedSenderoCurvaRU;
		else if (s.equals("CespedSenderoHorizontal"))
			t = CespedSenderoHorizontal;
		else if (s.equals("CespedSenderoVertical"))
			t = CespedSenderoVertical;
		else if (s.equals("CespedVertical"))
			t = CespedVertical;
		else if (s.equals("CaminoArenaCespedCurvaLD"))
			t = CaminoArenaCespedCurvaLD;
		else if (s.equals("CaminoArenaCespedCurvaLU"))
			t = CaminoArenaCespedCurvaLU;
		else if (s.equals("CaminoArenaCespedCurvaRD"))
			t = CaminoArenaCespedCurvaRD;
		else if (s.equals("CaminoArenaCespedCurvaRU"))
			t = CaminoArenaCespedCurvaRU;
		else if (s.equals("CaminoArenaGravillaLD"))
			t = CaminoArenaGravillaLD;
		else if (s.equals("CaminoArenaGravillaLU"))
			t = CaminoArenaGravillaLU;
		else if (s.equals("CaminoArenaGravillaRD"))
			t = CaminoArenaGravillaRD;
		else if (s.equals("CaminoArenaGravillaRU"))
			t = CaminoArenaGravillaRU;
		else if (s.equals("CaminoArenaGravillaCurvaRU"))
			t = CaminoArenaGravillaCurvaRU;

		return t;
	}
}
