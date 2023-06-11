package com.bryja.samochody.agenci;

import com.bryja.samochody.klasy.Samochody;
import com.bryja.samochody.klasy.SamochodySklep2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AgentKlienta implements Runnable {

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


    AgentSprzedawcy2 agentSprzedawcy2;
    AgentSprzedawcy1 agentSprzedawcy1;
    public AgentKlienta(AgentSprzedawcy2 sklep2, String name, String rodzina, String rodzinaprio, String typ, String typprio, String trasy, String trasyprio, String bag, String bagprio, String biegi, String biegiprio) {
       this.agentSprzedawcy2 = sklep2;
        this.name = name;
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

    public AgentKlienta(AgentSprzedawcy1 sklep1, String name, String rodzina, String rodzinaprio, String typ, String typprio, String trasy, String trasyprio, String bag, String bagprio, String biegi, String biegiprio) {
        this.agentSprzedawcy1 = sklep1;
        this.name = name;
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

    public List<Samochody> wynikiSklepu1 = new ArrayList<Samochody>();
    public List<SamochodySklep2> wynikiSklepu2 = new ArrayList<SamochodySklep2>();


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


    @Override
    public void run() {
        List<Samochody> wyniki = new ArrayList<>();

        if(agentSprzedawcy1==null) {
            wynikiSklepu2 =  agentSprzedawcy2.propozycja(rodzina,typ,trasy,bag,biegi, 7);
            for (int i = 0; i < 6; i++) {
                Random random = new Random();
                int randomIndex = random.nextInt(wynikiSklepu2.size());
                wynikiSklepu2.remove(randomIndex);
            }
            //System.out.println(wynikiSklepu2.size());
//            System.out.println("=============agent2===============");
//            for(int i=0;i<wynikiSklepu2.size();i++){
//                System.out.println(wynikiSklepu2.get(i).name);
//            }
//            System.out.println("==================================");

        }
        else {
            wynikiSklepu1 = agentSprzedawcy1.propozycja(rodzina,typ,trasy,bag,biegi, 10);

            for (int i = 0; i < 9; i++) {
                Random random = new Random();
                int randomIndex = random.nextInt(wynikiSklepu1.size());
                wynikiSklepu1.remove(randomIndex);
            }
//            System.out.println(wynikiSklepu1.size());
//            System.out.println("=============1===============");
//            for(int i=0;i<wynikiSklepu1.size();i++){
//                System.out.println(wynikiSklepu1.get(i).name);
//            }
//            System.out.println("==================================");
        }

    }

}
