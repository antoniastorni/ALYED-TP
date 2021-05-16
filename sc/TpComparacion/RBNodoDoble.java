package TpComparacion;

public class RBNodoDoble<T>{
    T elem;
    RBNodoDoble<T> izq, der;
    int color;

    public RBNodoDoble() {
    }
    public RBNodoDoble(T elem) {
        this.elem = elem;
        color = 1;
    }
}
