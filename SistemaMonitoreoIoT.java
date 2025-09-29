/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comdiegocano.patrones;

/**
 *
 * @author diego
 */
public class SistemaMonitoreoIoT {
    public static void main(String[] args) throws InterruptedException {
        // 1️⃣ Obtener instancia del GestorSensores
        GestorSensores gestor = GestorSensores.obtenerInstancia();

        // 2️⃣ Registrar sensores de diferentes tipos
        Sensor sensorTemp = new Sensor("TEMP-001", "temperatura", 25.0, "Sala A");
        Sensor sensorVib = new Sensor("VIB-001", "vibracion", 2.0, "Motor Principal");
        Sensor sensorEnergia = new Sensor("ENER-001", "energia", 800.0, "Subestación");
        Sensor sensorAire = new Sensor("AIRE-001", "calidadAire", 50.0, "Sala B");
        Sensor sensorHumedad = new Sensor("HUM-001", "humedad", 40.0, "Sala C");

        gestor.registrarSensor(sensorTemp);
        gestor.registrarSensor(sensorVib);
        gestor.registrarSensor(sensorEnergia);
        gestor.registrarSensor(sensorAire);
        gestor.registrarSensor(sensorHumedad);

        // 3️⃣ Configurar observadores
        NotificadorAlertas notificador = NotificadorAlertas.obtenerInstancia();
        notificador.registrarObservador(new NotificadorEmail());
        notificador.registrarObservador(new NotificadorSMS());
        notificador.registrarObservador(new RegistradorLogs());

        // 4️⃣ Probar diferentes estrategias de análisis
        // Por defecto se puede usar la básica
        notificador.establecerEstrategiaAnalisis(new EstrategiaAnalisisBasica());

        // 5️⃣ Simular actualizaciones de sensores

        // Temperatura normal
        gestor.actualizarValorSensor("TEMP-001", 45.0);
        Thread.sleep(1000);

        // Temperatura crítica
        notificador.establecerEstrategiaAnalisis(new EstrategiaAnalisisTemperatura());
        gestor.actualizarValorSensor("TEMP-001", 85.0);
        Thread.sleep(1000);

        // Vibración peligrosa
        notificador.establecerEstrategiaAnalisis(new EstrategiaAnalisisVibracion());
        gestor.actualizarValorSensor("VIB-001", 6.5);
        Thread.sleep(1000);

        // Cambio de estrategia a energía
        notificador.establecerEstrategiaAnalisis(new EstrategiaAnalisisEnergia());
        gestor.actualizarValorSensor("ENER-001", 1200.0);
        Thread.sleep(1000);

        // Calidad del aire crítica
        notificador.establecerEstrategiaAnalisis(new EstrategiaAnalisisCalidadAire());
        gestor.actualizarValorSensor("AIRE-001", 250.0);
        Thread.sleep(1000);

        // Humedad alta
        notificador.establecerEstrategiaAnalisis(new EstrategiaAnalisisHumedad());
        gestor.actualizarValorSensor("HUM-001", 75.0);
        Thread.sleep(1000);

        // ✅ Estadísticas finales
        System.out.println("\n=== ESTADÍSTICAS FINALES ===");
        gestor.obtenerEstadisticas();
        System.out.println("Observadores activos: " + notificador.obtenerCantidadObservadores());
    }
}
