package TpComparacion;

public class RedBlackTree<T extends Comparable<T>> {
    private RBNode<T> root;
    private RBNode<T> TNULL;
    private int contadorDeBusqueda;

    private void preOrderHelper(RBNode<T> node) {
        if (node != TNULL) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    private void inOrderHelper(RBNode<T> node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    private void postOrderHelper(RBNode<T> node) {
        if (node != TNULL) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    private RBNode<T> searchTreeHelper(RBNode<T> node, T key) {
        if (node == TNULL || key == node.data) {
            return node;
        }
        contadorDeBusqueda++;
        if (key.compareTo(node.data) > 0) {     //c
            return searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }

    // fix the rb tree modified by the delete operation
    private void fixDelete(RBNode<T> x) {
        RBNode<T> s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    // case 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    // case 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        // case 3.3
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    // case 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    // case 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        // case 3.3
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }


    private void rbTransplant(RBNode<T> u, RBNode<T> v){
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private void deleteNodeHelper(RBNode<T> node, T key) throws TreeIsEmptyException {
        // find the node containing key
        RBNode<T> z = TNULL;
        RBNode<T> x, y;
        while (node != TNULL){
            if (node.data == key) {
                z = node;
            }

            if (node.data.compareTo(key) > 0) {     //c
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (z == TNULL) {
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = z;
        int yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0){
            fixDelete(x);
        }
    }

    // fix the red-black tree
    private void fixInsert(RBNode<T> k){
        RBNode<T> u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u.color == 1) {
                    // case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // case 3.2.2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u.color == 1) {
                    // mirror case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // mirror case 3.2.2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // mirror case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    private void printHelper(RBNode<T> root, String indent, boolean last) {
        // print the tree structure on the screen
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            String sColor = root.color == 1?"RED":"BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public RedBlackTree() {
        TNULL = new RBNode<>();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
        contadorDeBusqueda = 0;
    }

    // Pre-Order traversal
    // Node.Left Subtree.Right Subtree
    public void preorder() {
        preOrderHelper(this.root);
    }

    // In-Order traversal
    // Left Subtree . Node . Right Subtree
    public void inorder() {
        inOrderHelper(this.root);
    }

    // Post-Order traversal
    // Left Subtree . Right Subtree . Node
    public void postorder() {
        postOrderHelper(this.root);
    }

    // search the tree for the key k
    // and return the corresponding node
    public RBNode<T> searchTree(T k) throws ElementBelongsToTreeException {
        if(!exists(k)) throw new ElementBelongsToTreeException();
        return searchTreeHelper(this.root, k);
    }

    // find the node with the minimum key
    public RBNode<T> minimum(RBNode<T> node) throws TreeIsEmptyException {
        if(isEmpty()) throw new TreeIsEmptyException();
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    // find the node with the maximum key
    public RBNode<T> maximum(RBNode<T> node) throws TreeIsEmptyException {
        if(isEmpty()) throw new TreeIsEmptyException();
        while (node.right != TNULL) {
            node = node.right;
        }
        return node;
    }

    // find the successor of a given node
    public RBNode<T> successor(RBNode<T> x) throws TreeIsEmptyException {
        // if the right subtree is not null,
        // the successor is the leftmost node in the
        // right subtree
        if (x.right != TNULL) {
            return minimum(x.right);
        }

        // else it is the lowest ancestor of x whose
        // left child is also an ancestor of x.
        RBNode<T> y = x.parent;
        while (y != TNULL && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // find the predecessor of a given node
    public RBNode<T> predecessor(RBNode<T> x) throws TreeIsEmptyException {
        // if the left subtree is not null,
        // the predecessor is the rightmost node in the
        // left subtree
        if (x.left != TNULL) {
            return maximum(x.left);
        }

        RBNode<T> y = x.parent;
        while (y != TNULL && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    // rotate left at node x
    public void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    public void rightRotate(RBNode<T> x) {
        RBNode<T> y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // insert the key to the tree in its appropriate position
    // and fix the tree
    public void insert(T key) throws ElementBelongsToTreeException {
        if(exists(key)) throw new ElementBelongsToTreeException();
        // Ordinary Binary Search Insertion
        RBNode<T> node = new RBNode<>();
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // new node must be red

        RBNode<T> y = null;
        RBNode<T> x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data.compareTo(x.data) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y is parent of x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data.compareTo(y.data) < 0) {   //c
            y.left = node;
        } else {
            y.right = node;
        }

        // if new node is a root node, simply return
        if (node.parent == null){
            node.color = 0;
            return;
        }

        // if the grandparent is null, simply return
        if (node.parent.parent == null) {
            return;
        }

        // Fix the tree
        fixInsert(node);
    }

    public RBNode<T> getRoot(){
        return this.root;
    }

    // delete the node from the tree
    public void deleteNode(T data) throws ElementdontexistException, TreeIsEmptyException {
        if(!exists(data)) throw new ElementdontexistException();
        deleteNodeHelper(this.root, data);
    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

    public boolean exists(T x) {
        return exists(root, x);
    }

    private boolean exists(RBNode<T> t, T x) {
        if (t == null)
            return false;
        if(t.data == null)
            return false;
        if (x.compareTo(t.data) == 0)
            return true;
        else if (x.compareTo(t.data) < 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }
    public int altura(RedBlackTree<T> a) {
        if(a.root == null)
            return -1;
        return altura(a.root);
    }
    private int altura(RBNode<T> a) {
        if (a == null)
            return 0;
        return 1 + (Math.max(altura(a.right), altura(a.left)));
    }

    public boolean isEmpty() {
        return root == null;
    }

    public RedBlackTree<T> getLeft() throws TreeIsEmptyException {
        if(isEmpty()) throw new TreeIsEmptyException();
        RedBlackTree<T> t = new RedBlackTree<>();
        t.root = root.left;
        return t;
    }

    public RedBlackTree<T> getRight() throws TreeIsEmptyException {
        if(isEmpty()) throw new TreeIsEmptyException();
        RedBlackTree<T> t = new RedBlackTree<>();
        t.root = root.right;
        return t;
    }

    public int getContadorDeBusqueda() {
        return contadorDeBusqueda;
    }
}
