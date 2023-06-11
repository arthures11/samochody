package com.bryja.samochody.klasy;

import jakarta.persistence.*;

@Entity

public class SamochodySklep2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;

    public String name;
    @OneToOne(targetEntity=Rodzina.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Rodzina rodzina;
    @OneToOne(targetEntity=TypSamochodu.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public TypSamochodu typSamochodu;
    @OneToOne(targetEntity=Jazdy.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Jazdy jazdy;
    @OneToOne(targetEntity=Bagaz.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Bagaz bagaz;
    @OneToOne(targetEntity=Biegi.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Biegi biegi;

    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SamochodySklep2() {
    }

    public SamochodySklep2(String name, int price, Rodzina rodzina, TypSamochodu typSamochodu, Jazdy jazdy, Bagaz bagaz, Biegi biegi) {
        this.name = name;
        this.price=price;
        this.rodzina = rodzina;
        this.typSamochodu = typSamochodu;
        this.jazdy = jazdy;
        this.bagaz = bagaz;
        this.biegi = biegi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rodzina getRodzina() {
        return rodzina;
    }

    public void setRodzina(Rodzina rodzina) {
        this.rodzina = rodzina;
    }

    public TypSamochodu getTypSamochodu() {
        return typSamochodu;
    }

    public void setTypSamochodu(TypSamochodu typSamochodu) {
        this.typSamochodu = typSamochodu;
    }

    public Jazdy getJazdy() {
        return jazdy;
    }

    public void setJazdy(Jazdy jazdy) {
        this.jazdy = jazdy;
    }

    public Bagaz getBagaz() {
        return bagaz;
    }

    public void setBagaz(Bagaz bagaz) {
        this.bagaz = bagaz;
    }

    public Biegi getBiegi() {
        return biegi;
    }

    public void setBiegi(Biegi biegi) {
        this.biegi = biegi;
    }
}
