package Metrovias;

public class People {
    private Ticket ticket;
    private float initialTimeInSeconds;

    public People(float initialTimeInSeconds) {
        ticket = null;
        this.initialTimeInSeconds = initialTimeInSeconds;
    }

    public float getDeltaOfTime(float finalTimeInSeconds) {
        return finalTimeInSeconds - initialTimeInSeconds;
    }

    public float getInitialTimeInSeconds() {
        return initialTimeInSeconds;
    }

    public void giveTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}