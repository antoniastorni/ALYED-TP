package Parciales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoProvincia {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 100;

    ArchivoProvincia(String name) throws FileNotFoundException {
        file = new File(name);
        raf = new RandomAccessFile(file, "rw");
    }

    public void escribirProvincia(Provincia provincia) throws IOException {
        raf.writeInt(provincia.getProvincia());
        long[] aux = provincia.getLluviasMensuales();
        for (int i = 0; i < 12; i++) {
            raf.writeLong(aux[i]);
        }
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

    public Provincia leerProvincia() throws IOException {
        int provincia = raf.readInt();
        long[] lluvias = new long[12];
        for (int i = 0; i < 12; i++) {
            lluvias[i] = raf.readLong();
        }
        return new Provincia(provincia, lluvias);
    }


}
