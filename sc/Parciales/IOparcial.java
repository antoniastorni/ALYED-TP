package Parciales;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IOparcial {

    public static void main(String[] args) {
        llenarArchivo();
        listadoProvincia();
    }
    /*
    Escribir una aplicación que muestre un listado de lasprovincias en orden de la cantidad de lluvia total anual
    de la más baja a la más alta.
     */
    public static void listadoProvincia() {
        try {
            ArchivoProvincia archivoProvincia = new ArchivoProvincia("Archivo de provinciass");
            archivoProvincia.irAlInicio();
            for (int i = 0; i < archivoProvincia.cantRegistros(); i++) {
                System.out.println(archivoProvincia.leerProvincia().toString());
            }
            archivoProvincia.cerrar();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void llenarArchivo() {
        try {
            ArchivoProvincia archivoProvincia = new ArchivoProvincia("Archivo de provinciass");
            archivoProvincia.irAlFinal();
            int provincias = 1;
            while (provincias <= 23) {
                long[] lluvias = Provincia.randomLluviasGenerador();
                archivoProvincia.escribirProvincia(new Provincia(provincias, lluvias));
                provincias = provincias + 1;
            }
            archivoProvincia.cerrar();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
