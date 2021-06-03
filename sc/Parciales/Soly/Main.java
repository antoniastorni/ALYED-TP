package Parciales.Soly;

import Arboles.BinaryTree;
import Arboles.DoubleNode;
import ArbolesBinariosDeBusqueda.BinarySearchTree;
import TpComparacion.ElementBelongsToTreeException;
import TpComparacion.TreeIsEmptyException;


public class Main {
    public static void main(String[] args) {
        DoubleNode<Alumno> tleft = new DoubleNode<>(new Alumno(23, 1, 7));
        DoubleNode<Alumno> tright = new DoubleNode<>(new Alumno(25, 0, 9));
        tleft.right = new DoubleNode<>(new Alumno(12, 0, 3));
        tleft.left = new DoubleNode<>(new Alumno(32, 1, 5));
        tleft.left.left = new DoubleNode<>(new Alumno(24, 1, 2));
        tright.left = new DoubleNode<>(new Alumno(9, 0, 1));
        tright.left.right = new DoubleNode<>(new Alumno(29, 1, 8));
        BinaryTree<Alumno> a = new BinaryTree<>(new Alumno(27, 0, 6));
        a.root.left = tleft;
        a.root.right = tright;
        try {
            BinarySearchTree<Alumno> reprobadosPorMatricula = reprobadosPorMatrícula(a);
            inorden(reprobadosPorMatricula);
        } catch (ElementBelongsToTreeException | TreeIsEmptyException e) {
            e.printStackTrace();
        }
    }

    public static BinarySearchTree<Alumno> reprobadosPorMatrícula(BinaryTree<Alumno> a) throws ElementBelongsToTreeException {
        BinarySearchTree<Alumno> b = new BinarySearchTree<>();
        treeAux(a, b);
        return b;
    }

    private static void treeAux(BinaryTree<Alumno> a, BinarySearchTree<Alumno> b) throws ElementBelongsToTreeException {
        if (!a.isEmpty()) {
            if (a.getRoot().getCalificacion() < 4)
                b.insert(a.getRoot());
            treeAux(a.getLeft(), b);
            treeAux(a.getRight(), b);
        }
    }

    public static void inorden(BinarySearchTree<Alumno>  a) throws TreeIsEmptyException {
        if(!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println( a.getRoot());
            inorden(a.getRight());
        }
    }
}
