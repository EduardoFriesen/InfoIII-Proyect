package clases;

public class Registro {
    private Producto producto;
    private int cantidad;

    public Registro(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
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

    public void imprimirElemento() {
        System.out.println(producto.getName()+" cantidad: " + cantidad);
    }
}
