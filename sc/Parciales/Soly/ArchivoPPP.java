package Parciales.Soly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoPPP {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 17;

    public ArchivoPPP(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }

    public void escribir(PrecipitacionesPorProvincia pp) throws IOException {
        raf.writeInt(pp.getDia());
        raf.writeInt(pp.getMes());
        raf.writeInt(pp.getProvincia());
        raf.writeInt(pp.getCantidadPrecipitacion());
        raf.writeBoolean(pp.isActivo());
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

    //me tira una EOFException pero no estaría enontrando el error
    public PrecipitacionesPorProvincia leer() throws IOException {
        int dia = raf.readInt();
        int mes = raf.readInt();
        int provincia = raf.readInt();
        int cant = raf.readInt();
        boolean t = raf.readBoolean();
        return new PrecipitacionesPorProvincia(dia, mes, provincia, cant, t);
    }

}
