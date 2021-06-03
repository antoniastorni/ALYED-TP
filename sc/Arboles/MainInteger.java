package Arboles;

public class MainInteger {
    public static void main(String[] args) {
        BinaryTree<Integer> h2 = new BinaryTree<>(2);
        BinaryTree<Integer> h1 = new BinaryTree<>(1);
        BinaryTree<Integer> h14 = new BinaryTree<>(14);
        BinaryTree<Integer> h3 = new BinaryTree<>(3, h2, new BinaryTree<>());
        BinaryTree<Integer> h9 = new BinaryTree<>(9, h14, h1);
        BinaryTree<Integer> q8 = new BinaryTree<>(8, h3, h9);
        BinaryTreeAPI<Integer> api = new BinaryTreeAPI<>();
        api.isomorfoSuma(q8);

    }
}
