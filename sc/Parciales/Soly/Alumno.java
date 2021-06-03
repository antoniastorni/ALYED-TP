package Parciales.Soly;

public class Alumno implements Comparable<Alumno>{
    private final int matricula;
    private int isGrado;  // isGrado = 1 sólo si es de grado / isGrado = 0  sólo si es de postgrado / isGrado = -1 si no es ninguno
    private final int calificacion;

    public Alumno(int matricula, int isGrado, int calificacion) {
        this.matricula = matricula;
        this.isGrado = isGrado;
        this.calificacion = calificacion;
    }

    @Override
    public int compareTo(Alumno o) {
        return Integer.compare(this.matricula, o.matricula);
    }

    public int getCalificacion() {
        return calificacion;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getIsGrado() {
        return isGrado;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula=" + matricula +
                ", isGrado=" + isGrado +
                ", calificacion=" + calificacion +
                '}';
    }
}
