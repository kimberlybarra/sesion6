package vista;

import controlador.ControladorReseña;
import controlador.ControladorUsuario;
import modelo.Producto;
import modelo.Compra;
import modelo.Usuario;

import java.util.Scanner;

public class VistaReseña {
    private final ControladorReseña controladorReseña;
    private final ControladorUsuario controladorUsuario;

    public VistaReseña(ControladorReseña controladorReseña, ControladorUsuario controladorUsuario) {
        this.controladorReseña = controladorReseña;
        this.controladorUsuario = controladorUsuario;
    }

    public void mostrarMenuReseña() {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = controladorUsuario.getUsuarioActual();

        if (usuario.getComprasRealizadas().isEmpty()) {
            System.out.println("No tiene compras en su historial para dejar reseñas.");
            return;
        }

        System.out.println("Seleccione un producto para dejar una reseña:");
        for (int i = 0; i < usuario.getComprasRealizadas().size(); i++) {
            Compra compra = usuario.getComprasRealizadas().get(i);
            Producto producto = compra.getProducto(); 
            System.out.println(i + ": " + producto.getNombre() + " - $" + producto.getPrecio());
        }

        int opcionProducto;
        opcionProducto = scanner.nextInt();
		scanner.nextLine(); 

		if (opcionProducto >= 0 && opcionProducto < usuario.getComprasRealizadas().size()) {
		    Compra compraSeleccionada = usuario.getComprasRealizadas().get(opcionProducto);
		    Producto productoSeleccionado = compraSeleccionada.getProducto();

		    System.out.println("Ingrese su reseña para el producto " + productoSeleccionado.getNombre() + ":");
		    String comentario = scanner.nextLine();

		    System.out.println("Ingrese una calificación del 1 al 5:");
		    int calificacion = scanner.nextInt();

		    if (calificacion >= 1 && calificacion <= 5) {
		        controladorReseña.agregarReseña(usuario, compraSeleccionada, comentario, calificacion);
		        System.out.println("¡Reseña agregada exitosamente!");
		    } else {
		        System.out.println("Calificación no válida. Debe estar entre 1 y 5.");
		    }
		} else {
		    System.out.println("Opción no válida.");
		}
    }
}
