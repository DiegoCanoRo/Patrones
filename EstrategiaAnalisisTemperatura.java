package comdiegocano.patrones;

// Estrategias Concretas

import java.util.Date;

public class EstrategiaAnalisisTemperatura implements EstrategiaAnalisis {
    @Override
    public Alerta analizar(Sensor sensor) {
        if (!"temperatura".equals(sensor.getTipo())) return null;
        
        double valor = sensor.getValor();
        if (valor > 80.0) {
            return new Alerta(sensor.getId(), 
                "❌ TEMPERATURA CRÍTICA: " + valor + "°C en " + sensor.getUbicacion(), 
                NivelAlerta.CRITICO, new Date());
        } else if (valor > 60.0) {
            return new Alerta(sensor.getId(),
                "⚠️ Temperatura alta: " + valor + "°C en " + sensor.getUbicacion(),
                NivelAlerta.ADVERTENCIA, new Date());
        }
        return null;
    }
}
