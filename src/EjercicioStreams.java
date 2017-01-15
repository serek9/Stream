import sun.nio.cs.ext.JIS_X_0212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EjercicioStreams {
    public static void main(String[] args) {
        int option = 0;

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

        List<Jugador> lista = new ArrayList<Jugador>();
        lista.add(j11); lista.add(j12); lista.add(j13); lista.add(j14);
        lista.add(j21); lista.add(j22); lista.add(j23); lista.add(j24);

        try {
            while (option != 18) {
                mostrarMenu();
                System.out.println("Elige opcion:");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                option = Integer.parseInt(br.readLine());
                switch (option) {
                    case 1:
                        System.out.println("1. Devolver con una lista  todos los jugadores que hayan obtenido más de 500 canastas.");
                        lista.stream()
                                .filter(jugador -> jugador.getNumCanastas() > 500)
                                .forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("2. Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.");
                        lista.stream()
                                .filter(jugador -> jugador.getNumCanastas() > 200 && jugador.getNumCanastas() < 500)
                                .forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("3. Devolver en una lista exclusivamente los nombres de los jugadores que satisfacen  los requisitos del 2.3.");
                        lista.stream()
                                .filter(jugador -> jugador.getNumCanastas() > 200 && jugador.getNumCanastas() < 500)
                                .map(Jugador::getNombre)
                                .forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("4. Devolver con una lista todos los jugadores ordenados por la fecha de nacimiento.");
                        lista.stream()
                                .sorted(Comparator.comparing(Jugador::getFechaNacimiento))
                                .forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("5. Devolver con una lista todos los jugadores ordenados por número de canastas.");
                        lista.stream()
                                .sorted(Comparator.comparing(Jugador::getNumCanastas))
                                .forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("6. Devolver con una lista con los cinco jugadores que hayan realizado más canastas.");
                        lista.stream()
                                .sorted(Comparator.comparing(Jugador::getNumCanastas))
                                .limit(5)
                                .forEach(System.out::println);
                        break;
                    case 7:
                        System.out.println("7. Devolver con una lista todos los jugadores que satisfacen el punto 2.3 ordenados por la fecha de nacimiento de manera descendente.");
                        lista.stream()
                                .filter(jugador -> jugador.getNumCanastas() > 200 && jugador.getNumCanastas() < 500)
                                .sorted(Comparator.comparing(Jugador::getFechaNacimiento))
                                .forEach(System.out::println);

                        break;
                    case 8:
                        System.out.println("8. Devolver con una lista todos los jugadores que satisfacen el filtro del punto 1.3 ordenados, en primer lugar por número de canastas y en segundo lugar (si tienen el mismo número de canastas) por la fecha de nacimiento.");
                        lista.stream()
                                .filter(jugador -> jugador.getNumCanastas() > 200 && jugador.getNumCanastas() < 500)
                                .sorted(Comparator.comparing(Jugador::getNumCanastas).thenComparing(Jugador::getFechaNacimiento))
                                .forEach(System.out::println);

                        break;
                    case 9:
                        System.out.println("9. Devolver el jugador que ha realizado el mínimo número de canastas.");
                        System.out.println(lista.stream().reduce((x,y) -> x.getNumCanastas() < y.getNumCanastas() ? x : y));

                        break;
                    case 10:
                        System.out.println("10. Devolver el jugador que ha realizado el máximo número de canastas.");
                        System.out.println(lista.stream().reduce((x,y) -> x.getNumCanastas() > y.getNumCanastas() ? x : y));

                        break;
                    case 11:
                        System.out.println("11. Devolver la media de canastas de todos los jugadores.");
                        System.out.println(lista.stream().collect(Collectors.averagingInt(jugador -> jugador.getNumCanastas())));

                        break;
                    case 12:
                        System.out.println("12. Devolver con una lista todos los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.");
                        lista.stream()
                                .filter(jugador -> jugador.getEquipo().getLocalidad().equalsIgnoreCase("barcelona"))
                                .forEach(System.out::println);

                        break;
                    case 13:
                        System.out.println("13. Devolver con un boolean si hay algún jugador que ha conseguido más de 4.000 canastas.");
                        System.out.println(lista.stream().anyMatch(jugador -> jugador.getNumCanastas() > 4000));

                        break;
                    case 14:
                        System.out.println("14. Devolver con un boolean si todos los jugadores han conseguido más de 50 canastas.");
                        System.out.println(lista.stream().allMatch(jugador -> jugador.getNumCanastas() > 50));

                        break;
                    case 15:
                        System.out.println("15. Devolver con un boolean si todos los jugadores del primer equipo añadido han conseguido más de 50 canastas.");
                        System.out.println(lista.stream().filter(jugador -> jugador.getEquipo() == A).allMatch(jugador -> jugador.getNumCanastas() > 50));

                        break;
                    case 16:
                        System.out.println("16. Devolver un Map<String, List<Equipo>> agrupando los equipos que pertenecen a una misma localidad. Hay un ejemplo similar en la página 172 (6.3 Grouping).");
                        Map<String, List<Equipo>> map = lista.stream()
                                .map(Jugador::getEquipo)
                                .collect(Collectors.groupingBy(Equipo::getLocalidad));
                        System.out.println(map);
                        break;
                    case 17:
                        System.out.println("17. Devolver la suma del número de canastas de todos los jugadores. Utilizar la operación Reduce (página 132,  5.4).");
                        System.out.println(lista.stream().map(Jugador::getNumCanastas).reduce(0, (a, b) -> a+b));

                        break;
                    case 18:
                        System.out.println("Has salido.");
                        break;
                    default:
                        System.out.println("Opción incorrecta, de 1 a 18.");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public static void mostrarMenu(){
        System.out.println("1. Devolver con una lista  todos los jugadores que hayan obtenido más de 500 canastas.");
        System.out.println("2. Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.");
        System.out.println("3. Devolver en una lista exclusivamente los nombres de los jugadores que satisfacen  los requisitos del 2.3.");
        System.out.println("4. Devolver con una lista todos los jugadores ordenados por la fecha de nacimiento.");
        System.out.println("5. Devolver con una lista todos los jugadores ordenados por número de canastas.");
        System.out.println("6. Devolver con una lista con los cinco jugadores que hayan realizado más canastas.");
        System.out.println("7. Devolver con una lista todos los jugadores que satisfacen el punto 2.3 ordenados por la fecha de nacimiento de manera descendente.");
        System.out.println("8. Devolver con una lista todos los jugadores que satisfacen el filtro del punto 1.3 ordenados, en primer lugar por número de canastas y en segundo lugar (si tienen el mismo número de canastas) por la fecha de nacimiento.");
        System.out.println("9. Devolver el jugador que ha realizado el mínimo número de canastas.");
        System.out.println("10. Devolver el jugador que ha realizado el máximo número de canastas.");
        System.out.println("11. Devolver la media de canastas de todos los jugadores.");
        System.out.println("12. Devolver con una lista todos los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.");
        System.out.println("13. Devolver con un boolean si hay algún jugador que ha conseguido más de 4.000 canastas.");
        System.out.println("14. Devolver con un boolean si todos los jugadores han conseguido más de 50 canastas.");
        System.out.println("15. Devolver con un boolean si todos los jugadores del primer equipo añadido han conseguido más de 50 canastas.");
        System.out.println("16. Devolver un Map<String, List<Equipo>> agrupando los equipos que pertenecen a una misma localidad. Hay un ejemplo similar en la página 172 (6.3 Grouping).");
        System.out.println("17. Devolver la suma del número de canastas de todos los jugadores. Utilizar la operación Reduce (página 132,  5.4).");
        System.out.println("18. Salir.");
    }
}
