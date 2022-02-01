package com.eep.Coches.Entity;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "marca")
    String marca;

    public Marca() {
    }
    public Marca(Long id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }
    public String getMarca() {
        return marca;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marca{");
        sb.append("id=").append(id);
        sb.append(", marca='").append(marca).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
