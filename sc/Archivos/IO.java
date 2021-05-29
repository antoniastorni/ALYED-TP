package Archivos;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class IO {
    private Scanner sc;
    private String nombreArchivo = "C:\\Users\\solyb\\IdeaProjects\\ALYED-TP\\sc\\Archivos\\ArchDestino";

    public IO() {
        sc = new Scanner(System.in);
        menu();
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                ventasPorDestino();
                break;
            case 2:
                ventasPorMes();
                break;
        }
    }

    private void ventasPorMes() throws FileNotFoundException {
        ArchivoCotizacionPorAnio archivo = new ArchivoCotizacionPorAnio(nombreArchivo);
        for (int i = 0; i < archivo.getSizeReg(); i++) {
            archivo.
        }
    }

    private void ventasPorDestino() {
        
    }

    private void menu() {
        System.out.println("1. Monto de ventas en pesos por destino " +
                "\n2. Monto de ventas en pesos por mes");
    }

}
