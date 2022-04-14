package tallerlenguajes2.tp3.peliculas.model;

import java.util.*;

/**
 * Clase que almacena toda la informaci�n necesaria para mostrarla en el tablero de control de pel�culas,
 * tales como una lista con cada pel�cula (engloba la informaci�n individual) y la cantidad de usuarios
 * @author Calder�n Sergio y Ercoli Juan Mart�n
 * @version 1
 */
public class Datos {
    private final List<Pelicula> peliculas;
    private Iterator<Pelicula> iterator;

    private int cantUsuarios;

    /**
     * Constructor por defecto, inicializa una lista de pel�culas para su posterior carga
     */
    public Datos() {
        this.peliculas = new ArrayList<>();
        this.cantUsuarios = 0;
    }

    /**
     * Permite obtener la cantidad de usuarios que votaron seg�n el archivo ratings.csv (sin repetir)
     * @return el valor del atributo cantUsuarios
     */
    public int getCantUsuarios() {
        return cantUsuarios;
    }

    /**
     * Permite obtener la lista con todas las instancias de Pel�cula cargadas por el Lector
     * @return la referencia al atributo peliculas
     */
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * Permite obtener la cantidad de pel�culas encontradas en el archivo movies.csv
     * @return el tamaño de la lista de pel�culas
     */
    public int getCantPeliculas() {
        return getPeliculas().size();
    }

    /**
     * Realiza un c�lculo a partir de todas las instancias de pel�culas en la lista ya cargada,
     * sumando sus cantidades de votos individuales. Este resultado difiere de la cantidad
     * de usuarios ya que los mismos pueden votar por m�s de una pel�cula
     * @return la suma de votos total
     */
    public int getCantVotos() {
        int sum = 0;

        for (Pelicula p : getPeliculas()){
            sum += p.getCantVotos();
        }

        return sum;
    }

    /**
     * Incrementa el valor del atributo cantUsuarios en 1
     */
    public void incrementarUsuarios(){
        this.cantUsuarios++;
    }

    /**
     * Crea y agrega una instancia de Pel�cula a la lista
     * @param titulo el t�tulo de la pel�cula
     * @param movieId el ID de la pel�cula
     */
    public void agregarPelicula(String titulo, String movieId){
        this.getPeliculas().add(new Pelicula(titulo, movieId));
    }

    /**
     * Permite regresar el puntero de lista al primer elemento. Esto debe realizarse
     * cuando en el archivo ratings.csv se lee un voto de un nuevo usuario, ya que
     * se tiene como precondici�n que los votos de un mismo usuario est�n ordenados por movieId
     */
    public void reiniciarIterador(){
        iterator = getPeliculas().iterator();
    }

    /**
     * Permite obtener la pel�cula previamente cargada a partir de su ID. La b�squeda se realiza
     * a partir de la �ltima posici�n, por lo que es importante reiniciar el iterador si se
     * desea buscar a la misma en toda la lista en lugar de s�lo una parte
     * @param movieId el ID de la pel�cula
     * @return la instancia de Pel�cula correspondiente, null si no pudo ser encontrada
     */
    public Pelicula getPelicula(String movieId){
        while (iterator.hasNext()){
            Pelicula p = iterator.next();
            if (p.getMovieId().equals(movieId)) {
                return p;
            }
        }

        System.err.println("Se solicit� obtener la pel�cula " + movieId + ", la cual no est� cargada");
        return null;
    }

    /**
     * Recorre la lista de pel�culas ya cargada, contando los votos y agrup�ndolos seg�n su rating.
     * Este resumen es �til para mostrarlo de forma gr�fica, por ejemplo, en el histograma general.
     * @return un arreglo de longitud 6, el cual las posiciones 1-5 almacenan las cantidades de
     * votos encontrados con dicho rating
     */
    public int[] getVotosTotales(){
        int[] result = new int[6];

        for (Pelicula p : getPeliculas()){
            for (int i=1; i<=5; i++){
                result[i] += p.getCantVotos(i);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Se tienen " + getCantUsuarios() + " usuarios, " +
                getCantPeliculas() + " pel�culas, " +
                getCantVotos() + " votos";
    }
}
