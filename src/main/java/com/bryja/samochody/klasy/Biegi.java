package com.bryja.samochody.klasy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity

public class Biegi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;
    public int manual;
    public int automat;


    public Biegi() {
    }

    public Biegi(int manual, int automat) {
        this.manual = manual;
        this.automat = automat;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getManual() {
        return manual;
    }

    public void setManual(int manual) {
        this.manual = manual;
    }

    public int getAutomat() {
        return automat;
    }

    public void setAutomat(int automat) {
        this.automat = automat;
    }


}
