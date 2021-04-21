package Arboles;

public class DoubleNode <T>{
    T dato;
    DoubleNode <T> right, left;

    public DoubleNode(T o){
        dato = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        dato = o;
        this.right = right;
        this.left = left;
    }
}

