package Modelo;

public class Enemigo extends Jugador {
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        super(nombre, salud, nivel); // Llama al constructor de Jugador
        this.tipo = tipo;
    }

    // Métodos específicos para Enemigo
    @Override
    public void atacar(Jugador objetivo) {
        // Lógica de ataque para enemigo
    }
}
