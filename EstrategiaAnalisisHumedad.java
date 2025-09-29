
package comdiegocano.patrones;

import java.util.Date;


public class EstrategiaAnalisisHumedad implements EstrategiaAnalisis {
    @Override
    public Alerta analizar(Sensor sensor) {
        if (!"humedad".equals(sensor.getTipo())) return null;

        double valor = sensor.getValor();
        if (valor > 80) {
            return new Alerta(sensor.getId(),
                "❌ HUMEDAD CRÍTICA: " + valor + "%",
                NivelAlerta.CRITICO, new Date());
        } else if (valor > 60) {
            return new Alerta(sensor.getId(),
                "⚠️ Humedad alta: " + valor + "%",
                NivelAlerta.ADVERTENCIA, new Date());
        }
        return null;
    }
}
