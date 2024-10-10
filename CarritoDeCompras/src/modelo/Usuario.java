package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombreUsuario;
    private String contraseña;
    private List<Compra> comprasRealizadas;

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.comprasRealizadas = new ArrayList<>();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<Compra> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void agregarCompra(Compra compra) {
        comprasRealizadas.add(compra);
    }

    public boolean verificarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

	public String getHistorialCompras() {
		// TODO Auto-generated method stub
		return null;
	}
}
