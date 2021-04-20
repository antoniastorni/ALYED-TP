package Arboles;

import java.util.Objects;

public class BinaryTree<T>{
    private DoubleNode<T> root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(T o){
        root = new DoubleNode <T>(o);
    }

    public BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright){
        root = new DoubleNode<T>(o,tleft.root, tright.root);
    }

    //si la root es vacía
    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        return root.dato;
    }

    //ojo que pedís el arbol
    public BinaryTree<T> getLeft() {
        BinaryTree<T> t = new BinaryTree<>();
        t.root = root.left;
        return t;
    }

    public BinaryTree<T> getRight() {
        BinaryTree<T> t = new BinaryTree<>();
        t.root = root.right;
        return t;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        BinaryTree<T> tree = (BinaryTree<T>) o;
        // field comparison
        return Objects.equals(root, tree.root);
    }
}
