package com.bryja.samochody.klasy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity

public class Bagaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;
    public int maly;
    public int sredni;
    public int duzy;



    public Bagaz() {
    }

    public Bagaz(int maly, int sredni, int duzy) {
        this.maly = maly;
        this.sredni = sredni;
        this.duzy = duzy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaly() {
        return maly;
    }

    public void setMaly(int maly) {
        this.maly = maly;
    }

    public int getSredni() {
        return sredni;
    }

    public void setSredni(int sredni) {
        this.sredni = sredni;
    }

    public int getDuzy() {
        return duzy;
    }

    public void setDuzy(int duzy) {
        this.duzy = duzy;
    }


}
