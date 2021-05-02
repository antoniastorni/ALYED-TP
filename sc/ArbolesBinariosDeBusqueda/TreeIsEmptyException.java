package ArbolesBinariosDeBusqueda;

public class TreeIsEmptyException extends Exception {
    @Override
    public String getMessage() {
        return "El arbol esta vacio";
    }
}
