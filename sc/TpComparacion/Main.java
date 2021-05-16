package TpComparacion;

public class Main {
    public static void main(String[] args) throws ElementBelongsToTreeException {
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
    }

}
