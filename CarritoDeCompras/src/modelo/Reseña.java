package modelo;

public class Reseña {
    private Producto producto;
    private String comentario;
    private int calificacion;

    public Reseña(Producto producto, String comentario, int calificacion) {
        this.producto = producto;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Reseña de " + producto.getNombre() + ": " + comentario + " (Calificación: " + calificacion + ")";
    }
}
