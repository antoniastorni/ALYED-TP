package TpComparacion;

public class RBTree<T> {

    private RBNodoDoble<T> root;
    RBNodoDoble<T> nullNode;
    RBNodoDoble<T> header;
    private static final int BLACK = 1; // BLACK must be 1
    private static final int RED = 0;
    private RBNodoDoble<T> current;
    private RBNodoDoble<T> parent;
    private RBNodoDoble<T> grand;
    private RBNodoDoble<T> great;
    private Integer contadorDeBusqueda;

    public RBTree() {
        root = null;
        nullNode = new RBNodoDoble<>(null);
        nullNode.izq = nullNode.der = nullNode;
        header = new RBNodoDoble<>( null );
        header.izq = header.der = nullNode;
        contadorDeBusqueda = 0;
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable<T> x) throws ElementBelongsToTreeException {
        if (exists(x)) {
            throw new ElementBelongsToTreeException();
        }
        root = insert(root, x);
    }

    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable<T> x) throws ElementdontexistException {
        if (!exists(x)) {
            throw new ElementdontexistException();
        }
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        return getMin(root).elem;
    }

    // precondicion: árbol distinto de vacío
    public T getMax() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        return getMax(root).elem;
    }

    // precondicion: elemnto a buscar pertenece al arbol
    public T search(Comparable<T> x) throws ElementBelongsToTreeException {
        if (!exists(x)) {
            throw new ElementBelongsToTreeException();
        }
        return search(root, x).elem;
    }

    // precondicion: -
    public boolean exists(Comparable<T> x) {
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty() {
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        return root.elem;
    }

    // precondición: árbol distino de vacío
    public RBTree<T> getLeft() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        RBTree<T> t = new RBTree<T>();
        t.root = root.izq;
        return t;
    }

    // precondición: árbol distino de vacío
    public RBTree<T> getRight() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        RBTree<T> t = new RBTree<T>();
        t.root = root.der;
        return t;
    }


    // METODOS PRIVADOS
    private RBNodoDoble<T> getMax(RBNodoDoble<T> t) {
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }

    private RBNodoDoble<T> getMin(RBNodoDoble<T> t) {
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }

    private RBNodoDoble<T> search(RBNodoDoble<T> t, Comparable<T> x) {
        contadorDeBusqueda++;
        if (x.compareTo(t.elem) == 0)
            return t;
        else if (x.compareTo(t.elem) < 0)
            return search(t.izq, x);
        else
            return search(t.der, x);
    }

    private boolean exists(RBNodoDoble<T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo(t.elem) < 0)
            return exists(t.izq, x);
        else
            return exists(t.der, x);
    }


    private RBNodoDoble<T> insert(RBNodoDoble<T> t, Comparable<T> x) {
        if (t == null) {
            t = new RBNodoDoble<T>();
            t.elem = (T) x;

        } else if (x.compareTo(t.elem) < 0)
            t.izq = insert(t.izq, x);
        else
            t.der = insert(t.der, x);
        return t;
    }

    public void insert(Comparable<T> item) {
        current = parent = grand = header;
        nullNode.elem = (T)item;  //verificar esto
        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare(item, current) < 0 ? current.izq : current.der;
// Check if two red children; fix if so
            if (current.izq.color == RED && current.der.color == RED)
                handleReorient(item);
        }
        // Insertion fails if already present
        if (current != nullNode)
            return;
        current = new RBNodoDoble<>(item, nullNode, nullNode);

        // Attach to parent
        if (compare(item, parent) < 0)
            parent.izq = current;
        else
            parent.der = current;
        handleReorient(item);
    }

    private RBNodoDoble<T> delete(RBNodoDoble<T> t, Comparable<T> x) {
        if (x.compareTo(t.elem) < 0)
            t.izq = delete(t.izq, x);
        else if (x.compareTo(t.elem) > 0)
            t.der = delete(t.der, x);
        else if (t.izq != null && t.der != null) {
            t.elem = getMin(t.der).elem;
            t.der = deleteMin(t.der);
        } else if (t.izq != null)
            t = t.izq;
        else
            t = t.der;
        return t;
    }

    private RBNodoDoble<T> deleteMin(RBNodoDoble<T> t) {
        if (t.izq != null)
            t.izq = deleteMin(t.izq);
        else
            t = t.der;
        return t;
    }

    private RBNodoDoble<T> rotate(Comparable<T> item, RBNodoDoble<T> parent ) {
        if (compare(item, parent) < 0) {
            return parent.izq = compare(item, parent.izq) < 0 ? rotateWithLeftChild(parent.izq) : rotateWithRightChild(parent.izq);
        } else {
            return parent.der = compare(item, parent.der) < 0 ? rotateWithLeftChild(parent.der) : rotateWithRightChild(parent.der);
        }
    }
    private final int compare( Comparable<T> item, RBNodoDoble<T> t ) {
        if (t == header) {
            return 1;
        } else {
            return item.compareTo(t.elem);
        }
    }

    private void handleReorient(Comparable<T> item) {
        // Do the color flip
        current.color = RED;
        current.izq.color = BLACK;
        current.der.color = BLACK;

        if( parent.color == RED ) // Have to rotate{
            grand.color = RED;
        if( ( compare( item, grand ) < 0 ) != ( compare( item, parent )<0)) {
            parent = rotate( item, grand ); // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.der.color = BLACK; // Make root black
        }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     */
    private RBNodoDoble<T> rotateWithLeftChild(RBNodoDoble<T> k2) {
        RBNodoDoble<T> k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */

    private RBNodoDoble<T> rotateWithRightChild(RBNodoDoble<T> k1) {
        RBNodoDoble<T> k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     */
    private RBNodoDoble<T> doubleWithLeftChild(RBNodoDoble<T> k3) {
        k3.izq = rotateWithRightChild(k3.der);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     */

    private RBNodoDoble<T> doubleWithRightChild(RBNodoDoble<T> k1) {
        k1.der = rotateWithLeftChild(k1.der);
        return rotateWithRightChild(k1);
    }

    public Integer getContadorDeBusqueda() {
        return contadorDeBusqueda;
    }

    public int altura(RBTree a) {
        if(a.isEmpty())
            return -1;
        return altura(a.root);
    }
    private int altura (RBNodoDoble a) {
        if (a == null)
            return 0;
        return 1 + ((altura(a.der) < altura(a.izq)) ? altura(a.izq) : altura(a.der));
    }
}