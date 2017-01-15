import java.time.LocalDate;

public class Jugador {
    String nombre;
    LocalDate fechaNacimiento;
    int numCanastas;
    Equipo equipo;

    public Jugador(String nombre, LocalDate fechaNacimiento, int numCanastas, Equipo equipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.numCanastas = numCanastas;
        this.equipo = equipo;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}

    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public int getNumCanastas() {return numCanastas;}

    public void setNumCanastas(int numCanastas) {this.numCanastas = numCanastas;}

    public Equipo getEquipo() {return equipo;}

    public void setEquipo(Equipo equipo) {this.equipo = equipo;}

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", numCanastas=" + numCanastas +
                ", equipo=" + equipo +
                '}';
    }
}
