package vista;

import controlador.ControladorCarrito;
import java.util.Scanner;

public class VistaCarrito {
    public void mostrarMenu(ControladorCarrito controlador) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n Menú del carrito de compras:");
            System.out.println("1. Listar productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Eliminar producto del carrito");
            System.out.println("5. Realizar compra");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    controlador.listarProductos();
                    break;
                case 2:
                    System.out.print("\n Ingrese el índice del producto a agregar: ");
                    int indiceAgregar = scanner.nextInt();
                    controlador.agregarProductoAlCarrito(indiceAgregar);
                    break;
                case 3:
                    controlador.verCarrito();
                    break;
                case 4:
                    System.out.print("\n Ingrese el índice del producto a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    controlador.eliminarProductoDelCarrito(indiceEliminar);
                    break;
                case 5:
                    controlador.realizarCompra();
                    break;
                case 6:
                    System.out.println("\n Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);
        
        scanner.close();
    }
}
