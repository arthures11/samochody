package com.bryja.samochody.agenci;

import com.bryja.samochody.klasy.Samochody;

import java.util.ArrayList;
import java.util.List;

public class AgentKlienta1 implements Runnable {

    String name;

    String rodzina;
    String rodzinaprio;

    String typ; String typprio;
    String trasy;
    String bag;
    String biegi;    String trasyprio;
    String bagprio;
    String biegiprio;

    public String getRodzinaprio() {
        return rodzinaprio;
    }

    public String getTypprio() {
        return typprio;
    }

    public String getTrasyprio() {
        return trasyprio;
    }

    public String getBagprio() {
        return bagprio;
    }

    public String getBiegiprio() {
        return biegiprio;
    }

List<Samochody> samochodyList;

    public List<Samochody> getWynikiProp() {
        return wynikiProp;
    }

    public AgentKlienta1(String name, List<Samochody> samochodyList, String rodzina, String rodzinaprio, String typ, String typprio, String trasy, String trasyprio, String bag, String bagprio, String biegi, String biegiprio) {
        this.name = name;
        this.samochodyList =samochodyList;
        this.rodzina = rodzina;
        this.rodzinaprio=rodzinaprio;
        this.typprio=typprio;
        this.trasyprio=trasyprio;
        this.bagprio=bagprio;
        this.biegiprio=biegiprio;
        this.typ = typ;
        this.trasy = trasy;
        this.bag = bag;
        this.biegi = biegi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRodzina() {
        return rodzina;
    }

    public void setRodzina(String rodzina) {
        this.rodzina = rodzina;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getTrasy() {
        return trasy;
    }

    public void setTrasy(String trasy) {
        this.trasy = trasy;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public String getBiegi() {
        return biegi;
    }

    public void setBiegi(String biegi) {
        this.biegi = biegi;
    }

    public List<Samochody> wynikiProp = new ArrayList<>();


    public void setRodzinaprio(String rodzinaprio) {
        this.rodzinaprio = rodzinaprio;
    }

    public void setTypprio(String typprio) {
        this.typprio = typprio;
    }

    public void setTrasyprio(String trasyprio) {
        this.trasyprio = trasyprio;
    }

    public void setBagprio(String bagprio) {
        this.bagprio = bagprio;
    }

    public void setBiegiprio(String biegiprio) {
        this.biegiprio = biegiprio;
    }

    public void setWynikiProp(List<Samochody> wynikiProp) {
        this.wynikiProp = wynikiProp;
    }

    @Override
    public void run() {
        List<AgentSprzedawcy1> agenciSprzedawcy = new ArrayList<>();
        agenciSprzedawcy.add(new AgentSprzedawcy1("Sprzedawca1"));
        for (AgentSprzedawcy1 agentSprzedawcy : agenciSprzedawcy) {
            List<Samochody> wyniki = agentSprzedawcy.propozycja(samochodyList,rodzina,rodzinaprio,typ,typprio,trasy,trasyprio,bag,bagprio,biegi,biegiprio);

            wynikiProp=wyniki;
        }
    }
}
