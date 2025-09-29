package comdiegocano.patrones;

import java.util.Date;


public class EstrategiaAnalisisVibracion implements EstrategiaAnalisis {
    @Override
    public Alerta analizar(Sensor sensor) {
        if (!"vibracion".equals(sensor.getTipo())) return null;
        
        double valor = sensor.getValor();
        if (valor > 5.0) {
            return new Alerta(sensor.getId(),
                "🚨 VIBRACIÓN PELIGROSA: " + valor + " m/s² en " + sensor.getUbicacion(),
                NivelAlerta.CRITICO, new Date());
        } else if (valor > 3.0) {
            return new Alerta(sensor.getId(),
                "📳 Vibración elevada: " + valor + " m/s² en " + sensor.getUbicacion(),
                NivelAlerta.ADVERTENCIA, new Date());
        }
        return null;
    }
}
