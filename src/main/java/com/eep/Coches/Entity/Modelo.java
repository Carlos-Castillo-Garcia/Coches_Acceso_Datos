package com.eep.Coches.Entity;

import javax.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idmodelo;
    @Column(name = "modelo")
    String modelo;
    @Column(name = "idmarca")
    int idmarca;

    public Modelo() {
    }
    public Modelo(int idmodelo, String modelo, int idmarca) {
        this.idmodelo = idmodelo;
        this.modelo = modelo;
        this.idmarca = idmarca;
    }

    public int getIdmodelo() {
        return idmodelo;
    }
    public String getModelo() {
        return modelo;
    }
    public int getId_marca() {
        return idmarca;
    }

    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setId_marca(int idmarca) {
        this.idmarca = idmarca;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Modelo{");
        sb.append("id=").append(idmodelo);
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", id_marca=").append(idmarca);
        sb.append('}');
        return sb.toString();
    }
}
