package QueueAndStack;

public class DynamicQueue<T> implements QueueInterface<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;
//acá sí se empieza con un nodo vacío eh
    public DynamicQueue() {
        first = new Node<T>(null);
        last = new Node<T>(null);
        size = 0;
    }

    //entra al final
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);
        if(isEmpty()) {
            first.setPointer(newNode);
            last.setPointer(newNode);
        } else {
            last.getPointer().setPointer(newNode);
            last.setPointer(newNode);
        }
        size++;
    }

    //sale el primero
    public T dequeue() throws IsEmptyException {
        if(isEmpty()) {
            throw new IsEmptyException();
        }
        size--;
        Node<T> toReturn = first.getPointer();
        first.setPointer(toReturn.getPointer());
        return (T) toReturn.getElement();
    }


    public boolean isEmpty() {
        return size == 0 && first.getPointer() == null;
    }


    public int size() {
        return size;
    }

    public T peek(){
        return (T)first.getPointer().getElement();
    }
}
