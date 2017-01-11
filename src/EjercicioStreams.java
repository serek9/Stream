import java.time.LocalDate;

public class EjercicioStreams {
    public static void main(String[] args) {
        Equipo A = new Equipo("Equipo A", "Barcelona");
        Equipo B = new Equipo("Equipo B", "Bilbao");

        Jugador j11 = new Jugador("Sergio", LocalDate.of(1996,8,8), 14, A);
        Jugador j12 = new Jugador("Alberto", LocalDate.of(1996,8,8), 12, A);
        Jugador j13 = new Jugador("Victor", LocalDate.of(1996,8,8), 8, A);
        Jugador j14 = new Jugador("Fernando", LocalDate.of(1996,8,8), 20, A);

        Jugador j21 = new Jugador("Larry", LocalDate.of(1996,8,8), 11, B);
        Jugador j22 = new Jugador("Manrike", LocalDate.of(1996,8,8), 7, B);
        Jugador j23 = new Jugador("Kim", LocalDate.of(1996,8,8), 21, B);
        Jugador j24 = new Jugador("Obiol", LocalDate.of(1996,8,8), 12, B);

//        2.2	Devolver con una lista  todos los jugadores que hayan obtenido más de 500 canastas.


//        2.3	Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.


//        2.4	Devolver en una lista exclusivamente los nombres de los jugadores que satisfacen  los requisitos del 2.3


//        2.5	Devolver con una lista todos los jugadores ordenados por la fecha de nacimiento.


//        2.6	Devolver con una lista todos los jugadores ordenados por número de canastas.


//        2.7	Devolver con una lista con los cinco jugadores que hayan realizado más canastas.


//        2.8	Devolver con una lista todos los jugadores que satisfacen el punto 2.3 ordenados por la fecha de nacimiento de manera descendente.


//        2.9	Devolver con una lista todos los jugadores que satisfacen el filtro del punto 1.3 ordenados, en primer lugar por número de canastas y en segundo lugar (si tienen el mismo número de canastas) por la fecha de nacimiento.


//        2.10 Devolver el jugador que ha realizado el mínimo número de canastas.


//        2.11 Devolver el jugador que ha realizado el máximo número de canastas.


//        2.12 Devolver la media de canastas de todos los jugadores.


//        2.13 Devolver con una lista todos los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.


//        2.14 Devolver con un boolean si hay algún jugador que ha conseguido más de 4.000 canastas.


//        2.15 Devolver con un boolean si todos los jugadores han conseguido más de 50 canastas.


//        2.16 Devolver con un boolean si todos los jugadores del primer equipo añadido han conseguido más de 50 canastas.


//        2.17 Devolver un Map<String, List<Equipo>> agrupando los equipos que pertenecen a una misma localidad. Hay un ejemplo similar en la página 172 (6.3 Grouping).


//        2.18 Devolver la suma del número de canastas de todos los jugadores. Utilizar la operación Reduce (página 132,  5.4)


    }
}