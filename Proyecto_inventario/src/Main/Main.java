package Main;

import Modelo.*;
import Controlador.*;
import Vista.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear un inventario de armas
        List<Item> armas = new ArrayList<>();
        armas.add(new Item("Espada", 1, "Arma", "Una espada afilada."));
        armas.add(new Item("Hacha", 1, "Arma", "Un hacha pesada."));
        armas.add(new Item("Arco", 1, "Arma", "Un arco y flechas."));
        
        // Elegir rol
        System.out.println("Elige tu rol (1 - Héroe, 2 - Enemigo): ");
        int rol = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Jugador jugador = null;

        // Si elige ser un héroe
        if (rol == 1) {
            System.out.println("Eres un héroe. Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            jugador = new Jugador(nombre, 100, 1);
            System.out.println("Selecciona un arma:");
            for (int i = 0; i < armas.size(); i++) {
                System.out.println((i + 1) + ". " + armas.get(i).getNombre());
            }
            int armaSeleccionada = scanner.nextInt() - 1;
            jugador.getInventario().agregarItem(armas.get(armaSeleccionada));
            jugador.equiparObjeto(armas.get(armaSeleccionada));
            
        } else if (rol == 2) { 
            // Si elige ser un enemigo
            System.out.println("Eres un enemigo. Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            Enemigo enemigo = new Enemigo(nombre, 50, 1, "Bajo");
            // No hay arma para enemigos en este ejemplo
            jugador = enemigo; // Asignamos a jugador solo para el flujo del programa
        } else {
            System.out.println("Rol no válido.");
            return;
        }

        // Crear enemigos (si el jugador es héroe)
        List<Enemigo> enemigos = new ArrayList<>();
        if (rol == 1) { // Solo crear enemigos si el jugador es un héroe
            enemigos.add(new Enemigo("Orco", 50, 1, "Bajo"));
            enemigos.add(new Enemigo("Goblin", 30, 1, "Bajo"));
        }

        // Crear la vista y el controlador de combate
        CombateView vista = new CombateView();
        ControladorCombate controlador = new ControladorCombate(jugador, enemigos, vista);
        
        // Iniciar el combate
        controlador.iniciarCombate();
    }
}

