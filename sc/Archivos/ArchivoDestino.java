package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ArchivoDestino {
    private File file;
    private RandomAccessFile raf;
    private int sizeReg = 30;

    public ArchivoDestino(String nombre) throws FileNotFoundException {
        file = new File(nombre);
        raf = new RandomAccessFile(file, "rw");
    }


}
