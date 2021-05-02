package Metrovias;

import QueueAndStack.DynamicStack;
import QueueAndStack.IsEmptyException;

public class Simulation {
    private Window[] windows;
    private DynamicStack<People> attendedPeople;
    private final int numberOfWindows;
    private float currentTimeInSeconds;

    public Simulation(int numberOfWindows) {
        currentTimeInSeconds = 0;
        attendedPeople = new DynamicStack<>();
        windows = new Window[numberOfWindows];
        this.numberOfWindows = numberOfWindows;
        for (int i = 0; i < numberOfWindows; i++) {
            windows[i] = new Window();
        }
    }

    //people arriving to the queue is handled
    public void manageArrivingPeople() {
        currentTimeInSeconds = currentTimeInSeconds + 30;
            for (int i = 0; i < 5; i++) {
                int randomWindowElection = (int) (this.numberOfWindows * Math.random());
                windows[randomWindowElection].addPeople(new People(currentTimeInSeconds));
            }
        }

//quién da el ticket a la persona????

        //people in a window is handled
    public void manageWindowAttention() {
        try {
            for (int i = 0; i < numberOfWindows; i++) {
                if ((int) (100 * Math.random()) < 50) { //50% probability of being attended
                    People peopleOut = windows[i].peopleProceeding(currentTimeInSeconds);
                    int ticketNumberGenerator = (int) (10000 * Math.random()); //maybe could be better
                    peopleOut.giveTicket(new Ticket(ticketNumberGenerator, peopleOut.getInitialTimeInSeconds(), currentTimeInSeconds));
                    attendedPeople.stack(peopleOut);
                }
            }
        } catch (IsEmptyException e) {
            e.getMessage();
        }
    }

    public float[] averageWaitingTime() {
        float[] averageWaitingTimePerWindow = new float[numberOfWindows];
        for (int i = 0; i < numberOfWindows; i++) {
            averageWaitingTimePerWindow[i] = windows[i].getSumOfDeltaPeopleTimeInSeconds() / windows[i].getNumberOfPeopleProceeded();
        }
        return averageWaitingTimePerWindow;
    }

    public float[] raisedMoney() {
        float[] totalRaisedMoneyPerWindow = new float[numberOfWindows];
        for (int i = 0; i < numberOfWindows; i++) {
            totalRaisedMoneyPerWindow[i] = windows[i].getRaisedMoney();
        }
        return totalRaisedMoneyPerWindow;
    }

    public DynamicStack<People> attendedPeople() {
        return attendedPeople;
    }
}