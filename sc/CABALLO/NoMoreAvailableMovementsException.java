package CABALLO;

public class NoMoreAvailableMovementsException extends Exception{

    NoMoreAvailableMovementsException() {
        super("No more available movements!");
    }
}
