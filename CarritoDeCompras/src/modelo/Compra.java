package modelo;

public class Compra {
	 private Carrito carrito;

	    public Compra(Carrito carrito) {
	        this.carrito = carrito;
	    }

	    public void realizarCompra() {
	        double total = carrito.calcularTotal();
	        System.out.println("Compra realizada. Total: $" + total);
	        carrito = new Carrito(); // Reiniciar el carrito después de la compra
	    }

		public Producto getProducto() {
			// TODO Auto-generated method stub
			return null;
		}

}

