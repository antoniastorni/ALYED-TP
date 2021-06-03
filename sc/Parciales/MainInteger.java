package Parciales;

import Arboles.BinaryTree;
import Arboles.DoubleNode;

public class MainInteger {
    public static void main(String[] args) {
        DoubleNode<Integer> lefty = new DoubleNode<>(3);
        DoubleNode<Integer> righty = new DoubleNode<>(9);
        lefty.left = new DoubleNode<>(2);
        righty.left = new DoubleNode<>(14);
        righty.right = new DoubleNode<>(1);
        BinaryTree<Integer> tree = new BinaryTree<>(8);
        tree.root.left = lefty;
        tree.root.right = righty;

        BinaryTree<Integer> tree2 = isomorfoArbol(tree);
        inorden(tree2);
    }


    private static int suma(BinaryTree<Integer> a) {
        if(a.isEmpty()) return 0;
        if(a.getRoot() % 2 != 0) {
            return suma(a.getRight()) + suma(a.getLeft());
        }
        return a.getRoot() + suma(a.getRight()) + suma(a.getLeft());
    }

    public static BinaryTree<Integer> isomorfoArbol(BinaryTree<Integer> a) {
        if(a.isEmpty()) return new BinaryTree<>();
        return new BinaryTree<>(suma(a), isomorfoArbol(a.getLeft()), isomorfoArbol(a.getRight()));
    }

    public static void inorden (BinaryTree<Integer> a) {
        if (!a.isEmpty()){
            inorden(a.getLeft());
            System.out.print(" - " + a.getRoot());
            inorden(a.getRight());
        }
    }

}
