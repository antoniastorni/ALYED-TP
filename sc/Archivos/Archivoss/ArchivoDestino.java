package Archivos.Archivoss;

import java.io.*;

public class ArchivoDestino {
    private File file;
    private RandomAccessFile raf;
    private int sizeRegistro = 5;

    public ArchivoDestino(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }

    public void escribirDestino(Destino destino) throws IOException {
        raf.writeUTF(destino.getCodigoDestino());
        raf.writeUTF(destino.getDescripcion());
        raf.writeBoolean(destino.isActivo());
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
        return raf.length()/sizeRegistro;
    }

    public Destino leerDestino() throws IOException {
        return new Destino(raf.readUTF(), raf.readUTF(), raf.readBoolean());
    }

    public Destino buscarDestino(String codigo) throws Exception {
        irAlInicio();
        Destino d;
        for (int i = 0; i < cantRegistros(); i++) {
            d = leerDestino();
            if(d.isActivo() && d.getCodigoDestino().equals(codigo)) return d;
        }
        throw new Exception("Código erroneo");
    }

    public boolean eliminarDestino(String codigo) {
        try {
            Destino d = buscarDestino(codigo);
            raf.seek(raf.getFilePointer()-sizeRegistro);
            d.setActivo(false);
            escribirDestino(d);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
