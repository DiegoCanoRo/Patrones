
package comdiegocano.patrones;

public class EstrategiaAnalisisBasica implements EstrategiaAnalisis {
    @Override
    public Alerta analizar(Sensor sensor) {
        // Estrategia básica que no genera alertas
        return null;
    }
}
