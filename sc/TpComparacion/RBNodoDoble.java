package TpComparacion;

public class RBNodoDoble<T> implements Comparable<T> {
    T elem;
    RBNodoDoble<T> izq, der;
    int color;

    public RBNodoDoble() {
    }
    public RBNodoDoble(T elem) {
        this.elem = elem;
        color = 1;
    }

    public RBNodoDoble(Comparable<T> elem, RBNodoDoble<T> izq, RBNodoDoble<T> der) {
        this.elem = elem;
        color = 1;
        this.izq = izq;
        this.der = der;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
