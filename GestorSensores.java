package comdiegocano.patrones;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GestorSensores {

    private static GestorSensores instancia;
    private Map<String, Sensor> sensores;

    private GestorSensores() {
        this.sensores = new ConcurrentHashMap<>();
        System.out.println("🔧 Gestor de Sensores inicializado");
    }

    //se recorre cada sensor en el map sensores y si es el tipo buscado
    //se agrega a la lista
    public List<Sensor> obtenerSensoresPorTipo(String tipo) {
        List<Sensor> sensoresPorTipo = new ArrayList<>();

        for (Sensor sensor : sensores.values()) {
            if (tipo.equalsIgnoreCase(sensor.getTipo())) {
                sensoresPorTipo.add(sensor);
            }
        }
        return sensoresPorTipo;
    }

    public void obtenerEstadisticas() {
        Map<String, Integer> contadorPorTipo = new HashMap<>();
        for (Sensor sensor : sensores.values()) {
            String tipo = sensor.getTipo();
            contadorPorTipo.put(tipo, contadorPorTipo.getOrDefault(tipo, 0) + 1);
        }

        System.out.println("Total de sensores: " + sensores.size());
        for (String tipo : contadorPorTipo.keySet()) {
            System.out.println("Sensores de tipo " + tipo + ": " + contadorPorTipo.get(tipo));
        }
    }

    public static GestorSensores obtenerInstancia() {
        if (instancia == null) {
            synchronized (GestorSensores.class) {
                if (instancia == null) {
                    instancia = new GestorSensores();
                }
            }
        }
        return instancia;
    }

    public void registrarSensor(Sensor sensor) {
        sensores.put(sensor.getId(), sensor);
        System.out.println("✅ Sensor registrado: " + sensor.getId() + " en " + sensor.getUbicacion());
    }

    public void actualizarValorSensor(String idSensor, double nuevoValor) {
        Sensor sensor = sensores.get(idSensor);
        if (sensor != null) {
            sensor.setValor(nuevoValor);
            sensor.setUltimaActualizacion(new Date());
            System.out.println("📊 Sensor " + idSensor + " actualizado: " + nuevoValor);

            // Notificar a los observadores
            NotificadorAlertas.obtenerInstancia().verificarYNotificar(sensor);
        } else {
            System.out.println("❌ Sensor no encontrado: " + idSensor);
        }
    }

    public Sensor obtenerSensor(String idSensor) {
        return sensores.get(idSensor);
    }

    public void eliminarSensor(String idSensor) {
        sensores.remove(idSensor);
        System.out.println("🗑️ Sensor eliminado: " + idSensor);
    }

    public List<Sensor> obtenerTodosSensores() {
        return new ArrayList<>(sensores.values());
    }

    public int obtenerCantidadSensores() {
        return sensores.size();
    }
}
