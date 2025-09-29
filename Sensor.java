
package comdiegocano.patrones;

// Entidades del dominio

import java.util.Date;

public class Sensor {
    private String id;
    private String tipo; // "temperatura", "vibracion", "energia"
    private double valor;
    private String ubicacion;
    private Date ultimaActualizacion;
    
    public Sensor(String id, String tipo, double valor, String ubicacion) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.ubicacion = ubicacion;
        this.ultimaActualizacion = new Date();
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public String getUbicacion() { return ubicacion; }
    public Date getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(Date fecha) { this.ultimaActualizacion = fecha; }
}

