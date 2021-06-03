package Archivos.Archivoss;

import java.io.Serializable;

public class Cotizacion implements Serializable {
    private int mes;
    private double valorDolar;
    private boolean activo;

    public Cotizacion(int mes, double valorDolar, boolean activo) {
        this.mes = mes;
        this.valorDolar = valorDolar;
        this.activo = activo;
    }

    public double getValorDolar() {
        return valorDolar;
    }

    public int getMes() {
        return mes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setValorDolar(double valorDolar) {
        this.valorDolar = valorDolar;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "mes=" + mes +
                ", valorDolar=" + valorDolar +
                '}';
    }
}
