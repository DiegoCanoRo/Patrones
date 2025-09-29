
package comdiegocano.patrones;

public class NotificadorSMS implements ObservadorAlerta {
    @Override
    public void actualizar(Alerta alerta) {
        if (alerta.getNivel() == NivelAlerta.CRITICO) {
            System.out.println("📱 ENVIANDO SMS CRÍTICO - " + alerta.getMensaje());
        }
    }
    
    @Override
    public String obtenerTipoObservador() {
        return "NotificadorSMS";
    }
}
