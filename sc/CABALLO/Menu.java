package CABALLO;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de saltos que se realizarán: ");
        int numberOfJumps = Integer.parseInt(sc.nextLine()); //use of a parseInt due to an input issue using nextInt() before a nextLine()
        System.out.print("\nIngrese una casilla donde comenzar: ");
        String chessBox = sc.nextLine();

        HorseJumps horseMovement = new HorseJumps(numberOfJumps, chessBox.toUpperCase().trim());
        while (true) {
            System.out.println("\n*************************************\n");
            System.out.println("\n• 1: Se procede a realizar el siguiente salto.\n" +
                    "• 2: Mostrar el contenido de las pilas.\n" +
                    "• 3: Salir.\n");
            System.out.println("Ingrese una opción: ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    try {
                        System.out.println("");
                        horseMovement.printPossibleJumps();
                        System.out.println("");
                        System.out.print("Ingrese el salto que desea realizar: ");
                        String nextMove = sc.nextLine();
                        horseMovement.chooseNextJump(nextMove.toUpperCase().trim());
                    } catch (NoMoreAvailableMovementsException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    horseMovement.printAllStacks();
                    break;
                case 3:
                    horseMovement.printAllPaths();
                    System.exit(0);
            }
        }
    }
}
