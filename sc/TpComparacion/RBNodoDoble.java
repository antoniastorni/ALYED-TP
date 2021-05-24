package TpComparacion;

public class RBNodoDoble<T> {
    T elem;
    RBNodoDoble<T> izq, der, parent;
    int color;

    public RBNodoDoble() {
    }
    public RBNodoDoble(T elem) {
        this.elem = elem;
        color = 1;
    }

    public RBNodoDoble(T elem, RBNodoDoble<T> izq, RBNodoDoble<T> der) {
        this.elem = elem;
        color = 1;
        this.izq = izq;
        this.der = der;
    }
}
