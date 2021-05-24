package TpComparacion;

public class Main {
    public static void main(String[] args) throws ElementBelongsToTreeException {
        long iniciomilis = System.currentTimeMillis();
        int[] randomNumbers = new int[1000];
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AVLTree<Integer> avl = new AVLTree<>();
        RBTree<Integer> rb = new RBTree<>();
        RedBlackTree rb2 = new RedBlackTree();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] =  (int) (Math.random() * 100000 + Math.random() * 1000 + Math.random() * 10);
            if(!(bst.exists(randomNumbers[i]) | rb2.exists(randomNumbers[i]) | avl.exists(randomNumbers[i]))) {
                bst.insert(randomNumbers[i]);

                rb2.insert(randomNumbers[i]); //no funciona
                avl.insert(randomNumbers[i]);
            } else {
                i--;
            }
        }


//crear los arboles por separado
        long finalmilis = System.currentTimeMillis();
        System.out.println("Tardo en crearse:" + (finalmilis-iniciomilis) + "milisegundos");

        System.out.println("Altura de binary search tree: " + bst.altura(bst));
        System.out.println("Altura de Red black tree: " + rb2.altura(rb2));
        System.out.println("Altura de AVL tree: " + avl.altura(avl));

        //d
        int[] toSearch = new int[10];
        int j = 0;
        for (int i = 0; i < toSearch.length; i++) {
            toSearch[i] = randomNumbers[j];
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
            System.out.println("");
        }
    }
}

//RBTree no inserta bien
//RedBlackTree está bien
//AVLTree tiene una altura dudosa