package com.bryja.samochody.klasy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity


public class Jazdy  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;
    public int dlugie;
    public int przecietne;
    public int rzadke;


    public Jazdy() {
    }

    public Jazdy(int dlugie, int przecietne, int rzadke) {
        this.dlugie = dlugie;
        this.przecietne = przecietne;
        this.rzadke = rzadke;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDlugie() {
        return dlugie;
    }

    public void setDlugie(int dlugie) {
        this.dlugie = dlugie;
    }

    public int getPrzecietne() {
        return przecietne;
    }

    public void setPrzecietne(int przecietne) {
        this.przecietne = przecietne;
    }

    public int getRzadke() {
        return rzadke;
    }

    public void setRzadke(int rzadke) {
        this.rzadke = rzadke;
    }


}
