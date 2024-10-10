package Vista;

import Modelo.Jugador;
import Modelo.Enemigo;

import java.util.List;

public class CombateView {
    public void mostrarEstado(Jugador jugador, List<Enemigo> enemigos) {
        System.out.println("Estado del Combate:");
        System.out.println(jugador.getNombre() + " - Salud: " + jugador.getSalud());
        for (Enemigo enemigo : enemigos) {
            System.out.println(enemigo.getNombre() + " - Salud: " + enemigo.getSalud());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
