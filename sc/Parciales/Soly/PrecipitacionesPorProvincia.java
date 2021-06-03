package Parciales.Soly;

public class PrecipitacionesPorProvincia {
    private int dia, mes, provincia;
    private int cantidadPrecipitacion;
    private boolean isActivo;

    public PrecipitacionesPorProvincia(int dia, int mes, int provincia, int cantidadPrecipitacion, boolean isActivo) {
        this.dia = dia;
        this.mes = mes;
        this.provincia = provincia;
        this.cantidadPrecipitacion = cantidadPrecipitacion;
        this.isActivo = isActivo;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public int getProvincia() {
        return provincia;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getCantidadPrecipitacion() {
        return cantidadPrecipitacion;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setCantidadPrecipitacion(int cantidadPrecipitacion) {
        this.cantidadPrecipitacion = cantidadPrecipitacion;
    }

    @Override
    public String toString() {
        return "PrecipitacionesPorProvincia{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", provincia=" + provincia +
                ", cantidadPrecipitacion=" + cantidadPrecipitacion +
                ", isActivo=" + isActivo +
                '}';
    }
}
