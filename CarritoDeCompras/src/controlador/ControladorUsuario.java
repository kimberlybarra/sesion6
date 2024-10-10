package controlador;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public ControladorUsuario() {
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(String nombre, String email, String contraseña) {
        Usuario nuevoUsuario = new Usuario(nombre, email, contraseña);
        usuarios.add(nuevoUsuario);
        System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
    }

    public boolean iniciarSesion(String email, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.verificarContraseña(contraseña)) {
                usuarioActual = usuario;
                return true; // Inicio de sesión exitoso
            }
        }
        return false; // Fallo en el inicio de sesión
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
