package util;

import clases.Registro;

public class Nodo<Registro> {
    private Nodo<Registro> next;
    private Registro registro;
    

    public Nodo(Registro elemento) {
        this.registro = elemento;
        this.next = null;
    }

    public Registro getData() {
        return registro;
    }

    public Nodo<Registro> getNext() {
        return next;
    }

    public void setNext(Nodo<Registro> next) {
        this.next = next;
    }

    public void setData(Registro data) {
        this.registro = data;
    }
    
}