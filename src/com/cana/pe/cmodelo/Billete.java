
package com.cana.pe.cmodelo;


public class Billete {
    private int id_billete;
    private int id_cliente;
    private int id_compañia;
    private String fecha;
    private String hora;
    private String itinerario;
    private int numero_billete;

    public int getId_billete() {
        return id_billete;
    }

    public void setId_billete(int id_billete) {
        this.id_billete = id_billete;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_compañia() {
        return id_compañia;
    }

    public void setId_compañia(int id_compañia) {
        this.id_compañia = id_compañia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public int getNumero_billete() {
        return numero_billete;
    }

    public void setNumero_billete(int numero_billete) {
        this.numero_billete = numero_billete;
    }
    
    
    
}
