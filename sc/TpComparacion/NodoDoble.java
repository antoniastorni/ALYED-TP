package TpComparacion;

public class NodoDoble<T>{
    T elem;
    NodoDoble <T> izq, der;

    public NodoDoble() {

    }
    public NodoDoble(T elem) {

        this.elem = elem;
    }
    public NodoDoble(T elem, NodoDoble <T> izq, NodoDoble <T>der) {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
    }

}
