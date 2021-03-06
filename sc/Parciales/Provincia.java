package Parciales;

import java.util.Arrays;

public class Provincia implements Comparable<Provincia>{
    private int provincia;
    private long[] lluviasMensuales;

    Provincia(int provincia, long[] lluviasMensuales) {
        this.provincia = provincia;
        this.lluviasMensuales = lluviasMensuales;
    }

    public int getProvincia() {
        return provincia;
    }

    public long[] getLluviasMensuales() {
        return lluviasMensuales;
    }

    public void setLluviasMensuales(long[] lluviasMensuales) {
        this.lluviasMensuales = lluviasMensuales;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public static long[] randomLluviasGenerador() {
        long[] lluvias = new long[12];
        for (int i = 0; i < 12; i++) {
            lluvias[i] = (long) (Math.random() * 10000 + Math.random() * 100);
        }
        return lluvias;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "provincia=" + provincia +
                ", lluviasMensuales=" + Arrays.toString(lluviasMensuales) +
                '}';
    }

    @Override
    public int compareTo(Provincia o) {
        long thisLluvias = 0;
        long otherLluvias = 0;
        for (int i = 0; i < this.lluviasMensuales.length; i++) {
            thisLluvias = thisLluvias + lluviasMensuales[i];
            otherLluvias = otherLluvias + o.lluviasMensuales[i];
        }
        return Long.compare(thisLluvias, otherLluvias);
    }
}
