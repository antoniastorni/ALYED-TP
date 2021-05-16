package TpComparacion;

public class AVLNodoDoble<T>{
    T elem;
    AVLNodoDoble<T> izq, der;
    int height;

    public AVLNodoDoble() {
        height = -1;
    }
    public AVLNodoDoble(T elem) {
        height = 0;
        this.elem = elem;
    }
}
