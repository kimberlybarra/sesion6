package Modelo;

public class Enemigo extends Jugador {
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        super(nombre, salud, nivel); 
        this.tipo = tipo;
    }

    @Override
    public void atacar(Jugador objetivo) {
    }
}
