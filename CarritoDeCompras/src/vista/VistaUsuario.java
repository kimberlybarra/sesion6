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
        int opcion;

        do {
            System.out.println("Seleccione una opción: 1. Registro 2. Iniciar sesión");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                String email;
                do {
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    if (!validarEmail(email)) {
                        System.out.println("El email no es válido. Debe contener un '@'. Inténtelo nuevamente.");
                    }
                } while (!validarEmail(email));

                System.out.print("Contraseña: ");
                String contrasena = scanner.nextLine();
                controladorUsuario.registrarUsuario(nombre, email, contrasena);
                System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
            } else if (opcion == 2) {
                String email;
                do {
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    if (!validarEmail(email)) {
                        System.out.println("El email no es válido. Debe contener un '@'. Inténtelo nuevamente.");
                    }
                } while (!validarEmail(email));

                System.out.print("Contraseña: ");
                String contrasena = scanner.nextLine();

                if (!controladorUsuario.iniciarSesion(email, contrasena)) {
                    System.out.println("Inicio de sesión fallido. Verifique su email y contraseña o regístrese si no lo ha hecho.");
                } else {
                    System.out.println("Inicio de sesión exitoso.");
                    return;
                }
            } else {
                System.out.println("Opción no válida.");
            }
        } while (true);
    }

    private boolean validarEmail(String email) {
        return email.contains("@");
    }
}
