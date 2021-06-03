package Archivos.Archivoss;

import java.io.*;

public class ArchivoCotizacionPorAnio {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 13;

    public ArchivoCotizacionPorAnio(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }


    public void escribirCotizacion(Cotizacion cotizacion) throws IOException {
        raf.writeInt(cotizacion.getMes());
        raf.writeDouble(cotizacion.getValorDolar());
        raf.writeBoolean(cotizacion.isActivo());
    }

    public void cerrar() throws IOException {
        raf.close();
    }


    public void irAlFinal() throws IOException {
        raf.seek(raf.length());
    }

    public void irAlInicio() throws IOException {
        raf.seek(0);
    }

    public long cantRegistros() throws IOException {
        return raf.length()/sizeReg;
    }

    public Cotizacion leerCotizacion() throws IOException {
        return new Cotizacion(raf.readInt(), raf.readDouble(), raf.readBoolean());
    }

    public Cotizacion buscarCotizacion(int mes) throws Exception {
        irAlInicio();
        Cotizacion c;
        for (int i = 0; i < cantRegistros(); i++) {
            c = leerCotizacion();
            if(c.isActivo() && c.getMes() == mes) return c;
        }
        throw new Exception("Entrada erronea");
    }

    public boolean eliminarCotizacion(int mes) {
        try {
            Cotizacion c = buscarCotizacion(mes);
            raf.seek(raf.getFilePointer()-sizeReg);
            c.setActivo(false);
            escribirCotizacion(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
