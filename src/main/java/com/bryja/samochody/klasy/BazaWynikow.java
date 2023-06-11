package com.bryja.samochody.klasy;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class BazaWynikow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;
    @Column(length=5000)
    String wynik;

    public BazaWynikow() {
    }

    public BazaWynikow( String wynik) {
        this.wynik = wynik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWynik() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik = wynik;
    }
}
