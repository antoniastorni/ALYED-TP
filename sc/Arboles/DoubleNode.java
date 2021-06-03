package Arboles;



public class DoubleNode <T>{
    public T dato;
    public DoubleNode <T> right, left;

    public DoubleNode(T o){
        dato = o;
        right = null;
        left = null;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        dato = o;
        this.right = right;
        this.left = left;
    }

}

