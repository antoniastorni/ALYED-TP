package Arboles;

import java.util.ArrayList;

public class BinaryTreeAPI<T> {

    /* Indica si dos árboles binarios son iguales */
    boolean equals(BinaryTree<T> a1, BinaryTree<T> a2) {
        if (equalsAuxiliar(a1, a2) == size(a1) && size(a1) == size(a2))
            return true;
        return false;
    }

    /*dudoso esto pero bueno, es lo que hay*/
    private int equalsAuxiliar(BinaryTree<T> a1, BinaryTree<T> a2){
        if (a1.isEmpty() || a2.isEmpty())
            return 0;
        if (a1.equals(a2))
            return 1 + equalsAuxiliar(a1.getLeft(), a2.getLeft()) + equalsAuxiliar(a1.getRight(), a2.getRight());
        return equalsAuxiliar(a1.getLeft(), a2.getLeft()) + equalsAuxiliar(a1.getRight(), a2.getRight());
    }

    /* Informa si los árboles binarios a1 y a2 son isomorfos */
    boolean isomorfos(BinaryTree<T> a1, BinaryTree<T> a2 ){
        int numberOfIsomorfos = isomorfosAuxiliar(a1, a2);
        if (numberOfIsomorfos == size(a1) && numberOfIsomorfos == size(a2))
            return true;
        return false;
    }

    private int isomorfosAuxiliar(BinaryTree<T> a1, BinaryTree<T> a2 ) {
        while (!a1.isEmpty() || !a2.isEmpty()) {
            if ((a1.isEmpty() & !a2.isEmpty()) || (!a1.isEmpty() & a2.isEmpty())) //si uno está vacío y el tro no
                return isomorfosAuxiliar(a1.getRight(), a2.getRight()) + isomorfosAuxiliar(a1.getLeft(), a2.getLeft());
            return 1 + isomorfosAuxiliar(a1.getRight(), a2.getRight()) + isomorfosAuxiliar(a1.getLeft(), a2.getLeft());
        }
        return 1;
    }

    /* Informa si los árboles binarios a1 y a2, sin elementos repetidos son semejantes*/
    boolean semejantes(BinaryTree<T> a1, BinaryTree<T> a2 ){
        T auxiliarElement = a1.getRoot();
        if (semejantesAuxiliar(a1, a2) == 1) {
            semejantesAuxiliar(a1.getRight(), a2);
            semejantesAuxiliar(a2.getLeft(), a2);
        }
        return true;
    }

    /*Compara un elemento de un arbol con todos los otros elementos de otro arbol y devuelve el número de semejanzas*/
    private int semejantesAuxiliar(BinaryTree<T> a1, BinaryTree<T> a2 ){
        if(a1.getRoot().equals(a2.getRoot()))
            return 1 + semejantesAuxiliar(a1, a2.getRight()) + semejantesAuxiliar(a1, a2.getLeft());
        return semejantesAuxiliar(a1, a2.getRight()) + semejantesAuxiliar(a1, a2.getLeft());
    }

    /* Indica si un árbol binario es completo */
    boolean completo(BinaryTree<T> a ){
        if(completeNodes(a) == size(a))
            return true;
        return false;
    }

    /* Devuelve la cantidad de nodos completos de un arbol*/
    public  int completeNodes(BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
/*        if (a.getLeft().isEmpty())
            return completeNodes(a.getRight());
        if (a.getRight().isEmpty())
            return completeNodes(a.getLeft());*/
        return 1 + completeNodes(a.getRight()) + completeNodes(a.getLeft());
    }

    /* Informa si un árbol binario está lleno */
    boolean lleno(BinaryTree<T> a ){
        return true;
    }

    int getLevel(BinaryTree<T> a){
        return 1;
    }

    /* Un árbol de valores enteros es estable si es vacío, consta de un único elemento
    o para todo elemento de la estructura su padre es mayor. */
    boolean estable( BinaryTree<T> a ) {
        return true;
    }

    /* Indica si el árbol a2 ocurre en el árbol a1 */
    boolean ocurreArbin(BinaryTree<T> a1, BinaryTree<T> a2 ){
        return true;
    }

    /* Se define frontera de un árbol binario, el conjunto formado por los elementos
    almacenados en las hojas.*/
    void mostrarFrontera(BinaryTree<T> a){
        while (!a.isEmpty()) {
            if (a.getLeft().isEmpty() && a.getRight().isEmpty()) //if (a.getLeft() == null && a.getRight() == null)
                System.out.println(a.getRoot());
            mostrarFrontera(a.getLeft());
            mostrarFrontera(a.getRight());
        }
    }

    /* Retorna un ArrayList con la frontera */
    ArrayList<T> frontera(BinaryTree<T> a, Object elem ){
        ArrayList<T> arrayList = new ArrayList<>();
        fronteraAuxiliar(a, arrayList);
        return arrayList;
    }

    private void fronteraAuxiliar(BinaryTree<T> a, ArrayList<T> arrayList){
        while (!a.isEmpty()) {
            if (a.getLeft() == null && a.getRight() == null)
                arrayList.add(a.getRoot());
            fronteraAuxiliar(a.getLeft(), arrayList);
            fronteraAuxiliar(a.getRight(), arrayList);
        }
    }

    //devuelve el tamaño del arbol (peso)
    public  int size (BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        else
            return 1 + size(a.getLeft())+size(a.getRight());
    }
    //numero de hoja, numero de elem en un nivel dado, altura

}
