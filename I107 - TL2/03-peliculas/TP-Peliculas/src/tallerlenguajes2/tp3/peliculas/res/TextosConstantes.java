package tallerlenguajes2.tp3.peliculas.res;

/**
 * Clase que almacena String extensos utilizados en la interfaz gr�fica
 * @author Ercoli Juan Mart�n y Calder�n Sergio
 * @version 1
 */
public class TextosConstantes {

    /** Explicaci�n de la app, se muestra en la opci�n "�C�mo funciona?" */
    public static final String MSG_HOW =
                             "<html>"
            +                "El proyecto consiste en <b>4 paneles</b> que tienen asignada una funci�n determinada:"
            +                "<br><br>   &emsp;\u2022<b> <u>Panel de procesar datos:</u></b>"
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene un boton que al presionarlo, carga los datos de las pel�culas <br>"
            +                "             &emsp;&emsp;&emsp;       almacenados en dos archivos .csv (contenidos en la ra�z) al programa."
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene una barra de progreso para visualizar el progreso de la carga "
            +                "<br><br>     &emsp;\u2022<b> <u>Panel de contadores:</u></b>"
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene un contador para la cantidad de usuarios procesados."
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene un contador para la cantidad de pel�culas procesadas."
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene un contador para la cantidad de votos procesados."
            +                "<br><br>     &emsp;\u2022<b> <u>Panel de tabla y selecci�n:</u></b>"
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene un selector que permite elegir la cantidad de pel�culas a mostrar"
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene una tabla que muestra las pel�culas (y su informaci�n) ordenadas en <br>"
            +                "             &emsp;&emsp;&emsp;       orden descendente por la cantidad de votos que tienen."
            +                "<br><br>     &emsp;\u2022<b> <u>Panel de histograma:</u></b>"
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Contiene un histograma que est� relacionado a la tabla"
            +                "<br>          &emsp;&emsp;&emsp;\u25E6 Contiene un bot�n que al presionarlo muestra la cantidad total de votos  <br>"
            +                "             &emsp;&emsp;&emsp;       ordenados por la cantidad de estrellitas (rating) que poseen."
            +                "<br>          &emsp;&emsp;&emsp;\u25E6 Contiene un contador cantidad de votos de las pel�culas seleccionadas <br>"
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Al principio el histograma mostrar� la cantidad total de votos ordenados por la <br>"
            +                "             &emsp;&emsp;&emsp;       cantidad de estrellitas (rating) que poseen."
            +                "<br>          &emsp;&emsp;&emsp;\u25E6 Al seleccionar una pel�cula en la tabla, el histograma mostrar� los votos de la <br>"
            +                "             &emsp;&emsp;&emsp;       pel�cula ordenados por la cantidad de estrellitas (rating) que poseen."
            +                "<br>         &emsp;&emsp;&emsp;\u25E6 Al seleccionar varias pel�culas de la tabla, el histograma mostrara la suma de <br>"
            +                "             &emsp;&emsp;&emsp;       votos de las pel�culas ordenados por el rating que poseen "
            +                "</html>";

    /** Mensaje a mostrar cuando el usuario cliquea en "Acerca de" */
    public static final String MSG_ABOUT =
                             "<html>"
            +                "Proyecto realizado por: "
            +                "<br>     &emsp;\u2022" + " <b>Sergio Leandro Calder�n.</b>"
            +                "<br>     &emsp;\u2022" + " <b>Juan Mart�n Ercoli.</b>"
            +                "<br> <u>Para la materia Taller de Lenguajes II.</u> <br>"
            +                "<br>La idea de este proyecto consiste en tomar<br>"
            +                "un conjunto de datos referentes a pel�culas<br>"
            +                "provisto por GroupLens, con alrededor de:<br>"
            +                "     &emsp;\u2022 100,000 votos.<br>"
            +                "     &emsp;\u2022 9,000 pel�culas.<br>"
            +                "     &emsp;\u2022 600 usuarios.<br>"
            +                "<br>El objetivo es generar una interfaz gr�fica que<br>"
            +                "permita ver de forma amigable toda la informaci�n."
            +                "</html>";
}
