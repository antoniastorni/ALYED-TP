package CABALLO;

public class NoMoreAvailableMovementsException extends Exception{

    @Override
    public String getMessage() {
        return "No more available movements.";
    }
}
