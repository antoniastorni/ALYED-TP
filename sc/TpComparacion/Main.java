package TpComparacion;

public class Main {
    public static void main(String[] args) throws ElementBelongsToTreeException {
        long iniciomilis = System.currentTimeMillis();
        int[] randomNumbers = new int[1000];
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AVLTree<Integer> avl = new AVLTree<>();
        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] =  (int) (Math.random() * 100000 + Math.random() * 1000 + Math.random() * 10);
            bst.insert(randomNumbers[i]);
            avl.insert(randomNumbers[i]);
            rb.insert(randomNumbers[i]);
        }

        long finalmilis = System.currentTimeMillis();
        System.out.println("Tardo en crearse:" + (finalmilis-iniciomilis) + "milisegundos");




        //d
        int[] toSearch = new int[10];
        int j = 0;
        for (int i = 0; i < toSearch.length; i++) {
                toSearch[i] = j;
                j =+ 100;
            }

        for (int i = 0; i < toSearch.length; i++) {
            bst.search(toSearch[i]);
            avl.search(toSearch[i]);
            rb.search(toSearch[i]);
            System.out.println("To search: " + toSearch[i]);
            System.out.println("Binary Search Tree: " + bst.getContadorDeBusqueda());
            System.out.println("AVL Tree: " + avl.getContadorDeBusqueda());
            System.out.println("Red Black Tree: " + rb.getContadorDeBusqueda());

        }
        }
    }

}
