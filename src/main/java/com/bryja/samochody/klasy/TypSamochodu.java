package com.bryja.samochody.klasy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity

public class TypSamochodu  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;
    public int szybki;
    public int duzy;
    public int sportowy;
    public int wygodny;

    public TypSamochodu() {
    }

    public TypSamochodu(int szybki, int duzy, int sportowy, int wygodny) {
        this.szybki = szybki;
        this.duzy = duzy;
        this.sportowy = sportowy;
        this.wygodny = wygodny;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSzybki() {
        return szybki;
    }

    public void setSzybki(int szybki) {
        this.szybki = szybki;
    }

    public int getDuzy() {
        return duzy;
    }

    public void setDuzy(int duzy) {
        this.duzy = duzy;
    }

    public int getSportowy() {
        return sportowy;
    }

    public void setSportowy(int sportowy) {
        this.sportowy = sportowy;
    }

    public int getWygodny() {
        return wygodny;
    }

    public void setWygodny(int wygodny) {
        this.wygodny = wygodny;
    }


}
