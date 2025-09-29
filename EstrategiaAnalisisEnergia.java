
package comdiegocano.patrones;

import java.util.Date;

public class EstrategiaAnalisisEnergia implements EstrategiaAnalisis {
    private static final double UMBRAL_ENERGIA = 1000.0;
    
    @Override
    public Alerta analizar(Sensor sensor) {
        if (!"energia".equals(sensor.getTipo())) return null;
        
        double valor = sensor.getValor();
        if (valor > UMBRAL_ENERGIA) {
            return new Alerta(sensor.getId(),
                "💡 ALTO CONSUMO ENERGÉTICO: " + valor + " kW en " + sensor.getUbicacion(),
                NivelAlerta.ADVERTENCIA, new Date());
        }
        return null;
    }
}

