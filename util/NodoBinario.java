package util;

import clases.Producto;

public class NodoBinario<Producto> {
    private Producto elemento;
    private int altura;
    private NodoBinario<Producto> left;
    private NodoBinario<Producto> right;

    public NodoBinario(Producto producto) {
        this.elemento = producto;
        this.left = null;
        this.right = null;
        this.altura = 0;
    }

    public void setVal(Producto x){
        elemento = x;
    }

    public void setLeft(NodoBinario<Producto> x){
        this.left = x;
    }

    public void setRig(NodoBinario<Producto> x){
        this.right = x;
    }

    public Producto getElemento(){
        return elemento;
    }

    public NodoBinario<Producto> getLeft(){
        return left;
    }

    public NodoBinario<Producto> getRight(){
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

    public void setRight(NodoBinario<Producto> right) {
        this.right = right;
    }
}
