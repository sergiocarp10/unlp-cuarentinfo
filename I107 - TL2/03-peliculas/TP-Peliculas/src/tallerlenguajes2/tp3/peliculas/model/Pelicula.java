package tallerlenguajes2.tp3.peliculas.model;

/**
 * Clase que representa una pel�cula con los datos obtenidos de los archivos csv, tales como
 * el t�tulo, ID, votos y usuarios.
 * @author Calder�n Sergio y Ercoli Juan Mart�n
 * @version 1
 */
public class Pelicula implements Comparable<Pelicula> {
    private String titulo, movieId;

    private final int[] votos;
    private int cantUsuarios;

    // Variables de acceso r�pido (para el ordenamiento)
    private float ratingPromedio = -1;
    private int cantVotos;

    /**
     * Constructor por defecto, inicializa el arreglo resumen de votos con todas sus posiciones en 0
     */
    public Pelicula(){
        this.votos = new int[6];    // el 0 no se usar�
    }

    /**
     * Constructor que permite instanciar una Pel�cula con los datos b�sicos segun movies.csv
     * @param titulo el t�tulo de la pel�cula
     * @param movieId el ID de la pel�cula
     */
    public Pelicula(String titulo, String movieId){
        this();
        this.setTitulo(titulo);
        this.setMovieId(movieId);
    }

    /**
     * Permite obtener el t�tulo de la pel�cula
     * @return el valor del atributo titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Permite obtener el ID de la pel�cula
     * @return el valor del atributo movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * Permite setear el ID de la pel�cula
     * @param movieId el valor a asignar
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * Permite setear el t�tulo de la pel�cula
     * @param titulo el valor a asignar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Permite obtener la cantidad de usuarios que votaron por esta pel�cula según ratings.csv
     * @return el valor del atributo cantUsuarios
     */
    public int getCantUsuarios() {
        return cantUsuarios;
    }

    /**
     * Permite obtener la cantidad de votos
     * @return el valor del atributo cantVotos
     */
    public int getCantVotos() {
        return cantVotos;
    }

    private float getTotalPuntos() {
        int sum = 0;

        for (int i=1; i<=5; i++){
            sum += votos[i] * i;
        }

        return sum;
    }

    /**
     * Si se invoca por primera vez, realiza una sumatoria de todos los votos multiplicado por su rating
     * y luego lo divide por la cantidad total de votos para obtener el promedio. Por temas de eficiencia,
     * este promedio queda almacenado como variable si se requiere calcularlo nuevamente m�s tarde
     * (sin a�adir votos)
     * @return el valor del atributo ratingPromedio
     */
    public float getRatingPromedio(){
        if (cantVotos == 0) return 0;
        if (ratingPromedio == -1) ratingPromedio = getTotalPuntos() / getCantVotos();
        return ratingPromedio;
    }

    /**
     * Permite incrementar la cantidad de usuarios en 1
     */
    public void incrementarUsuarios(){
        this.cantUsuarios++;
    }

    /**
     * Permite agregar un voto de un usuario. Si el mismo no es entero, es redondeado.
     * @param valor el rating de dicho voto (entre 0 y 5)
     */
    public void addVoto(float valor){
        int valorRedondo = Math.round(valor);
        votos[valorRedondo]++;
        cantVotos++;
    }

    /**
     * Permite obtener la cantidad de votos que se agregaron para un determinado valor de rating
     * @param valor el rating objetivo (entre 0 y 5)
     * @return la cantidad almacenada para dicho valor
     */
    public int getCantVotos(int valor){
        return votos[valor];
    }

    @Override
    public String toString() {
        return "T�tulo: " + getTitulo() + ", movieId: " + getMovieId() +
                ", que recibi� " + getCantVotos() + " votos, con un promedio de " + getRatingPromedio();
    }

    /**
     * Realiza la comparaci�n en base a la cantidad de usuarios almacenada. Permite que
     * {@link java.util.Comparator Comparator} las ordene de mayor a menor por dicho criterio
     * @param o otra instancia de pel�cula contra la cual comparar
     * @return si la instancia actual tiene m�s cantidad de usuarios
     */
    @Override
    public int compareTo(Pelicula o) {
        return Integer.compare(o.getCantUsuarios(), this.getCantUsuarios());
    }
}