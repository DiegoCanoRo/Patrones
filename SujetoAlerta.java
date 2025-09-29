
package comdiegocano.patrones;

// Interfaz Sujeto
public interface SujetoAlerta {
    void registrarObservador(ObservadorAlerta observador);
    void eliminarObservador(ObservadorAlerta observador);
    void notificarObservadores(Alerta alerta);
}
