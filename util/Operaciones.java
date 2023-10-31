package util;

import java.util.*;

import clases.Producto;

public class Operaciones {
    

    public static void carga() {
        Arbol arbol = new Arbol();
        Scanner entrada = new Scanner(System.in);
        String nombre;
        do {
            int cantidad;
            Producto producto = new Producto();
            System.out.println("Ingrese nombre del producto (0 solo para salir): ");
            nombre = entrada.nextLine();
            if(nombre == "") nombre = entrada.nextLine();
            if (nombre != "0") {
                System.out.println("Ingrese la cantidad: ");
                cantidad = entrada.nextInt();
                producto.nuevo(nombre, cantidad);
                arbol.insertar(producto);
                System.out.println("Nuevo elemento:" + producto.getName() + " Cantidad: " + producto.getCantidad());
            } 
        } while (nombre != "0");
    }

    public void buscar() {
        Arbol arbol = new Arbol();
        Scanner entrada = new Scanner(System.in);
        String nombre;
        System.out.print("Ingrese el nombre del producto a consultar: ");
        nombre = entrada.nextLine();
        if(nombre == "") nombre = entrada.nextLine();
        try {
            arbol.imprimirNodo(arbol.buscar(nombre));
        } catch (Exception e) {
            System.out.println("El nombre ingresado no se encuentra en el stock");
        }
    }

    public void Actualizar() {
        Arbol arbol = new Arbol();
        Scanner entrada = new Scanner(System.in);
        String nombre;
        do {
            System.out.print("Nombre del producto (0 para salir): ");
            nombre = entrada.nextLine();
            if(nombre == "") nombre = entrada.nextLine();
            if (nombre != "0") {
                try {
                    Nodo<Producto> nodo = arbol.buscar(nombre);
                    System.out.print("Cantidad actual: " + nodo.getElemento().getCantidad());
                    System.out.print("Nueva Cantidad: ");
                    nodo.getElemento().setStock(entrada.nextInt());
                    arbol.imprimirNodo(nodo);
                } catch (Exception e) {
                    System.out.println("El nombre no ha sido encontrado en el stock");
                }

            }
        } while (nombre != "0");
    }

    public void eliminar() {
        Arbol arbol = new Arbol();
        Scanner entrada = new Scanner(System.in);
        String nombre;
        System.out.print("Eliminar producto por nombre: ");
        nombre = entrada.nextLine();
        if(nombre == "") nombre = entrada.nextLine();
        try {
            arbol.eliminar(nombre);
            System.out.println("El Producto: " + nombre + "se ha eliminado con exito");
        } catch (Exception e) {
            System.out.println("El nombre del producto ingresado no ha sido encontrado en el stock");
        }
    }

    public void imprimir() {
        Arbol arbol = new Arbol();
        arbol.imprimir();
    }

    public void aleatorios() {
        Arbol arbol = new Arbol();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea generar: ");
        int cantidad = entrada.nextInt();
        for (int i = 0; i < cantidad; i++) {
            Producto producto = new Producto();
            Random random = new Random();
            int randomNumber = random.nextInt(1000) + 1;
            int randomNumbe2 = random.nextInt(1000) + 1;
            producto.nuevo("Producto " + randomNumber, randomNumbe2);
            System.out.println("Se ingreso el: " + producto.getName());
            arbol.insertar(producto);
        }
    }

    public void venta() {
        Arbol arbol = new Arbol();
        Scanner entrada = new Scanner(System.in);
        String nombre;
        do {
            System.out.print("Nombre del producto (0 para salir): ");
            nombre = entrada.nextLine();
            if(nombre == "") nombre = entrada.nextLine();
            if (nombre != "") {
                try {
                    Nodo<Producto> nodo = arbol.buscar(nombre);
                    if (nodo.getElemento().getCantidad() == 0) {
                        System.out.println("El producto no se encuentra disponible");
                        break;
                    }
                    System.out.print("Cantidad Disponible: " + nodo.getElemento().getCantidad());
                    System.out.print("Cantidad: ");
                    int cantidad = entrada.nextInt();
                    if (nodo.getElemento().getCantidad() < cantidad) {
                        System.out.println("La cantidad solicitada supera los existentes");
                    } else {
                        nodo.getElemento().setStock(nodo.getElemento().getCantidad() - cantidad);
                        // Falta añadir la venta al registro de la lista
                    }

                } catch (Exception e) {
                    System.out.println("El nombre no ha sido encontrado en el stock");
                }

            }
        } while (nombre != "0");
    }

    public void registro() {
        // Aca se va a mostrar el registro
    }
}
