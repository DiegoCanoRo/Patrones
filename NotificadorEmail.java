
package comdiegocano.patrones;


public class NotificadorEmail implements ObservadorAlerta {
    @Override
    public void actualizar(Alerta alerta) {
        String prefijo = "";
        switch (alerta.getNivel()) {
            case CRITICO: prefijo = "🚨 CRÍTICO - "; break;
            case ADVERTENCIA: prefijo = "⚠️ ADVERTENCIA - "; break;
            case INFORMATIVO: prefijo = "ℹ️ INFORMATIVO - "; break;
        }
        System.out.println("📧 ENVIANDO EMAIL - " + prefijo + alerta.getMensaje());
        // Lógica real de envío de email
    }
    
    @Override
    public String obtenerTipoObservador() {
        return "NotificadorEmail";
    }
}

