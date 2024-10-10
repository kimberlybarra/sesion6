package Modelo;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item objetoEquipado;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
        this.objetoEquipado = null;
    }

    public void equiparObjeto(Item item) {
        if (item.getTipo().equals("Arma")) {
            this.objetoEquipado = item;
        }
    }

    public void atacar(Enemigo enemigo) {
        if (objetoEquipado != null) {
            // El daño puede ser diferente dependiendo del arma
            int danio = 10; // Ejemplo de daño fijo
            enemigo.recibirDanio(danio);
        }
    }

    public void recibirDanio(int danio) {
        this.salud -= danio;
        if (this.salud < 0) this.salud = 0;
    }

    public int getSalud() {
        return salud;
    }

    public String getNombre() {
        return nombre;
    }

    public InventarioModel getInventario() {
        return inventario;
    }

	public void atacar(Jugador objetivo) {
		// TODO Auto-generated method stub
		
	}
}
