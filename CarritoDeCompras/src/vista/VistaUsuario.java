package vista;

import controlador.ControladorUsuario;

import java.util.Scanner;

public class VistaUsuario {
    private ControladorUsuario controladorUsuario;

    public VistaUsuario(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    public void mostrarMenuAutenticacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción: 1. Registro 2. Iniciar sesión");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (opcion == 1) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            controladorUsuario.registrarUsuario(nombre, email);
        } else if (opcion == 2) {
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            controladorUsuario.iniciarSesion(email, contrasena);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
