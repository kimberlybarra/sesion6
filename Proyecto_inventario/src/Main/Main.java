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
        
        List<Item> armas = new ArrayList<>();
        armas.add(new Item("Espada", 1, "Arma", "Una espada afilada."));
        armas.add(new Item("Hacha", 1, "Arma", "Un hacha pesada."));
        armas.add(new Item("Arco", 1, "Arma", "Un arco y flechas."));
        
        System.out.println("Elige tu rol (1 - Héroe, 2 - Enemigo): ");
        int rol = scanner.nextInt();
        scanner.nextLine(); 

        Jugador jugador = null;

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
            System.out.println("Eres un enemigo. Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            Enemigo enemigo = new Enemigo(nombre, 50, 1, "Bajo");
            jugador = enemigo; 
        } else {
            System.out.println("Rol no válido.");
            return;
        }

        List<Enemigo> enemigos = new ArrayList<>();
        if (rol == 1) { 
            enemigos.add(new Enemigo("Orco", 50, 1, "Bajo"));
            enemigos.add(new Enemigo("Goblin", 30, 1, "Bajo"));
        }

        CombateView vista = new CombateView();
        ControladorCombate controlador = new ControladorCombate(jugador, enemigos, vista);
        
        controlador.iniciarCombate();
    }
}

