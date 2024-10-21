
package com.cana.pe.cmodelo;


public class Cliente {
    private int id_cliente;
    private String DNI;
    private String Nombre;
    private String Telefeno;
    private String Direccion;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefeno() {
        return Telefeno;
    }

    public void setTelefeno(String Telefeno) {
        this.Telefeno = Telefeno;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

}