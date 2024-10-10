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
            vista.mostrarEstado(jugador, enemigos);
            jugadorAtacar();

            for (Enemigo enemigo : enemigos) {
                if (enemigo.getSalud() > 0) {
                    enemigoAtacar(enemigo);
                }
            }

            enemigos.removeIf(enemigo -> enemigo.getSalud() <= 0);
        }

        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("¡El jugador ha sido derrotado!");
        } else {
            vista.mostrarMensaje("¡Todos los enemigos han sido derrotados!");
        }
    }

    private void jugadorAtacar() {
        Enemigo enemigo = enemigos.get(random.nextInt(enemigos.size())); 
        jugador.atacar(enemigo);
        if (enemigo.getSalud() <= 0) {
            vista.mostrarMensaje(enemigo.getNombre() + " ha sido derrotado.");
        }
    }

    private void enemigoAtacar(Enemigo enemigo) {
        int danio = random.nextInt(10) + 1; 
        jugador.recibirDanio(danio);
        vista.mostrarMensaje(enemigo.getNombre() + " ataca a " + jugador.getNombre() + " y causa " + danio + " de daño.");
    }
}
