package vista;

import controlador.ControladorCarrito;
import modelo.Compra;

import java.util.Scanner;

public class VistaCarrito {
    private ControladorCarrito controladorCarrito;

    public VistaCarrito(ControladorCarrito controladorCarrito) {
        this.controladorCarrito = controladorCarrito;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n Menú del carrito de compras:");
            System.out.println("1. Listar productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Eliminar producto del carrito");
            System.out.println("5. Realizar compra");
            System.out.println("6. Ver historial de compras");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    controladorCarrito.listarProductos();
                    break;
                case 2:
                    System.out.print("\n Ingrese el índice del producto a agregar: ");
                    int indiceAgregar = scanner.nextInt();
                    controladorCarrito.agregarProductoAlCarrito(indiceAgregar);
                    break;
                case 3:
                    controladorCarrito.verCarrito();
                    break;
                case 4:
                    System.out.print("\n Ingrese el índice del producto a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    controladorCarrito.eliminarProductoDelCarrito(indiceEliminar);
                    break;
                case 5:
                    controladorCarrito.realizarCompra();
                    break;
                case 6:
                    mostrarHistorialDeCompras();
                    break;
                case 7:
                    System.out.println("\n Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);
    }

    public void mostrarHistorialDeCompras() {
        if (controladorCarrito.getUsuario().getComprasRealizadas().isEmpty()) {
            System.out.println("\nNo tiene compras en su historial.");
        } else {
            System.out.println("\nHistorial de compras:");
            int i = 0;
            for (Compra compra : controladorCarrito.getUsuario().getComprasRealizadas()) {
                System.out.println(i + ": " + compra.getProducto().getNombre() + " - $" + compra.getProducto().getPrecio());
                i++;
            }
        }
    }
}
