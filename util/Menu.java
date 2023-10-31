package util;

import java.util.Scanner;

public class Menu {
    public void menu() {
        try (Scanner entrada = new Scanner(System.in)) {
            Operaciones operaciones = new Operaciones();
            int op = 0;
            do {
                System.out.println("**************CONTROL DE STOCK**************");
                System.out.println("\t1.- Ingresar producto.");
                System.out.println("\t2.- Consultar stock de un producto.");
                System.out.println("\t3.- Actualizar stock de un producto.");
                System.out.println("\t4.- Eliminar producto del inventario.");
                System.out.println("\t5.- Mostrar el inventario.");
                System.out.println("\t6.- Ingresdo de productos aleatorios.");
                System.out.println("\t7.- Registrar Venta.");
                System.out.println("\t8.- Mostrar Registro.");
                System.out.println("\t0.- Salir.");
                System.out.println("Opcion: ");
                op = entrada.nextInt();
                switch (op) {
                    case 1:
                        operaciones.carga();
                        break;
                    case 2:
                        operaciones.carga();
                        break;
                    case 3:
                        operaciones.Actualizar();
                        break;
                    case 4:
                        operaciones.eliminar();
                        break;
                    case 5:
                        operaciones.imprimir();
                        break;
                    case 6:
                        operaciones.aleatorios();
                        break;
                    case 7:
                        operaciones.venta();
                        break;
                    case 8:
                        operaciones.registro();
                    default:
                        System.out.println("Hasta Luego");
                        break;
                }
            } while (op != 0);
        }
    }
}
