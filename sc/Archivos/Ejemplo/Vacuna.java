package Archivos.Ejemplo;

import java.io.Serializable;

public class Vacuna implements Serializable {
    private int codigo;
    private String descripcion;
    private Fecha vencimiento;
    public Vacuna(int codigo, String descripcion, Fecha
            vencimiento) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.vencimiento = vencimiento;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Fecha getVencimiento() {
        return vencimiento;
    }
    public void setVencimiento(Fecha vencimiento) {
        this.vencimiento = vencimiento;
    }
    public String toString(){
        return ("Código: " + codigo + " Descripción: " +
                descripcion + " Vencimiento: " + vencimiento.getDd()+"/"
                +vencimiento.getMm()+"/"+
                vencimiento.getAa());
    }
}
