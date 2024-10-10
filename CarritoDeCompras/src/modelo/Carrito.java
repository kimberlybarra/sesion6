package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
}

