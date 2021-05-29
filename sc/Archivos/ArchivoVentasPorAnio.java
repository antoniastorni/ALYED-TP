package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ArchivoVentasPorAnio {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 1000;

    public ArchivoVentasPorAnio(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }
}
