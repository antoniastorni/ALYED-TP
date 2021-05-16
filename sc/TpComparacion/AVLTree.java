package TpComparacion;

public class AVLTree<T> {

    private AVLNodoDoble<T> root;

    public AVLTree() {
        root = null;
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
    public AVLTree<T> getLeft() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        AVLTree<T> t = new AVLTree<T>();
        t.root = root.izq;
        return t;
    }

    // precondición: árbol distino de vacío
    public AVLTree<T> getRight() throws TreeIsEmptyException {
        if (isEmpty()) {
            throw new TreeIsEmptyException();
        }
        AVLTree<T> t = new AVLTree<T>();
        t.root = root.der;
        return t;
    }


    // METODOS PRIVADOS
    private AVLNodoDoble<T> getMax(AVLNodoDoble<T> t) {
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }

    private AVLNodoDoble<T> getMin(AVLNodoDoble<T> t) {
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }

    private AVLNodoDoble<T> search(AVLNodoDoble<T> t, Comparable<T> x) {
        if (x.compareTo(t.elem) == 0)
            return t;
        else if (x.compareTo(t.elem) < 0)
            return search(t.izq, x);
        else
            return search(t.der, x);
    }

    private boolean exists(AVLNodoDoble<T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo(t.elem) < 0)
            return exists(t.izq, x);
        else
            return exists(t.der, x);
    }


    private AVLNodoDoble<T> insert(AVLNodoDoble<T> t, Comparable<T> x) {
        if (t == null) {
            t = new AVLNodoDoble<T>();
            t.elem = (T) x;

        } else if (x.compareTo(t.elem) < 0)
            t.izq = insert(t.izq, x);
        else
            t.der = insert(t.der, x);
        return balance(t);
    }


    private AVLNodoDoble<T> delete(AVLNodoDoble<T> t, Comparable<T> x) {
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

    private AVLNodoDoble<T> deleteMin(AVLNodoDoble<T> t) {
        if (t.izq != null)
            t.izq = deleteMin(t.izq);
        else
            t = t.der;
        return t;
    }
/**
 2 * Return the height of node t, or -1, if null.
 3 */
    private int height( AVLNodoDoble<T> t ) {
        return t == null ? -1 : t.height;
    }

    private AVLNodoDoble<T> balance(AVLNodoDoble<T> t) {
        if (t == null)
            return t;
        if (height(t.izq) - height(t.der) > 1) {
            if (height(t.izq.izq) >= height(t.izq.der)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        }else if (height(t.der) - height(t.izq) > 1) {
            if (height(t.der.der) >= height(t.der.izq)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.izq), height(t.der)) + 1;
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     */
    private AVLNodoDoble<T> rotateWithLeftChild(AVLNodoDoble<T> k2) {
        AVLNodoDoble<T> k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */

    private AVLNodoDoble<T> rotateWithRightChild(AVLNodoDoble<T> k1) {
        AVLNodoDoble<T> k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     */
    private AVLNodoDoble<T> doubleWithLeftChild(AVLNodoDoble<T> k3) {
        k3.izq = rotateWithRightChild(k3.der);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     */

    private AVLNodoDoble<T> doubleWithRightChild(AVLNodoDoble<T> k1) {
        k1.der = rotateWithLeftChild(k1.der);
        return rotateWithRightChild(k1);
    }
}