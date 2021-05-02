package Queue;

public class Node<T> {
    private T element;
    private Node pointer;

    Node(T element, Node pointer) {
        this.element = element;
        this.pointer = pointer;
    }

    Node(T element) {
        this.element = element;
        pointer = null;
    }

    public T getElement() {
        return element;
    }

    public Node getPointer() {
        return pointer;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
