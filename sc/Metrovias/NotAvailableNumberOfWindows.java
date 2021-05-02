package Metrovias;

public class NotAvailableNumberOfWindows extends Exception{
    @Override
    public String getMessage() {
        return "Number of windows not allowed. Please, enter a valid number.";
    }
}

