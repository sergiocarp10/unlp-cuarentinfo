/**
 *
 */
package board;

/**
 * Representa el conjunto de celdas del juego, las cuales son objetos que se encuentran en 
 * una posici�n fija y pueden cambiar su estado si es necesario (caso puntos y fruta).
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class Tablero {
	public static final byte MAX_SIZE = 32;
	public static final int PUNTOS_COMIDA = 10, PUNTOS_FRUTA = 30;
	private int cantPuntosInicio, cantPuntosRestantes;
	private TipoCelda[][] matriz;
	
	/**
	 * Constructor sin par�metros, inicializa un tablero vac�o de dimensiones por defecto
	 */
	public Tablero() {
		this.matriz = new TipoCelda[MAX_SIZE][MAX_SIZE];
	}

	/**
	 * @return el valor del atributo cantPuntosInicio
	 */
	public int getCantPuntosInicio() {
		return cantPuntosInicio;
	}

	/**
	 * @param cantPuntosInicio el valor del atributo cantPuntosInicio a asignar
	 */
	public void setCantPuntosInicio(int cantPuntosInicio) {
		this.cantPuntosInicio = cantPuntosInicio;
	}

	/**
	 * @return el valor del atributo cantPuntosRestantes
	 */
	public int getCantPuntosRestantes() {
		return cantPuntosRestantes;
	}
	
	/**
	 * @param cantPuntosRestantes el valor del atributo cantPuntosRestantes a asignar
	 */
	public void setCantPuntosRestantes(int cantPuntosRestantes) {
		this.cantPuntosRestantes = cantPuntosRestantes;
	}


	/**
	 * Carga el tablero con los tipos de celda correspondientes
	 */
	public void crearPorDefecto() {
		// Implementaci�n
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda en la coordenada (x,y) es transitable
	 */
	public boolean esTransitable(int x, int y) {
		// Implementaci�n
		return false;
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda en la coordenada (x,y) es un t�nel
	 */
	public boolean esTunel(int x, int y) {
		return this.matriz[x][y] == TipoCelda.TUNEL;
	}
	
	/**
	 * 
	 * @return Un arreglo con los valores (x,y) correspondientes a la casa.
	 */
	public int[] getEspacioCasa() {
		// Implementaci�n
		return null;
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda a�n contiene un punto
	 */
	public boolean tieneComida(int x, int y) {
		return (this.matriz[x][y] == TipoCelda.PUNTO);
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda contiene una de las 4 frutas
	 */
	public boolean tieneFruta(int x, int y) {
		return (this.matriz[x][y] == TipoCelda.FRUTA);
	}
	
	/**
	 * Establece una celda como libre y actualiza el contador de puntos restantes. 
	 * Invocar �nicamente si se verific� anteriormente que la misma tiene comida o fruta
	 * @param x el valor de abscisas a cambiar
	 * @param y el valor de ordenada a cambiar
	 * @return Si se comieron todos los puntos del tablero
	 */
	public boolean quitarPunto(int x, int y) {
		this.matriz[x][y] = TipoCelda.LIBRE;
		this.cantPuntosRestantes--;
		return cantPuntosRestantes == 0;
	}
}
