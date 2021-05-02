package Metrovias;

import Algoritmos.PilasYColas.StackInterface;

import java.util.Scanner;

public class Menu {

    public static void main (String [] Args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWindows;
        do {
            System.out.println("Enter number of windows (between 5 and 25):");
            numberOfWindows = sc.nextInt();
        } while (numberOfWindows < 5 || numberOfWindows > 25);
        sc.nextLine(); // para equilibrar el error de nextInt
        Simulation newSimulation =new Simulation(numberOfWindows);
        int option;
        while(true) {
            do {
                System.out.println("\n**************************\n\n" +
                        "1. Continue simulation with another 30 seconds\n" +
                        "2. Finish simulation\n" +
                        "\n Please choose an option:");
                option = sc.nextInt();
                sc.nextLine(); // para equilibrar el error de nextInt
            } while (option != 1 && option != 2);
            switch (option) {
                case 1 -> {
                    newSimulation.manageArrivingPeople();
                    newSimulation.manageWindowAttention();
                }
                case 2 -> {
                    float[] averageWaitingTimePerWindow  = newSimulation.averageWaitingTime();
                    float[] totalRaisedMoneyPerWindow = newSimulation.raisedMoney();
                    PrintStack(newSimulation.attendedPeople());
                    System.exit(0);
                }
            }
        }
    }
    public static void PrintStack(StackInterface stack) {}
}
