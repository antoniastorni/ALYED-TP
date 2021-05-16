package TpComparacion;

public class ElementBelongsToTreeException extends Exception {
    @Override
    public String getMessage() {
        return "Ya esta este valor en este arbol";
    }
}
