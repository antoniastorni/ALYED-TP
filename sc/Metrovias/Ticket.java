package Metrovias;

public class Ticket {
    private final int numberOfTicket;
    private final float checkInTime;
    private final float checkOutTime;

    public Ticket(int numberOfTicket, float checkInTime, float checkOutTime) {
        this.numberOfTicket = numberOfTicket;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    public float getCheckInTime() {
        return checkInTime;
    }

    public float getCheckOutTime() {
        return checkOutTime;
    }
}
