package comdiegocano.patrones;

import java.util.Date;

public class EstrategiaAnalisisCalidadAire implements EstrategiaAnalisis{
 @Override
    public Alerta analizar(Sensor sensor) {
        if (!"calidadAire".equals(sensor.getTipo())) return null;

        double valor = sensor.getValor();
        if (valor > 200) {
            return new Alerta(sensor.getId(),
                "❌ CALIDAD DEL AIRE CRÍTICA: " + valor,
                NivelAlerta.CRITICO, new Date());
        } else if (valor > 100) {
            return new Alerta(sensor.getId(),
                "⚠️ Calidad del aire moderada: " + valor,
                NivelAlerta.ADVERTENCIA, new Date());
        }
        return null;
    }
}
