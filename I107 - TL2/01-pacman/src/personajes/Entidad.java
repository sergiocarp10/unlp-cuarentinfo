/**
 * 
 */
package personajes;

import utils.NewPositionsHelper;
import java.awt.Image;
import board.Tablero;

/**
 * Representa un objeto que puede moverse por el tablero durante la partida, el
 * cual tiene una {@link Posicion}, una {@link Direccion} a donde se encuentra mirando
 * actualmente, una utilidad {@link NewPositionsHelper} para efectuar c�lculos entre 
 * celdas y comprobar posiciones v�lidas para avanzar, un booleano que indica si es 
 * aut�mata (controlado por la CPU) o manejado por el usuario, y la velocidad.
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public abstract class Entidad {
	private Posicion posicion;
	private Direccion angulo;
	private NewPositionsHelper helper;
	private Image graficos;
	private boolean manejadoPorCPU;
	private int velocidadEnMs;
	
	/**
	 * Constructor por defecto, sin par�metros
	 */
	public Entidad() {
		this.helper = new NewPositionsHelper();
		this.posicion = new Posicion();
	}
	
	/**
	 * Constructor que permite referenciar el tablero y asignar si es entidad aut�mata
	 * @param tablero la instancia del tablero utilizada por la partida y el resto de personajes
	 * @param manejadoPorCPU booleano que debe ser true si la CPU se encarga de moverlo por el tablero
	 */
	public Entidad(Tablero tablero, boolean manejadoPorCPU) {
		this();
		this.helper.referenciarTablero(tablero);
		this.manejadoPorCPU = manejadoPorCPU;
	}

	/**
	 * Permite obtener la posici�n actual de la entidad
	 * @return el valor del atributo posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * Permite cambiar la posici�n de la entidad.
	 * Se recomienda usar getPosicion().cambiar(x,y) para evitar crear instancias
	 * @param posicion el valor del atributo posicion a asignar
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * Permite obtener la direcci�n a la cual se encuentra mirando la entidad actualmente
	 * @return el valor del atributo angulo
	 */
	public Direccion getAngulo() {
		return angulo;
	}

	/**
	 * Permite cambiar la direcci�n (4 posibles) que est� mirando la entidad
	 * @param angulo el valor del atributo angulo a asignar
	 */
	public void setAngulo(Direccion angulo) {
		this.angulo = angulo;
	}


	/**
	 * @return el valor del atributo graficos
	 */
	public Image getGraficos() {
		return graficos;
	}

	/**
	 * @param graficos el valor del atributo graficos a asignar
	 */
	public void setGraficos(Image graficos) {
		this.graficos = graficos;
	}

	/**
	 * Permite conocer si la entidad es aut�mata (true) o manejada por el usuario (false)
	 * @return el valor del atributo manejadoPorCPU
	 */
	public boolean isManejadoPorCPU() {
		return manejadoPorCPU;
	}

	/**
	 * Permite establecer si la entidad es aut�mata (true) o manejada por el usuario (false)
	 * @param manejadoPorCPU el valor del atributo manejadoPorCPU a asignar
	 */
	public void setManejadoPorCPU(boolean manejadoPorCPU) {
		this.manejadoPorCPU = manejadoPorCPU;
	}

	/**
	 * Permite obtener la velocidad del personaje
	 * @return el valor del atributo velocidadEnMs
	 */
	public int getVelocidadEnMs() {
		return velocidadEnMs;
	}

	/**
	 * Permite cambiar la velocidad del personaje
	 * @param velocidadEnMs el valor del atributo velocidadEnMs a asignar
	 */
	public void setVelocidadEnMs(int velocidadEnMs) {
		this.velocidadEnMs = velocidadEnMs;
	}

	/**
	 * Restaura la ubicaci�n por defecto, importante para inicializar y �til 
	 * cuando se debe "recomenzar la partida", ej: cuando PacMan pierde una vida
	 */
	public abstract void resetearPosicion();
	
	/**
	 * Cambia el �ngulo a la siguiente direcci�n en el sentido de las agujas del reloj
	 */
	public void girarHorario() {
		switch (this.getAngulo()) {
			case DOWN: {
				this.setAngulo(Direccion.LEFT);
				break;
			}
			case LEFT: {
				this.setAngulo(Direccion.UP);
				break;
			}
			case UP: {
				this.setAngulo(Direccion.RIGHT);
				break;
			}
			case RIGHT: {
				this.setAngulo(Direccion.DOWN);
				break;
			}
		}
	}
	
	/**
	 * Delega el c�lculo de la siguiente posici�n en la direcci�n propuesta y efect�a
	 * el movimiento en caso de que sea posible
	 * @param direccion el �ngulo inicial, es decir, antes de efectuar el movimiento
	 * @return si fue posible avanzar en dicha direcci�n en el caso de entidades 
	 * manejadas por el usuario. Siempre devolver� true si lo maneja la CPU ya que 
	 * lo gira autom�ticamente, entonces la Partida puede ignorar el resultado en dicho caso
	 */
	public boolean intentarMov(Direccion direccion) {
		int[] vector = this.getPosicion().getVector();
		helper.getPosInmediata(vector, direccion);
		
		if (this.isManejadoPorCPU()) {
			while (!helper.validarPosicion(vector)) {
				this.girarHorario();
				helper.getPosInmediata(vector, direccion);
			}
			this.efectuarMov(vector);
			return true;
		} else {
			if (helper.validarPosicion(vector)) {
				this.efectuarMov(vector);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Realiza la animaci�n de pasar por un t�nel y traslada la entidad a la posici�n de salida
	 * @param direccion En cu�l de las 4 direcciones posibles est� ingresando
	 */
	public void pasarPorTunel(Direccion direccion) {
		int[] vector = this.getPosicion().getVector();
		velocidadEnMs += 10;
		// efectuar animacion
		helper.getPosInversa(vector, direccion);
		this.efectuarMov(vector);
		velocidadEnMs -= 10;
	}
	
	/**
	 * Realiza la animaci�n del personaje al moverse y actualiza su posici�n
	 * @param nuevaPos el vector (x,y) de la nueva celda v�lida a avanzar
	 */
	private void efectuarMov(int[] nuevaPos) {
		this.getPosicion().cambiar(nuevaPos[0], nuevaPos[1]);
		this.redibujar();
	}
	
	
	/**
	 * Actualiza el gr�fico de la entidad
	 */
	private void redibujar() {
		// Implementaci�n
	}
	
	/**
	 * 
	 * @return La instancia de utilidad para calcular y predecir posiciones
	 * (s�lo est� permitido su uso en clases heredadas, �til para los fantasmas)
	 */
	protected NewPositionsHelper getHelper() {
		return helper;
	}
}
