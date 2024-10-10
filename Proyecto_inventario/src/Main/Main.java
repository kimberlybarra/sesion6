package Main;

import Controlador.InventarioController;
import Modelo.InventarioModel;
import Modelo.Item;
import Vista.InventarioView;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        Item item1 = new Item("Espada", 10, "Arma", "Una espada afilada.");
        Item item2 = new Item("Poción de Salud", 5, "Poción", "Restaura 50 puntos de salud.");
        
        controlador.agregarItem(item1);
        controlador.agregarItem(item2);
        
        controlador.verInventario();
        
        controlador.buscarItem("Espada");
    }
}
