package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ArchivoCotizacionPorAnio {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 12;

    public ArchivoCotizacionPorAnio(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }

    public int getSizeReg() {
        return sizeReg;
    }

    public RandomAccessFile getRaf() {
        return raf;
    }


}
