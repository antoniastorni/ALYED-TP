package ArbolesBinariosDeBusqueda;

public class ElementdontexistException extends Exception {
    @Override
    public String getMessage() {
        return "El elemento no existe";
    }
}
