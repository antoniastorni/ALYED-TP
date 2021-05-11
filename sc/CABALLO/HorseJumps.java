package CABALLO;

public class HorseJumps {
    private String[][] chessTable = new String[][]{
            {"A1","B1","C1","D1","E1","F1","G1","H1"},
            {"A2","B2","C2","D2","E2","F2","G2","H2"},
            {"A3","B3","C3","D3","E3","F3","G3","H3"},
            {"A4","B4","C4","D4","E4","F4","G4","H4"},
            {"A5","B5","C5","D5","E5","F5","G5","H5"},
            {"A6","B6","C6","D6","E6","F6","G6","H6"},
            {"A7","B7","C7","D7","E7","F7","G7","H7"},
            {"A8","B8","C8","D8","E8","F8","G8","H8"}
    };
    private int numberOfJumps;
    private DynamicStack<String>[] stacksOfJumps;
    private String currentPosition;
    private String initialPosition;
    private int initialNumberOfJumps;
    private int indexOfStackOfJumps;

    HorseJumps(int numberOfJumps) {
        this.numberOfJumps = numberOfJumps;
        stacksOfJumps = new DynamicStack[initialNumberOfJumps];
        currentPosition = "A1";
        initialPosition = "A1";
        initialNumberOfJumps = numberOfJumps;
    }

    HorseJumps(int numberOfJumps, String initialPosition) {
        this.numberOfJumps = numberOfJumps;
        stacksOfJumps = new DynamicStack[initialNumberOfJumps];
        currentPosition = initialPosition;
        this.initialPosition = initialPosition;
        initialNumberOfJumps = numberOfJumps;
    }

    public void chooseNextJump(String selectedBox) {
        currentPosition = selectedBox;
        numberOfJumps--;
    }

    //prints possible movements
    public void printPossibleJumps() throws NoMoreAvailableMovementsException{
        if (numberOfJumps > 0) {
            stacksOfJumps[indexOfStackOfJumps] = new DynamicStack<>();
            analizingPossibleJumps(getIndexOfRow(currentPosition), getIndexOfColumn(currentPosition), stacksOfJumps);
            indexOfStackOfJumps++;
        } else {
            throw new NoMoreAvailableMovementsException();
        }
    }


    private void analizingPossibleJumps(int currentIndexRow, int currentIndexColumn, DynamicStack<String>[] stack) {
        if ((currentIndexRow - 1 >= 0 && currentIndexRow - 1 < 9) && (currentIndexColumn + 2 > 0 && currentIndexColumn + 2 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow - 1, currentIndexColumn + 2), stack);
        }

        if ((currentIndexRow + 1 >= 0 && currentIndexRow + 1 < 9) && (currentIndexColumn + 2 > 0 && currentIndexColumn + 2 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow + 1, currentIndexColumn + 2), stack);
        }

        if ((currentIndexRow + 1 > 0 && currentIndexRow + 1 < 9) && (currentIndexColumn - 2 > 0 && currentIndexColumn - 2 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow + 1, currentIndexColumn - 2), stack);
        }
        if ((currentIndexRow - 1 > 0 && currentIndexRow - 1 < 9) && (currentIndexColumn - 2 > 0 && currentIndexColumn - 2 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow - 1, currentIndexColumn - 2), stack);
        }

        if ((currentIndexRow + 2 > 0 && currentIndexRow + 2 < 9) && (currentIndexColumn - 1 > 0 && currentIndexColumn - 1 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow + 2, currentIndexColumn - 1), stack);
        }

        if ((currentIndexRow - 2 > 0 && currentIndexRow - 2 < 9) && (currentIndexColumn - 1 > 0 && currentIndexColumn - 1 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow - 2, currentIndexColumn - 1), stack);
        }
        if ((currentIndexRow + 2 > 0 && currentIndexRow + 2 < 9) && (currentIndexColumn + 1 > 0 && currentIndexColumn + 1 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow + 2, currentIndexColumn + 1), stack);
        }
        if ((currentIndexRow - 2 > 0 && currentIndexRow - 2 < 9) && (currentIndexColumn + 1 > 0 && currentIndexColumn + 1 < 9)) {
            savingJumpInStack(getBoxName(currentIndexRow - 2, currentIndexColumn + 1), stack);
        }
    }

    //fills current stack with possible jumps in a movement
    private void savingJumpInStack(String box, DynamicStack<String>[] stack){
        stack[indexOfStackOfJumps].stack(box);
        System.out.println(box);
    }

    //returns index of row filA. ex. "B5" returns 5
    private int getIndexOfRow(String position) {
        return Integer.parseInt(String.valueOf(position.charAt(1)))-1;
    }

    //returns index of column. ex. "B5" returns 1
    private int getIndexOfColumn(String position) {
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                if(chessTable[i][j].equals(position))
                    return j;
            }
        }
        return -1;
    }

    //returns box name ej. (1,2) returns "C2"
    private String getBoxName(int currentIndexRow, int currentIndexColumn) {
        return chessTable[currentIndexRow][currentIndexColumn];
    }

    //prints all stacks
    public void printAllStacks() {
        int auxiliarNumberOfStack2 = 1;
        DynamicStack<String>[] auxiliarStack;
        auxiliarStack = stacksOfJumps;
        int index = 0;
        System.out.println("Imprimiendo todas las pilas: ");
        try {
            while (index < auxiliarStack.length && auxiliarNumberOfStack2 <= initialNumberOfJumps) {
                System.out.println("**************************");
                System.out.println("Pila" + auxiliarNumberOfStack2 + ": ");
                while (!auxiliarStack[index].isEmpty()) {
                    System.out.println(auxiliarStack[index].peek());
                    auxiliarStack[index].pop();
                }
                index++;
                auxiliarNumberOfStack2++;

            }
        } catch (IsEmptyException e) {
            e.getMessage();
        }
    }

    //tengo las variables initialNumberOfJumps e initialPosition
    public void printAllPosiblePaths() {
        DynamicStack<String>[] allPaths = new DynamicStack[initialNumberOfJumps];
        for (int i = 0; i < initialNumberOfJumps; i++) {
            allPaths[i] = new DynamicStack<>();
        }
        analizingPossibleJumps(getIndexOfRow(initialPosition), getIndexOfColumn(initialPosition),allPaths);
    }
}
