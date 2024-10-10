package Main;

import vista.VistaCarrito;
import vista.VistaUsuario;
import vista.VistaReseña;
import controlador.ControladorCarrito;
import controlador.ControladorUsuario;
import controlador.ControladorReseña;

public class Main {
    public static void main(String[] args) {
        // Crear los controladores necesarios
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ControladorReseña controladorReseña = new ControladorReseña();

        // Crear la vista para manejar la autenticación de usuarios
        VistaUsuario vistaUsuario = new VistaUsuario(controladorUsuario);

        // Mostrar el menú de autenticación
        vistaUsuario.mostrarMenuAutenticacion();

        // Verificar si el usuario ha iniciado sesión
        if (controladorUsuario.getUsuarioActual() != null) {
            // Crear el controlador del carrito pasando el usuario autenticado
            ControladorCarrito controladorCarrito = new ControladorCarrito(controladorUsuario.getUsuarioActual());

            // Crear la vista del carrito
            VistaCarrito vistaCarrito = new VistaCarrito(controladorCarrito);

            // Menú principal de la aplicación: operaciones del carrito de compras
            vistaCarrito.mostrarMenu(); // Mostrar el menú de la vista del carrito

            // Simulación de realizar una compra
            controladorCarrito.realizarCompra(); // Realizar la compra

            // Después de la compra, permitir al usuario dejar una reseña
            VistaReseña vistaReseña = new VistaReseña(controladorReseña, controladorUsuario);
            vistaReseña.mostrarMenuReseña();
        } else {
            System.out.println("Debe iniciar sesión o registrarse para continuar.");
        }
    }
}
