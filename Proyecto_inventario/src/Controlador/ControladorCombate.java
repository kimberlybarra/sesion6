package Controlador;

import Modelo.Jugador;
import Modelo.Enemigo;
import Vista.CombateView;

import java.util.List;
import java.util.Random;

public class ControladorCombate {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private CombateView vista;
    private Random random;

    public ControladorCombate(Jugador jugador, List<Enemigo> enemigos, CombateView vista) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.vista = vista;
        this.random = new Random();
    }

    public void iniciarCombate() {
        while (jugador.getSalud() > 0 && !enemigos.isEmpty()) {
            // Turno del jugador
            vista.mostrarEstado(jugador, enemigos);
            jugadorAtacar();

            // Turno de los enemigos
            for (Enemigo enemigo : enemigos) {
                if (enemigo.getSalud() > 0) {
                    enemigoAtacar(enemigo);
                }
            }

            // Eliminar enemigos derrotados
            enemigos.removeIf(enemigo -> enemigo.getSalud() <= 0);
        }

        // Final del combate
        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("¡El jugador ha sido derrotado!");
        } else {
            vista.mostrarMensaje("¡Todos los enemigos han sido derrotados!");
        }
    }

    private void jugadorAtacar() {
        // El jugador elige a qué enemigo atacar (puedes modificar para recibir input)
        Enemigo enemigo = enemigos.get(random.nextInt(enemigos.size())); // Ataque aleatorio a un enemigo
        jugador.atacar(enemigo);
        if (enemigo.getSalud() <= 0) {
            vista.mostrarMensaje(enemigo.getNombre() + " ha sido derrotado.");
        }
    }

    private void enemigoAtacar(Enemigo enemigo) {
        int danio = random.nextInt(10) + 1; // Daño aleatorio del enemigo
        jugador.recibirDanio(danio);
        vista.mostrarMensaje(enemigo.getNombre() + " ataca a " + jugador.getNombre() + " y causa " + danio + " de daño.");
    }
}
