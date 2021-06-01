package Archivos.Ejemplo;

import java.util.Scanner;

public class IO {
    private Scanner lector;
    private String nombreArchivo = "StockVacunas";
    private Vacunatorio vacunatorio;

    public IO() throws Exception {
        vacunatorio = new Vacunatorio();
        lector = new Scanner(System.in);
        int opcion = menu();
        while (opcion < 5) {
            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
            }
            opcion = menu();
        }
        vacunatorio.grabar();
    }

    public int menu() {
        System.out.println("1. Alta");
        System.out.println("2. Listar");
        System.out.println("3. Buscar");
        System.out.println("4. Eliminar");
        System.out.println("5. Fin");
        System.out.println("Opcion: ");
        String opc = lector.nextLine();
        int opcion = Integer.parseInt(opc);
        return opcion;
    }

    public void alta() {
        int codigo;
        String descripcion;
        int dia;
        int mes;
        int anio;
        System.out.println("Codigo: ");
        codigo = Integer.parseInt(lector.nextLine());
        while (codigo != 0) {
            System.out.println("Descripcion: ");
            descripcion = lector.nextLine();
            System.out.println("Dia: ");
            dia = Integer.parseInt(lector.nextLine());
            System.out.println("Mes: ");
            mes = Integer.parseInt(lector.nextLine());
            System.out.println("Año: ");
            anio =
                    Integer.parseInt(lector.nextLine());
            Fecha f = new Fecha(dia, mes, anio);
            Vacuna v = new Vacuna(codigo, descripcion, f);
            vacunatorio.agregar(v);
            System.out.println("Codigo: ");
            codigo =
                    Integer.parseInt(lector.nextLine());
        }
    }

    public void listar() {

        for (int i = 0; i < vacunatorio.cantVacunas(); i++
        )

            System.out.println(vacunatorio.obtener(i).toString());
    }

    public void buscar() {

    }

    public void eliminar() {
    }

    public static void main(String[] args) {
        try {
            new IO();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

