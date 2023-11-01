package util;

import clases.Producto;

public class Arbol {
    NodoBinario<Producto> root;
    public Arbol() {
        this.root = null;
    }

    // Insertar nodo
    public void insertar(Producto val) {
        this.root = insertar(this.root, val);
    }

    private NodoBinario<Producto> insertar(NodoBinario<Producto> actual, Producto val) {
        if (actual == null) {
            return new NodoBinario(val);
        }
        if (val.getName().compareTo(((Producto) actual.getElemento()).getName()) < 0) {
            actual.setLeft(insertar(actual.getLeft(), val));
        } else if (val.getName().compareTo(actual.getElemento().getName()) > 0) {
            actual.setRig(insertar(actual.getRight(), val));
        } else {
            return actual;
        }
        actualizarAltura(actual);
        return rotacion(actual);
    }
    
    // Eliminar nodo
    public void eliminar(String val) {
        NodoBinario<Producto> buscado = buscar(val);
        this.root = eliminar(this.root, buscado.getElemento());
    }

    private NodoBinario<Producto> eliminar(NodoBinario<Producto> actual, Producto val) {
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
        return rotacion(actual);
    }

    private Producto menor(NodoBinario<Producto> actual) {
        Producto smallestValue = actual.getElemento();
        while (actual.getLeft() != null) {
            smallestValue = actual.getLeft().getElemento();
            actual = actual.getLeft();
        }
        return smallestValue;
    }

    // Encontrar nodo
    public NodoBinario<Producto> buscar(String val) {
        return buscar(this.root, val);
    }

    private NodoBinario<Producto> buscar(NodoBinario<Producto> actual, String val) {
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

    public static void imprimir(NodoBinario<Producto> root) {
    if (root == null)
        return;
    imprimir(root.getLeft());
    System.out.println(root.getElemento().getName() + " cantidad: " + root.getElemento().getCantidad());
    imprimir(root.getRight());
    }

    public void imprimirNodo(NodoBinario<Producto> nodo){
        System.out.println(nodo.getElemento().getName() + " cantidad: " + nodo.getElemento().getCantidad());
    }

    private void actualizarAltura(NodoBinario<Producto> node) {
        int maxHeight = Math.max(
                altura(node.getLeft()),
                altura(node.getRight())
        );
        node.setAltura(maxHeight + 1);
    }

    private int balance(NodoBinario<Producto> node) {
        return node != null ? altura(node.getLeft()) - altura(node.getRight()) : 0;
    }

    private int altura(NodoBinario<Producto> node) {
        return node != null ? node.getAltura() : 0;
    }

    private NodoBinario<Producto> rotacion(NodoBinario<Producto> node) {
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

    private NodoBinario<Producto> rotacionDerecha(NodoBinario<Producto> node) {
        NodoBinario<Producto> nodoIzquierdo = node.getLeft();
        NodoBinario<Producto> nodoCentral = nodoIzquierdo.getRight();
        nodoIzquierdo.setRight(node);
        node.setLeft(nodoCentral);
        actualizarAltura(node);
        actualizarAltura(nodoIzquierdo);
        return nodoIzquierdo;
    }

    private NodoBinario<Producto> rotacionIzquierda(NodoBinario<Producto> node) {
        NodoBinario<Producto> rightNode = node.getRight();
        NodoBinario<Producto> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        actualizarAltura(node);
        actualizarAltura(rightNode);
        return rightNode;
    }
}
