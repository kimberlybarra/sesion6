package Vista;

import java.util.List;

import Modelo.Item;

public class InventarioView {
	public void mostrarInventario(List<Item> items) {
        System.out.println("Inventario:");
        for (Item item : items) {
            System.out.println("- " + item.getNombre() + " (Cantidad: " + item.getCantidad() + ")");
        }
    }

    public void mostrarDetalles(Item item) {
        System.out.println("Detalles del Ítem:");
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Cantidad: " + item.getCantidad());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripción: " + item.getDescripcion());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
