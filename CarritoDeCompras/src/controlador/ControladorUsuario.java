package controlador;

import modelo.Usuario;
import java.util.HashMap; //cada clave se asigna exactamente a un valor
import java.util.Map; //nos permite transformar un objeto en otro a través de una función.

public class ControladorUsuario {
	private Map<String, Usuario> usuariosRegistrados;
    private Usuario usuarioActual;

    public ControladorUsuario() {
        usuariosRegistrados = new HashMap<>();
        usuarioActual = null;
    }

    public boolean registrarUsuario(String nombreUsuario, String contraseña) {
        if (!usuariosRegistrados.containsKey(nombreUsuario)) {
            Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);
            usuariosRegistrados.put(nombreUsuario, nuevoUsuario);
            return true;
        }
        return false;
    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        Usuario usuario = usuariosRegistrados.get(nombreUsuario);
        if (usuario != null && usuario.verificarContraseña(contraseña)) {
            usuarioActual = usuario;
            return true;
        }
        return false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}
