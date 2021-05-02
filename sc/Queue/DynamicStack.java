package Queue;

public class DynamicStack<T> implements StackInterface<T>{
    private int size;
    private Node<T> node;

    public DynamicStack() {
        node = new Node<T>(null);
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0 && node.getPointer() == null;
    }

    @Override //ver
    public T peek() {
        if(isEmpty())
            return null;
        return (T) node.getPointer().getElement();
    }

    @Override //eliminar
    public void pop() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        }
        size--;
        Node<T> auxiliar = node.getPointer().getPointer();
        node.setPointer(auxiliar);
    }

    @Override //agregar
    public void stack(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.setPointer(node.getPointer());
        node.setPointer(newNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        node.setPointer(null);
        node.setElement(null);
        size = 0;
    }
}
