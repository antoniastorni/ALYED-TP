package Archivos.Archivoss;

import java.io.Serializable;
import java.security.SecureRandom;

public class Destino implements Serializable {
    private String codigoDestino;
    private String descripcion;
    private boolean activo;

    public Destino(String codigoDestino, String descripcion, boolean activo) {
        this.codigoDestino = codigoDestino;
        this.descripcion = descripcion;
        this.activo = activo;
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

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomDestino(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Destino{" +
                "codigoDestino='" + codigoDestino + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
