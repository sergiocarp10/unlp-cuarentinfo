/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa el fantasma llamado Inky, que tiene una estrategia avanzada 
 * para lograr emboscar a PacMan, utilizando las posiciones de �ste y tambi�n de Blinky
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class Inky extends Fantasma {
	private static final int CELDAS_DELANTE = 2;
	private static final int MIN_PUNTOS_SALIR = 30;
	private Blinky blinky;
	
	public Inky() {
		super();
	}

	/**
	 * Constructor que permite referenciar el tablero, la entidad a perseguir y el 
	 * fantasma compa�ero del cu�l Inky usar� su posici�n para calcular su estrategia
	 * @param tablero la instancia del tablero utilizada por la partida y el resto de personajes
	 * @param pacman La instancia del PacMan que maneja el agente/usuario
	 * @param blinky La instancia del fantasma Blinky para conocer su posici�n en la estrategia
	 */
	public Inky(Tablero tablero, Pacman pacman, Blinky blinky) {
		super(tablero, pacman, 5);
		this.blinky = blinky;
	}
	
	@Override
	public void resetearPosicion() {
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.DOWN);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(1);
		super.getPosicion().cambiar(posInicio[0], posInicio[1]);
	}
	
	@Override
	public void notificarPosPacman() {
		int[] posPacman = super.getPacman().getPosicion().getVector();
		int[] posBlinky = this.blinky.getPosicion().getVector();
		super.getHelper().getPosConDelta(posPacman, super.getPacman().getAngulo(), CELDAS_DELANTE);
		int[] vec = this.trazarVector(posPacman, posBlinky);
		this.duplicarVector(vec);
		super.cambiarObjetivo(vec[0], vec[1]);
		
		// Evitar dobles llamadas y aprovechar encapsulamiento
		this.verificarSalirCasa();
	}
	
	/**
	 * Notifica al fantasma el puntaje actual y lo saca de la casa si es necesario
	 * @param puntaje la cantidad de puntos actuales en la partida
	 */
	private void verificarSalirCasa() {
		if (super.isEstaEnCasa() && super.getHelper().getPuntosComidos() >= MIN_PUNTOS_SALIR) {
			super.abandonarCasa();
		}
	}
	
	/**
	 * Traza un vector entre dos posiciones
	 * @param v1 el vector de la primera posici�n
	 * @param v2 el vector de la segunda posici�n
	 * @return el vector resultante de ir desde la primera hasta la segunda
	 */
	private int[] trazarVector(int[] v1, int[] v2) {
		// implementaci�n
		return null;
	}
	
	/**
	 * Multiplica ambos pares de valores (x,y) por dos y lo devuelve v�a par�metro
	 * @param vector el arreglo de dos numeros correspondientes al vector
	 */
	private void duplicarVector(int[] vector) {
		vector[0] *= 2;
		vector[1] *= 2;
	}
}
