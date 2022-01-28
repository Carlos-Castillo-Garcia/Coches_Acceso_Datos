package com.eep.Coches.Entity;

public class Coches {

    String nbastidor;
    String modelo;
    String marca;
    int kilometros;
    String motor;
    int modificaciones;
    String tipo_modificaciones;

    public Coches() {
    }

    public Coches(String nbastidor, String modelo, String marca,
                  int kilometros, String motor, int modificaciones, String tipo_modificaciones) {
        this.nbastidor = nbastidor;
        this.modelo = modelo;
        this.marca = marca;
        this.kilometros = kilometros;
        this.motor = motor;
        this.modificaciones = modificaciones;
        this.tipo_modificaciones = tipo_modificaciones;
    }

    public String getNbastidor() {
        return nbastidor;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public int getKilometros() {
        return kilometros;
    }
    public String getMotor() {
        return motor;
    }
    public int getModificaciones() {
        return modificaciones;
    }
    public String getTipo_modificaciones() {
        return tipo_modificaciones;
    }
    public void setNbastidor(String nbastidor) {
        this.nbastidor = nbastidor;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public void setModificaciones(int modificaciones) {
        this.modificaciones = modificaciones;
    }
    public void setTipo_modificaciones(String tipo_modificaciones) {
        this.tipo_modificaciones = tipo_modificaciones;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nbastidor);
        sb.append(modelo);
        sb.append(marca);
        sb.append(kilometros);
        sb.append(motor);
        sb.append(modificaciones);
        sb.append(tipo_modificaciones);

        return sb.toString();
    }
}
