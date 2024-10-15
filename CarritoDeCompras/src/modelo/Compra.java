package modelo;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private Producto producto; 
    private static List<Compra> comprasRealizadas = new ArrayList<>(); 

    public Compra(Producto producto) {
        this.producto = producto;
    }

    public void realizarCompra() {
        System.out.println("Compra realizada: " + producto.getNombre() + " - $" + producto.getPrecio());
        comprasRealizadas.add(this); 
    }

    public Producto getProducto() {
        return producto; 
    }

    public static List<Compra> getComprasRealizadas() {
        return comprasRealizadas;
    }
}
