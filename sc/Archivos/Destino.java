package Archivos;

public class Destino {
    private String codigoDestino;
    private String descripcion;
    private boolean activo;

    public Destino(String codigoDestino, String descripcion, boolean activo) {
        this.codigoDestino = codigoDestino;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Destino(){

    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCodigoDestino(String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
