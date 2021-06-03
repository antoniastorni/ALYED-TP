package Archivos.Archivoss;

import java.io.Serializable;

public class Venta implements Serializable {
    private String codigoDeDestino;
    private int codigoArticulo;
    private int cantidad;
    private double precioUnitDolar;
    private int dia, mes, anio;
    private boolean activo;

    public Venta(String codigoDeDestino, int codigoArticulo, int cantidad, double precioUnitDolar, int dia, int mes, int anio, boolean activo) {
        this.codigoDeDestino = codigoDeDestino;
        this.codigoArticulo = codigoArticulo;
        this.cantidad = cantidad;
        this.precioUnitDolar = precioUnitDolar;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.activo = activo;
    }

    public int getMes() {
        return mes;
    }

    public double getPrecioUnitDolar() {
        return precioUnitDolar;
    }

    public int getAnio() {
        return anio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public int getDia() {
        return dia;
    }

    public String getCodigoDeDestino() {
        return codigoDeDestino;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public void setCodigoDeDestino(String codigoDeDestino) {
        this.codigoDeDestino = codigoDeDestino;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setPrecioUnitDolar(double precioUnitDolar) {
        this.precioUnitDolar = precioUnitDolar;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigoDeDestino='" + codigoDeDestino + '\'' +
                ", codigoArticulo=" + codigoArticulo +
                ", cantidad=" + cantidad +
                ", precioUnitDolar=" + precioUnitDolar +
                ", dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                ", activo=" + activo +
                '}';
    }
}
