package controlador;

import modelo.Reseña;
import modelo.Usuario;
import modelo.Compra;

import java.util.ArrayList;
import java.util.List;

public class ControladorReseña {
    private List<Reseña> reseñas;

    public ControladorReseña() {
        this.reseñas = new ArrayList<>();
    }

    public void agregarReseña(Usuario usuario, Compra compra, String comentario, int calificacion) {
        Reseña reseña = new Reseña(compra.getProducto(), comentario, calificacion);
        reseñas.add(reseña);
        System.out.println("Reseña agregada: " + reseña);
    }

    public List<Reseña> getReseñas() {
        return reseñas;
    }
}

