package com.bryja.samochody.klasy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Rodzina  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;
    public int samotnik;
    public int osoby24;
    public int osoby5plus;

    public Rodzina() {
    }

    public Rodzina(int samotnik, int osoby24, int osoby5plus) {
        this.samotnik = samotnik;
        this.osoby24 = osoby24;
        this.osoby5plus = osoby5plus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSamotnik() {
        return samotnik;
    }

    public void setSamotnik(int samotnik) {
        this.samotnik = samotnik;
    }

    public int getOsoby24() {
        return osoby24;
    }

    public void setOsoby24(int osoby24) {
        this.osoby24 = osoby24;
    }

    public int getOsoby5plus() {
        return osoby5plus;
    }

    public void setOsoby5plus(int osoby5plus) {
        this.osoby5plus = osoby5plus;
    }

}
