package Arboles;


public class BinaryTree<T>{
     public DoubleNode<T> root;

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

    public void setRoot(DoubleNode<T> root) {
        this.root = root;
    }

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

}
