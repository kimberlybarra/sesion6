package Main;

import vista.VistaCarrito;
import vista.VistaUsuario;
import vista.VistaReseña;
import controlador.ControladorCarrito;
import controlador.ControladorUsuario;
import controlador.ControladorReseña;

public class Main {
    public static void main(String[] args) {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ControladorReseña controladorReseña = new ControladorReseña();

        VistaUsuario vistaUsuario = new VistaUsuario(controladorUsuario);

        vistaUsuario.mostrarMenuAutenticacion();

        if (controladorUsuario.getUsuarioActual() != null) {
            ControladorCarrito controladorCarrito = new ControladorCarrito(controladorUsuario.getUsuarioActual());

            VistaCarrito vistaCarrito = new VistaCarrito(controladorCarrito);

            vistaCarrito.mostrarMenu(); 

            controladorCarrito.realizarCompra(); 

            VistaReseña vistaReseña = new VistaReseña(controladorReseña, controladorUsuario);
            vistaReseña.mostrarMenuReseña();
        } else {
            System.out.println("Debe iniciar sesión o registrarse para continuar.");
        }
    }
}
