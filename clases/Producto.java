package clases;

public class Producto {
    private String nombre;
    private int cantidad;

    public Producto(){
        this.nombre = "";
        this.cantidad = 0;
    }

    public void setNombre(String name){
        nombre = name;
    }

    public void nuevo(String name, int stock){
        nombre = name;
        cantidad = stock;
    }

    public void setStock(int stock){
        cantidad = stock;
    }

    public String getName(){
        return nombre;
    }

    public int getCantidad(){
        return cantidad;
    }

}
