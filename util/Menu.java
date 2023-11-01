package util;

import java.util.Scanner;

public class Menu {
    public void menu() {
        Lista registro = new Lista();
        Arbol arbol = new Arbol();
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
                        operaciones.buscar(arbol, entrada);
                        break;
                    case 2:
                        operaciones.venta(arbol, entrada, registro);
                        break;
                    case 3:
                        operaciones.ingreso(arbol, entrada, registro);
                        break;
                    case 4:
                        operaciones.Actualizar(arbol, entrada, registro);
                        break;
                    case 5:
                        operaciones.carga(arbol, entrada, registro);
                        break;
                    case 6:
                        operaciones.eliminar(arbol, entrada);
                        break;
                    case 7:
                        operaciones.imprimir(arbol);
                        break;
                    case 8:
                        registro = operaciones.registro(registro);
                        break;
                    case 9:
                    operaciones.aleatorios(arbol, entrada, registro);
                    break;
                    default:
                        System.out.println("Hasta Luego");
                        break;
                }
            } while (op != 0);
        }
    }
}
