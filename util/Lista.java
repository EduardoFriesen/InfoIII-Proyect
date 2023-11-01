package util;

import clases.Producto;
import clases.Registro;

public class Lista {
    private Nodo<Registro> primero = null;
    private Nodo<Registro> ultimo = null;
    /**
     * Agrega el parametro a la pila
     * @param element
     */
    public void push(Producto element, int cantidad){
        Registro elemento = new Registro(element, cantidad);
        Nodo<Registro> newNodo = new Nodo<Registro>(elemento);
        if(this.isEmpty()){
            primero = newNodo;  
            primero.setNext(ultimo);
        }else{
            ultimo.setNext(newNodo);
        }
            ultimo = newNodo;
    }
    /**
     * Borramos y mostramos el ultimo elemento.
     * @return
     */
    public Registro pop(){
        Registro element = primero.getData();
        if(primero == null) return null;
        primero = primero.getNext();
        return element;
    }
    /**
     * Muestra el ultimo elemento
     * @return
     */
    public Registro top(){
        return primero.getData();
    }
    /**
     * Verifica si la pila esta vacia
     * @return
     */
    public boolean isEmpty(){
        return this.primero == null ? true : false; 

    }

    public int size(){
        int count = 0;
        Nodo<Registro> actual = this.primero;
        while (actual !=null ){
            count++;
            actual = actual.getNext();
        }
        return count;
    }
    /**
     * Vacia la pila.
     */
    public void makeEmpty(){
        this.primero = null;
    }

    public void imprimir(){ 
        Nodo<Registro> actual = this.primero;
        while (actual!=null ){
            actual.getData().imprimirElemento();
            actual = actual.getNext();
        }
    }

}