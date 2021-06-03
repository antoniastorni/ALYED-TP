package Parciales.Soly;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IO {
    private String nombreArchivo;


    public IO(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        llenadoDeRegistros();
    }

    public RandomAccessFile lluvioMasDe50mm() throws IOException {
            File file = new File("Lluvias de más de 50 mm");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            ArchivoPPP archivoPPP = new ArchivoPPP(nombreArchivo);
            archivoPPP.irAlInicio();
            int counter = 1;
            int diasQueLlovio = 0;
            while (counter <= 12) {
                for (int i = 0; i < archivoPPP.cantRegistros(); i++) {
                    PrecipitacionesPorProvincia prec = archivoPPP.leer();
                    if (prec.getCantidadPrecipitacion() > 50 && prec.getMes() == counter && prec.isActivo()) {
                        diasQueLlovio++;
                    }
                }
                raf.writeInt(counter);
                raf.writeInt(diasQueLlovio);
                counter++;
            }
            raf.close();
            archivoPPP.cerrar();
            return raf;
    }

    /*
    a.  que informe para cada mes la precipitación caída en todo el país

    b.  que genere un archivo RandomAccesFile donde cada registro contenga
        el número de provincia y la cantidad de días que llovió más de 50 mm
     */
    public void precipitacionesPorMes() {
        try{
            ArchivoPPP archivoPPP = new ArchivoPPP(nombreArchivo);
            archivoPPP.irAlInicio();
            int counter = 1;
            int cantidadPorMes = 0;
            while (counter <= 12){
                for (int i = 0; i < archivoPPP.cantRegistros(); i++) {
                    PrecipitacionesPorProvincia prec = archivoPPP.leer();
                    if (prec.getMes() == counter && prec.isActivo()) {
                        cantidadPorMes = cantidadPorMes + prec.getCantidadPrecipitacion();
                    }
                }
                System.out.println("Precipitación caída durante el mes " + counter + " = " + cantidadPorMes + " mm.");
                counter++;
            }
            archivoPPP.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IO io = new IO("ArchivoParcial");
        io.precipitacionesPorMes();
        try {
            RandomAccessFile raaf = io.lluvioMasDe50mm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void llenadoDeRegistros() {
        try{
            ArchivoPPP archivoPPP = new ArchivoPPP(nombreArchivo);
            archivoPPP.irAlFinal();
            archivoPPP.escribir(new PrecipitacionesPorProvincia(1, 2, 23,43, true));
            archivoPPP.escribir(new PrecipitacionesPorProvincia(1, 2, 21,55, true));
            archivoPPP.escribir(new PrecipitacionesPorProvincia(1, 4, 23,60, true));
            archivoPPP.escribir(new PrecipitacionesPorProvincia(1, 2, 21,80, true));
            archivoPPP.escribir(new PrecipitacionesPorProvincia(1, 4, 23,12, true));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

