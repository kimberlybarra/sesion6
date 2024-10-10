
package controlador;


import modelo.Producto;
import modelo.Carrito;
import modelo.Compra;
import vista.VistaCarrito;
import java.util.ArrayList;
import java.util.List;


public class ControladorCarrito {
	private List<Producto> productos;
   private Carrito carrito;
   private VistaCarrito vista;
   public ControladorCarrito(VistaCarrito vista) {
       this.productos = new ArrayList<>();
       this.carrito = new Carrito();
       this.vista = vista;
       cargarProductos();
   }
//listar productos
   private void cargarProductos() {
       productos.add(new Producto("Arroz", 5.00));
       productos.add(new Producto("Leche", 2.50));
       productos.add(new Producto("Azucar", 3.50));
       productos.add(new Producto("Huevo", 18.00));
      
   }
   public void listarProductos() {
       System.out.println("\n Productos disponibles:");
       for (int i = 0; i < productos.size(); i++) {
           System.out.println(i + ": " + productos.get(i));
       }
   }
   public void agregarProductoAlCarrito(int index) {
       if (index >= 0 && index < productos.size()) {
           carrito.agregarProducto(productos.get(index));
           System.out.println("\n Producto agregado al carrito.");
       } else {
           System.out.println("\n Índice no válido.");
       }
   }
   public void verCarrito() {
       System.out.println("\n Productos en el carrito:");
       for (Producto p : carrito.getProductos()) {
           System.out.println(p);
       }
       System.out.println("\n Total: $" + carrito.calcularTotal());
   }
   public void eliminarProductoDelCarrito(int index) {
       if (index >= 0 && index < carrito.getProductos().size()) {
           carrito.eliminarProducto(carrito.getProductos().get(index));
           System.out.println("\n Producto eliminado del carrito.");
       } else {
           System.out.println("\n indice no válido.");
       }
   }
   public void realizarCompra() {
       Compra compra = new Compra(carrito);
       compra.realizarCompra();
       carrito = new Carrito(); //reiniciar despues de la compra
   }
}

