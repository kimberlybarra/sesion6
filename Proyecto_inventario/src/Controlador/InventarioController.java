package Controlador;

import Modelo.InventarioModel;
import Modelo.Item;
import Vista.InventarioView;

public class InventarioController {
	private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.agregarItem(item);
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void eliminarItem(Item item) {
        modelo.eliminarItem(item);
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void buscarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarDetalles(item);
        } else {
            vista.mostrarMensaje("Ítem no encontrado.");
        }
    }
}
