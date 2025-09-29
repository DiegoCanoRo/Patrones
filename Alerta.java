
package comdiegocano.patrones;

import java.util.Date;

public class Alerta {
    private String idSensor;
    private String mensaje;
    private NivelAlerta nivel;
    private Date fechaHora;
    
    public Alerta(String idSensor, String mensaje, NivelAlerta nivel, Date fechaHora) {
        this.idSensor = idSensor;
        this.mensaje = mensaje;
        this.nivel = nivel;
        this.fechaHora = fechaHora;
    }
    
    // Getters
    public String getIdSensor() { return idSensor; }
    public String getMensaje() { return mensaje; }
    public NivelAlerta getNivel() { return nivel; }
    public Date getFechaHora() { return fechaHora; }
}
