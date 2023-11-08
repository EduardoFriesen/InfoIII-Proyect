package util;

import java.util.*;

import clases.Producto;

public class Operaciones {

    public void carga(Arbol arbol, Scanner entrada, Lista registro) {
        String nombre;
        do {
            int cantidad;
            Producto producto = new Producto();
            System.out.println("Ingrese nombre del producto (0 solo para salir): ");
            nombre = entrada.nextLine();
            nombre = entrada.nextLine();
            if (nombre != "") {
                System.out.println("Ingrese la cantidad: ");
                cantidad = entrada.nextInt();
                if (arbol.buscar(nombre) == null) {
                    producto.nuevo(nombre, cantidad);
                    arbol.insertar(producto);
                    registro.push(producto, cantidad);
                    System.out.println("Nuevo elemento:" + producto.getName() + " Cantidad: " + producto.getCantidad());
                } else {
                    System.out.println("El producto ya existe, se toma como ingreso");
                    NodoBinario<Producto> nodo = arbol.buscar(nombre);
                    registro.push(nodo.getElemento(), cantidad);
                    nodo.getElemento().setStock(cantidad + nodo.getElemento().getCantidad());
                    arbol.imprimirNodo(nodo);
                }
            }

        } while (nombre != "");
    }

    public void ingreso(Arbol arbol, Scanner entrada, Lista registro) {
        String nombre;
        do {
            System.out.print("Nombre del producto (0 para salir): ");
            nombre = entrada.nextLine();
            nombre = entrada.nextLine();
            if (nombre != "") {
                try {
                    NodoBinario<Producto> nodo = arbol.buscar(nombre);
                    System.out.print("  cantidad: ");
                    int cantidad = entrada.nextInt();
                    registro.push(nodo.getElemento(), cantidad);
                    nodo.getElemento().setStock(cantidad + nodo.getElemento().getCantidad());
                    arbol.imprimirNodo(nodo);
                } catch (Exception e) {
                    System.out.println("El nombre no ha sido encontrado en el stock");
                }

            }
        } while (nombre != "");
    }

    public void buscar(Arbol arbol, Scanner entrada) {
        String nombre;
        System.out.print("Ingrese el nombre del producto a consultar: ");
        nombre = entrada.nextLine();
        nombre = entrada.nextLine();
        try {
            arbol.imprimirNodo(arbol.buscar(nombre));
        } catch (Exception e) {
            System.out.println("El nombre ingresado no se encuentra en el stock");
        }
    }

    public void Actualizar(Arbol arbol, Scanner entrada, Lista registro) {
        String nombre;
        do {
            System.out.print("Nombre del producto (0 para salir): ");
            nombre = entrada.nextLine();
            nombre = entrada.nextLine();
            if (nombre != "") {
                try {
                    NodoBinario<Producto> nodo = arbol.buscar(nombre);
                    System.out.print("Cantidad actual: " + nodo.getElemento().getCantidad());
                    System.out.print("  Nueva Cantidad: ");
                    int cantidad = entrada.nextInt();
                    registro.push(nodo.getElemento(), cantidad - nodo.getElemento().getCantidad());
                    nodo.getElemento().setStock(cantidad);
                    arbol.imprimirNodo(nodo);
                } catch (Exception e) {
                    System.out.println("El nombre no ha sido encontrado en el stock");
                }

            }
        } while (nombre != "");
    }

    public void eliminar(Arbol arbol, Scanner entrada) {
        String nombre;
        System.out.print("Eliminar producto por nombre: ");
        nombre = entrada.nextLine();
        nombre = entrada.nextLine();
        try {
            arbol.eliminar(nombre);
            System.out.println("El Producto: " + nombre + "se ha eliminado con exito");
        } catch (Exception e) {
            System.out.println("El nombre del producto ingresado no ha sido encontrado en el stock");
        }
    }

    public void imprimir(Arbol arbol) {
        arbol.imprimir();
    }

    public void aleatorios(Arbol arbol, Scanner entrada, Lista registro) {
        System.out.println("Ingrese la cantidad de elementos que desea generar: ");
        int cantidad = entrada.nextInt();
        for (int i = 0; i < cantidad; i++) {
            Producto producto = new Producto();
            Random random = new Random();
            int randomNumber = random.nextInt(1000) + 1;
            int randomNumbe2 = random.nextInt(1000) + 1;
            producto.nuevo("Producto " + randomNumber, randomNumbe2);
            System.out.println("Se ingreso el: " + producto.getName());
            registro.push(producto, randomNumbe2);
            arbol.insertar(producto);
        }
    }

    public void venta(Arbol arbol, Scanner entrada, Lista registro) {
        String nombre;
        do {
            System.out.print("Nombre del producto (0 para salir): ");
            nombre = entrada.nextLine();
            nombre = entrada.nextLine();
            if (nombre != "") {
                try {
                    NodoBinario<Producto> nodo = arbol.buscar(nombre);
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
                        registro.push(nodo.getElemento(), (-cantidad));
                        // Falta añadir la venta al registro de la lista
                    }

                } catch (Exception e) {
                    System.out.println("El nombre no ha sido encontrado en el stock");
                }

            }
        } while (nombre != "");
    }

    public Lista registro(Lista registro) {
        Lista aux = registro;
        registro.imprimir();
        return aux;
    }
}
