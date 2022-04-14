package board;

/**
 * Enumerativo con los objetos no desplazables del tablero. 
 * Se restringen a los siguientes: LIBRE (transitable sin punto), PARED (obst�culo), 
 * CASA (exclusivo para fantasmas), TUNEL, PUNTO y FRUTA (tambi�n transitables).
 * 
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public enum TipoCelda {
	LIBRE, PARED, CASA, TUNEL, PUNTO, FRUTA
}
