package Arboles;

import ArbolesBinariosDeBusqueda.Estudiante;
import TpComparacion.AVLTree;
import TpComparacion.TreeIsEmptyException;

import java.util.ArrayList;

public class BinaryTreeAPI<T> {

    /* Indica si dos árboles binarios son iguales ****/
    boolean equals(BinaryTree<T> a1, BinaryTree<T> a2) {
        return isomorfos(a1, a2) && semejantes(a1, a2);
    }

    /* Informa si los árboles binarios a1 y a2 son isomorfos */
    boolean isomorfos(BinaryTree<T> a1, BinaryTree<T> a2 ) {
        if (a1.isEmpty() && !a2.isEmpty())
            return false;
        if (!a1.isEmpty() && a2.isEmpty())
            return false;
        if (a1.isEmpty() && a2.isEmpty())
            return true;
        return isomorfos(a1.getLeft(), a2.getLeft()) && isomorfos(a1.getRight(), a2.getRight());
    }

    /* Informa si los árboles binarios a1 y a2, sin elementos repetidos son semejantes*/
    boolean semejantes(BinaryTree<T> a1, BinaryTree<T> a2 ){
        if (semejantesAuxiliar(a1,a2, a2) == peso(a1)) {
            return true;
        }
        return false;
    }

    /*Compara un elemento de un arbol con todos los otros elementos de otro arbol y devuelve el número de semejanzas*/
    private int semejantesAuxiliar(BinaryTree<T> a1, BinaryTree<T> a2, BinaryTree<T> a3){
        if (a1.isEmpty() || a2.isEmpty())
            return 0;
        if(a1.getRoot().equals(a2.getRoot()))
            return 1 +semejantesAuxiliar(a1.getLeft(), a3, a3) + semejantesAuxiliar(a1.getRight(), a3, a3);
        return semejantesAuxiliar(a1, a2.getRight(), a3) + semejantesAuxiliar(a1, a2.getLeft(), a3);
    }

    /* Indica si un árbol binario es completo */
    boolean completo(BinaryTree<T> a ){
        if(completeNodes(a) == peso(a))
            return true;
        return false;
    }

    /* Devuelve la cantidad de nodos completos de un arbol*/
    private  int completeNodes(BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        return 1 + completeNodes(a.getRight()) + completeNodes(a.getLeft());
    }

    /* Informa si un árbol binario está lleno */
    boolean lleno(BinaryTree<T> a ) {
        return numeroHojas(a) == Math.pow(2, altura(a)) -1;
    }

    /* Un árbol de valores enteros es estable si es vacío, consta de un único elemento
    o para todo elemento de la estructura su padre es mayor. */
    boolean estable( BinaryTree<Integer> a ) {
        if (a.isEmpty()){
            return true;
        }else if(a.getRoot().compareTo(a.getLeft().getRoot()) > 0 && a.getRoot().compareTo(a.getRight().getRoot()) >0){
            return estable(a.getRight()) && estable(a.getLeft());
        }
            return false;
    }

    /* Indica si el árbol a2 ocurre en el árbol a1 */
    boolean ocurreArbin(BinaryTree<T> a1, BinaryTree<T> a2 ){
        if (a1.isEmpty()){
            return true;
        }
        if(a2.isEmpty()){
            return false;
        }else if (!a2.getRoot().equals(a1.getRoot())){
            return ocurreArbin(a1.getLeft(), a2.getLeft()) && ocurreArbin(a1.getRight(), a2.getRight());
        }else{
            return ocurreArbin(a1.getLeft(), a2) && ocurreArbin(a1.getRight(), a2);
        }
    }

    /* Se define frontera de un árbol binario, el conjunto formado por los elementos
    almacenados en las hojas.*/
    void mostrarFrontera(BinaryTree<T> a){
        if (!a.isEmpty()) {
            if (a.getLeft().isEmpty() && a.getRight().isEmpty())
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
    public  int peso (BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        else
            return 1 + peso(a.getLeft())+peso(a.getRight());
    }

    // devuelve el numero de veces uqe aparece un elemento dado
    public  int ocurrencias(BinaryTree<T> a, T o){
        if(a.isEmpty())
            return 0;
        if(a.getRoot().equals(o))
            return
                    1 + ocurrencias(a.getLeft(),o)+ocurrencias(a.getRight(),o);
        else
            return ocurrencias(a.getLeft(),o)+ocurrencias(a.getRight(),o);
    }

    //devuelve el numero de hojas de un arbol
    public int numeroHojas(BinaryTree a) {
        if (a.getRoot() == null)
            return 0;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        }
        return numeroHojas(a.getRight()) + numeroHojas(a.getLeft());
    }

    //devuelve el numer ode elementos en un nivel dado
    public int elementospornivel(BinaryTree a, int nivel) {
        if (a.isEmpty())
            return 0;
        if(nivel > 1){
            return elementospornivel(a.getLeft(), nivel-1) + elementospornivel(a.getRight(), nivel-1);
        }else{
            return 1;
        }
    }

        //devuelve la altura
        public int altura (BinaryTree a) {
            if (a.isEmpty()){
                return 0;
            }else {
                return 1 + ((altura(a.getRight()) < altura(a.getLeft())) ? altura(a.getLeft()) : altura(a.getRight()));
            }
        }

        //14a

        public int sumageneral(BinaryTree<Integer> a){
            if(!a.isEmpty()) {
                return a.getRoot() + sumageneral(a.getLeft()) + sumageneral(a.getRight());
            }
            return 0;
        }

        public int sumaMultiplo3(BinaryTree<Integer> a){
            if(!a.isEmpty()) {
                if (a.getRoot()%3 == 0) {
                    return a.getRoot() + sumaMultiplo3(a.getLeft()) + sumaMultiplo3(a.getRight());
                }else{

                    return sumaMultiplo3(a.getLeft()) + sumaMultiplo3(a.getRight());
                }
            }

            return 0;
        }
}

