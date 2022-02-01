package com.eep.Coches.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcamodelo")
public class MarcaModelo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "marca")
    String marca;
    @Column(name = "modelo")
    String modelo;


    public MarcaModelo() {
    }
    public MarcaModelo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(marca);
        sb.append(modelo);
        return sb.toString();
    }
}
