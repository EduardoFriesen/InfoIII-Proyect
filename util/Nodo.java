package util;

import clases.Producto;

public class Nodo<Producto> {
    private Producto elemento;
    private int altura;
    private Nodo<Producto> left;
    private Nodo<Producto> right;

    public Nodo(Producto producto) {
        this.elemento = producto;
        this.left = null;
        this.right = null;
        this.altura = 0;
    }

    public void setVal(Producto x){
        elemento = x;
    }

    public void setLeft(Nodo<Producto> x){
        this.left = x;
    }

    public void setRig(Nodo<Producto> x){
        this.right = x;
    }

    public Producto getElemento(){
        return elemento;
    }

    public Nodo<Producto> getLeft(){
        return left;
    }

    public Nodo<Producto> getRight(){
        return right;
    }

    public void setElemento(Producto elemento) {
        this.elemento = elemento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setRight(Nodo<Producto> right) {
        this.right = right;
    }
}
