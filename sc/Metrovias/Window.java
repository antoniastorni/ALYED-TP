package Metrovias;

import QueueAndStack.DynamicQueue;
import QueueAndStack.IsEmptyException;

public class Window {
    private DynamicQueue<People> waitingQueue;
    private float raisedMoney;
    private int numberOfPeopleProceeded;
    private float sumOfDeltaPeopleTimeInSeconds;

    public Window() {
        waitingQueue = new DynamicQueue<>();
        raisedMoney = 0;
        numberOfPeopleProceeded = 0;
        sumOfDeltaPeopleTimeInSeconds = 0;
    }

    public void addPeople(People people) {
        waitingQueue.enqueue(people);
        //manage times?
    }

    //according to current time, people is attended by the window
    public People peopleProceeding(float currentTimeInSeconds) throws IsEmptyException {
        People people = (People)waitingQueue.dequeue();
        numberOfPeopleProceeded++;
        raisedMoney = raisedMoney + 10;
        sumOfDeltaPeopleTimeInSeconds = sumOfDeltaPeopleTimeInSeconds + people.getDeltaOfTime(currentTimeInSeconds);
        return people;
    }

    public float getSumOfDeltaPeopleTimeInSeconds() {
        return sumOfDeltaPeopleTimeInSeconds;
    }

    public float getRaisedMoney() {
        return raisedMoney;
    }

    public int getNumberOfPeopleProceeded() {
        return numberOfPeopleProceeded;
    }
}

