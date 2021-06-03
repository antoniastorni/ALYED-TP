package Archivos.Archivoss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoVentasPorAnio {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 34;

    public ArchivoVentasPorAnio(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }

    public void escribirVenta(Venta venta) throws IOException {
        raf.writeUTF(venta.getCodigoDeDestino());
        raf.writeInt(venta.getCodigoArticulo());
        raf.writeInt(venta.getCantidad());
        raf.writeDouble(venta.getPrecioUnitDolar());
        raf.writeInt(venta.getDia());
        raf.writeInt(venta.getMes());
        raf.writeInt(venta.getAnio());
        raf.writeBoolean(venta.isActivo());

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

    public Venta leerVenta() throws IOException {

        return new Venta(raf.readUTF(), raf.readInt(), raf.readInt(), raf.readDouble(), raf.readInt(),raf.readInt(),raf.readInt(), raf.readBoolean());
    }

    public Venta buscarVentaPorDestino(String codigoDestino) throws Exception {
        irAlInicio();
        Venta v;
        for (int i = 0; i < cantRegistros(); i++) {
            v = leerVenta();
            if(v.isActivo() && v.getCodigoDeDestino().equals(codigoDestino)) return v;
        }
        throw new Exception("Venta no encontrada");
    }

    public Venta buscadorVentaPorMes(int mes) throws Exception {
        irAlInicio();
        Venta v;
        for (int i = 0; i < cantRegistros(); i++) {
            v = leerVenta();
            if(v.isActivo() && v.getMes() == mes) return v;
        }
        throw new Exception("Venta no encontrada");
    }

    public boolean eliminarVenta(){
        return true; //respecto a qué se elimina la venta?
    }

}
