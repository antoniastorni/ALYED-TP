package TpComparacion;

public class Main {
    public static void main(String[] args) throws ElementBelongsToTreeException {
        int[] randomNumbers = new int[1000];
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AVLTree<Integer> avl = new AVLTree<>();
        RedBlackTree<Integer> rb = new RedBlackTree<>();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 100000 + Math.random() * 1000 + Math.random() * 10);
            if(numberAlreadyExists(randomNumbers, i)) {
                i--;
            }
        }
        long initialMinBST = System.currentTimeMillis();
        for (int i = 0; i < randomNumbers.length; i++) {
            bst.insert(randomNumbers[i]);
        }
        long finalmilisBST = System.currentTimeMillis();

        long initialMinAVL = System.currentTimeMillis();
        for (int i = 0; i < randomNumbers.length; i++) {
            avl.insert(randomNumbers[i]);
        }
        long finalmilisAVL = System.currentTimeMillis();

        long initialMinRB = System.currentTimeMillis();
        for (int i = 0; i < randomNumbers.length; i++) {
            rb.insert(randomNumbers[i]);
        }
        long finalmilisRB = System.currentTimeMillis();

//crear los arboles por separado
        System.out.println("BST tardo en crearse: " + (finalmilisBST-initialMinBST) + " milisegundos");
        System.out.println("AVL tardo en crearse: " + (finalmilisAVL-initialMinAVL) + " milisegundos");
        System.out.println("RB tardo en crearse: " + (finalmilisRB-initialMinRB) + " milisegundos");
        System.out.println("");
        System.out.println("Altura de binary search tree: " + bst.altura(bst));
        System.out.println("Altura de AVL tree: " + avl.altura(avl));
        System.out.println("Altura de Red black tree: " + rb.altura(rb));
        System.out.println("");
        //d
        int[] toSearch = new int[10];
        int j = 0;
        for (int i = 0; i < toSearch.length; i++) {
            toSearch[i] = randomNumbers[j];
            j = j + 100;
        }

        for (int i = 0; i < toSearch.length; i++) {
            bst.search(toSearch[i]);
            avl.search(toSearch[i]);
            rb.searchTree(toSearch[i]);
            System.out.println("To search: " + toSearch[i]);
            System.out.println("Binary Search Tree: " + bst.getContadorDeBusqueda());
            System.out.println("AVL Tree: " + avl.getContadorDeBusqueda());
            System.out.println("Red Black Tree: " + rb.getContadorDeBusqueda());
            System.out.println("");
        }
    }

    private static boolean numberAlreadyExists(int[] randomNumbers, int i) {
        for (int j = 0; j < i; j++) {
            if(randomNumbers[j] == randomNumbers[i]) return true;
        }
        return false;
    }
}