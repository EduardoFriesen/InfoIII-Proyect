package util;

import clases.Producto;

public class Arbol {
    Nodo<Producto> root;
    public LinkedList<String> listaStock = new LinkedList<String>();
    public Arbol() {
        this.root = null;
    }

    // Insertar nodo
    public void insertar(Producto val) {
        this.root = insertar(this.root, val);
    }

    private Nodo<Producto> insertar(Nodo<Producto> actual, Producto val) {
        if (actual == null) {
            return new Nodo(val);
        }
        if (val.getName().compareTo(((Producto) actual.getElemento()).getName()) < 0) {
            actual.setLeft(insertar(actual.getLeft(), val));
        } else if (val.getName().compareTo(actual.getElemento().getName()) > 0) {
            actual.setRig(insertar(actual.getRight(), val));
        } else {
            return actual;
        }
        actualizarAltura(actual);
        listaStock.add(actual.getElemento().getName());
        return rotacion(actual);
    }
    
    // Eliminar nodo
    public void eliminar(String val) {
        Nodo<Producto> buscado = buscar(val);
        this.root = eliminar(this.root, buscado.getElemento());
    }

    private Nodo<Producto> eliminar(Nodo<Producto> actual, Producto val) {
        if (actual == null) {
            return null;
        }
        if (val.getName().compareTo(actual.getElemento().getName()) < 0) {
            actual.setLeft(insertar(actual.getLeft(), val));
        } else if (val.getName().compareTo(actual.getElemento().getName()) > 0) {
            actual.setRig(eliminar(actual.getRight(), val));
        } else {
            if (actual.getLeft() == null && actual.getRight() == null) {
                return null;
            }

            if (actual.getLeft() == null) {
                return actual.getRight();
            }

            if (actual.getRight() == null) {
                return actual.getLeft();
            }

            Producto smallestValue = menor(actual.getRight());
            actual.setVal(smallestValue);
            actual.setRig(eliminar(actual.getRight(), smallestValue));
        }
        actualizarAltura(actual);
        listaStock.remove(val.getName());
        return rotacion(actual);
    }

    private Producto menor(Nodo<Producto> actual) {
        Producto smallestValue = actual.getElemento();
        while (actual.getLeft() != null) {
            smallestValue = actual.getLeft().getElemento();
            actual = actual.getLeft();
        }
        return smallestValue;
    }

    // Encontrar nodo
    public Nodo<Producto> buscar(String val) {
        return buscar(this.root, val);
    }

    private Nodo<Producto> buscar(Nodo<Producto> actual, String val) {
        if (actual == null) {
            System.out.println("El elemento " + val + " no existe");
            return null;
        }

        if (actual.getElemento().getName().compareTo(val) > 0) {
            return buscar(actual.getLeft(), val);
        } else if (actual.getElemento().getName().compareTo(val) < 0) {
            return buscar(actual.getRight(), val);
        } else {
            return actual;
        }
    }

    public void imprimir(){
        imprimir(root);
    }

    public static void imprimir(Nodo<Producto> root) {
    if (root == null)
        return;
    imprimir(root.getLeft());
    System.out.println(root.getElemento().getName() + " cantidad: " + root.getElemento().getCantidad());
    imprimir(root.getRight());
    }

    public void imprimirNodo(Nodo<Producto> nodo){
        System.out.println(nodo.getElemento().getName() + " cantidad: " + root.getElemento().getCantidad());
    }

    private void actualizarAltura(Nodo<Producto> node) {
        int maxHeight = Math.max(
                altura(node.getLeft()),
                altura(node.getRight())
        );
        node.setAltura(maxHeight + 1);
    }

    private int balance(Nodo<Producto> node) {
        return node != null ? altura(node.getLeft()) - altura(node.getRight()) : 0;
    }

    private int altura(Nodo<Producto> node) {
        return node != null ? node.getAltura() : 0;
    }

    private Nodo<Producto> rotacion(Nodo<Producto> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeft()) < 0) {
                node.setLeft(rotacionIzquierda(node.getLeft()));
            }
            return rotacionDerecha(node);
        }
        if (balance < -1) {
            if (balance(node.getRight()) > 0) {
                node.setRight(rotacionDerecha(node.getRight()));
            }
            return rotacionIzquierda(node);
        }
        return node;
    }

    private Nodo<Producto> rotacionDerecha(Nodo<Producto> node) {
        Nodo<Producto> nodoIzquierdo = node.getLeft();
        Nodo<Producto> nodoCentral = nodoIzquierdo.getRight();
        nodoIzquierdo.setRight(node);
        node.setLeft(nodoCentral);
        actualizarAltura(node);
        actualizarAltura(nodoIzquierdo);
        return nodoIzquierdo;
    }

    private Nodo<Producto> rotacionIzquierda(Nodo<Producto> node) {
        Nodo<Producto> rightNode = node.getRight();
        Nodo<Producto> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        actualizarAltura(node);
        actualizarAltura(rightNode);
        return rightNode;
    }
}
