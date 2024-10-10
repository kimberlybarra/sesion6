package Modelo;

public class Item {
	private String nombre;
    private int cantidad;
    private String tipo; // Puede ser "Arma" o "Poción"
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void usarItem() {
        // Lógica para usar el ítem
    }
}
