package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {
    private Producto producto;
    private int cantidad;
    private String fecha;

    public Registro(Producto producto, int cantidad) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = formatter.format(date);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha(){
        return fecha;
    }

    public void imprimirElemento() {
        System.out.println(fecha +" "+producto.getName()+" cantidad: " + cantidad);
    }
}
