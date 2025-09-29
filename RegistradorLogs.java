
package comdiegocano.patrones;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RegistradorLogs implements ObservadorAlerta {
    private List<String> logs = new ArrayList<>();
    
    @Override
    public void actualizar(Alerta alerta) {
        String logEntry = String.format("[%s] %s - %s", 
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(alerta.getFechaHora()),
            alerta.getNivel(),
            alerta.getMensaje());
        
        logs.add(logEntry);
        System.out.println("📝 REGISTRANDO LOG - " + logEntry);
    }
    
    @Override
    public String obtenerTipoObservador() {
        return "RegistradorLogs";
    }
    
    public List<String> obtenerLogs() {
        return new ArrayList<>(logs);
    }
}
