package comdiegocano.patrones;

// Interfaz Observador
public interface ObservadorAlerta {
    void actualizar(Alerta alerta);
    String obtenerTipoObservador();
}
