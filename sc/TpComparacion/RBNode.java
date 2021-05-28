package TpComparacion;

public class RBNode<T extends Comparable<T>> {
    T data; // holds the key
    RBNode<T> parent; // pointer to the parent
    RBNode<T> left; // pointer to left child
    RBNode<T> right; // pointer to right child
    int color; // 1 . Red, 0 . Black

    public RBNode() {
        color = 1;
    }

    public RBNode(T data) {
        this.data = data;
        color = 1;
    }

    public RBNode(T data, RBNode<T> left, RBNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        color = 1;
    }


}
