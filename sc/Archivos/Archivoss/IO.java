package Archivos.Archivoss;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class IO {
    private Scanner sc;
    private String archDestino = "ArchDestino";
    private String arcnCotizacion = "ArchCotizacion";
    private String archVenta = "ArchVenta";

    public IO() {
        sc = new Scanner(System.in);
        llenadoDePrueba();
        menuFinal();
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                ventasPorDestino();
                break;
            case 2:
                ventasPorMes();
                break;
            default:
                new IO();
        }
    }

    private void ventasPorMes() {
        try {
            ArchivoVentasPorAnio ventas = new ArchivoVentasPorAnio(archVenta);
            ArchivoCotizacionPorAnio cotizacion = new ArchivoCotizacionPorAnio(arcnCotizacion);
            double montoEnDolar = 0;
            Venta v;
            Cotizacion c;
            int mes = 1;
            while (mes <= 12) {
                for (int i = 0; i < ventas.cantRegistros(); i++) {
                    v = ventas.leerVenta();
                    if (v.getMes() == mes) {
                        montoEnDolar = montoEnDolar + v.getPrecioUnitDolar() * v.getCantidad();
                    }
                }
                c = cotizacion.buscarCotizacion(mes);
                double montoEnPesos = montoEnDolar * c.getValorDolar();
                System.out.println("El monto recaudado durante el mes nro. " + mes + " es de: $" + montoEnPesos + " (pesos).");
                mes++;
                montoEnDolar = 0;
            }
        } catch (Exception e) {
            System.out.println("ventas por mes");
            e.printStackTrace();
        }
    }

    private void ventasPorDestino() {
        try {
            ArchivoVentasPorAnio ventas = new ArchivoVentasPorAnio(archVenta);
            ArchivoCotizacionPorAnio cotizacion = new ArchivoCotizacionPorAnio(arcnCotizacion);
            ArchivoDestino destinos = new ArchivoDestino(archDestino);
            double montoEnPesos = 0;
            Venta v;
            Cotizacion c;
            Destino d;
            for (int j = 0; j < destinos.cantRegistros(); j++) {
                d = destinos.leerDestino();
                for (int i = 0; i < ventas.cantRegistros(); i++) {
                    v = ventas.leerVenta();
                    if (v.getCodigoDeDestino().equals(d.getCodigoDestino())) {
                        c = cotizacion.buscarCotizacion(v.getMes());
                        montoEnPesos = montoEnPesos + v.getPrecioUnitDolar() * v.getCantidad() * c.getValorDolar();
                    }
                }
                System.out.println("El monto recaudado para el destino de " + d.getDescripcion() + " es de: $" + montoEnPesos + " (pesos).");
            }
            ventas.cerrar();
            cotizacion.cerrar();
            destinos.cerrar();
        } catch (Exception e) {
            System.out.println("ventas por destino");
            e.printStackTrace();

        }
    }

    private void menuFinal() {
        System.out.println("1. Monto de ventas en pesos por destino " +
                "\n2. Monto de ventas en pesos por mes");
    }

    public void llenadoDePrueba() {
        try {
            ArchivoDestino destino = new ArchivoDestino(archDestino);
            ArchivoCotizacionPorAnio cotizaciones = new ArchivoCotizacionPorAnio(arcnCotizacion);
            ArchivoVentasPorAnio ventasPorAnio = new ArchivoVentasPorAnio(archVenta);
            destino.irAlFinal();
            cotizaciones.irAlFinal();
            ventasPorAnio.irAlFinal();
            //alta detinos
            destino.escribirDestino(new Destino("MIA", "MIAMI", true));
            destino.escribirDestino(new Destino("ARG", "ARGENT", true));
            destino.escribirDestino(new Destino("SGP", "SINGAP", true));
            destino.escribirDestino(new Destino("MSC", "MOSCUu", true));
            destino.escribirDestino(new Destino("MDD", "MADRID", true));
            //alta cotizacion
            double randomization;
            for (int i = 0; i < 12; i++) {
                randomization = Math.random() * 100;
                cotizaciones.escribirCotizacion(new Cotizacion(i+1, randomization, true));
            }
            System.out.println(cotizaciones.leerCotizacion().toString());
            //alta ventas
            ventasPorAnio.escribirVenta(new Venta("ARG", 123, 2,200, 5,10,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("ARG", 123, 1,200, 5,5,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("MIA", 123, 1,200, 5,10,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("SGP", 123, 3,200, 5,11,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("MIA", 123, 2,200, 5,10,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("SGP", 123, 1,200, 5,5,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("SGP", 123, 3,200, 5,11,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("MIA", 123, 4,200, 5,10,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("SGP", 123, 1,200, 5,11,2020, true  ));
            ventasPorAnio.escribirVenta(new Venta("MDD", 123, 1,200, 5,10,2020, true  ));
            System.out.println(ventasPorAnio.leerVenta().toString());
            destino.cerrar();
            cotizaciones.cerrar();
            ventasPorAnio.cerrar();

        } catch (IOException e) {
            System.out.println("llenado");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new IO();
    }
//---------------------------------------------------------------------------------------------
    // DESTINOS

    public void altaDestinos() {
        try {
            String descripcion;
            ArchivoDestino archivoDestino = new ArchivoDestino(archDestino);
            archivoDestino.irAlFinal();
            System.out.println("Ingrese la cantidad de destinos: ");
            int cantDestinos = Integer.parseInt(sc.nextLine());
            int opcion = 0;
            while (opcion < cantDestinos) {
                System.out.println("Descripci??n: ");
                descripcion = sc.nextLine();
                archivoDestino.escribirDestino(new Destino(descripcion.substring(0, 3), descripcion, true));
                opcion++;
            }
                archivoDestino.cerrar();
            } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarDestino() {
        try {
            ArchivoDestino archivoDestino = new ArchivoDestino(archDestino);
            System.out.println("Ingrese el c??digo del destino a eliminar: ");
            String codigo = sc.nextLine();
            if(archivoDestino.eliminarDestino(codigo)) {
                System.out.println("Eliminaci??n exitosa");
            } else {
                System.out.println("C??digo erroneo");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarDestino() {
        try{
            Destino d;
            ArchivoDestino archivoDestino = new ArchivoDestino(archDestino);
            System.out.println("Ingrese el c??digo de destino");
            String codigo = sc.nextLine();
            d = archivoDestino.buscarDestino(codigo);
            System.out.println(d.toString());
            archivoDestino.cerrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarDestinos() {
        Destino d;
        try {
            ArchivoDestino archivoDestino = new ArchivoDestino(archDestino);
            for (int i = 0; i < archivoDestino.cantRegistros(); i++) {
                d = archivoDestino.leerDestino();
                if(d.isActivo()) {
                    System.out.println(d.toString());
                }
            }
            archivoDestino.cerrar();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//---------------------------------------------------------------------------------------------
    // COTIZACIONES

    public void altaCotizaciones() {
        try {
            double valorDolar;
            ArchivoCotizacionPorAnio c = new ArchivoCotizacionPorAnio(arcnCotizacion);
            c.irAlFinal();
            int mes = 1;
            while (mes <= 12) {
                System.out.println("Cotizaci??n del mes " + mes + ": ");
                valorDolar = Double.parseDouble(sc.nextLine());
                c.escribirCotizacion(new Cotizacion(mes, valorDolar, true));
                mes++;
            }
            c.cerrar();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //eliminar cotizacion

    public void buscarCotizaci??n() {
        try {
            Cotizacion cotizacion;
            ArchivoCotizacionPorAnio c = new ArchivoCotizacionPorAnio(arcnCotizacion);
            System.out.println("Ingrese el mes: ");
            int mes = Integer.parseInt(sc.nextLine());
            cotizacion = c.buscarCotizacion(mes);
            System.out.println(c.toString());
            c.cerrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());        }
    }

    //listar cotizaciones


//---------------------------------------------------------------------------------------------
    // VENTAS

    public void altaVenta() {
        try{
            String codigoDestino;
            int codigoArt, cant, dia, mes, anio;
            double preciouNitDolar;
            ArchivoVentasPorAnio v = new ArchivoVentasPorAnio(archVenta);
            v.irAlFinal();
            int option = 0;
            while(option != 2) {
                System.out.println("C??digo de destino: ");
                codigoDestino = sc.nextLine();
                System.out.println("C??digo de art??culo: ");
                codigoArt = Integer.parseInt(sc.nextLine());
                System.out.println("Cantidad:");
                cant = Integer.parseInt(sc.nextLine());
                System.out.println("Precio unitario en d??lares: ");
                preciouNitDolar = Double.parseDouble(sc.nextLine());
                System.out.println("Dia:");
                dia = Integer.parseInt(sc.nextLine());
                System.out.println("Mes: ");
                mes = Integer.parseInt(sc.nextLine());
                System.out.println("A??o: ");
                anio = Integer.parseInt(sc.nextLine());
                v.escribirVenta(new Venta(codigoDestino, codigoArt, cant, preciouNitDolar, dia, mes, anio, true));
                System.out.println("??Desea subir otra venta? \n1. Si \n2. No");
                option = Integer.parseInt(sc.nextLine());
            }
            v.cerrar();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
