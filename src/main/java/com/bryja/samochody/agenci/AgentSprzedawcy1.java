package com.bryja.samochody.agenci;
import com.bryja.samochody.klasy.Samochody;

import java.util.*;
import java.util.stream.Collectors;

public class AgentSprzedawcy1 {


    List<Samochody> oferta = new ArrayList<>();
    public AgentSprzedawcy1(List<Samochody> samochody) {
        this.oferta = samochody;
    }


    public List<Samochody> propozycja(String rodzina, String typauta, String cel,
                                      String bagaznik, String skrzynia, int ilosc_wynikow){

        List<Map.Entry<Samochody, Integer>> scoredSamochody = new ArrayList<>();




        for (Samochody samochod : oferta) {
            int score = 0;

            switch (rodzina) {
                case "1" -> score += samochod.getRodzina().getSamotnik();
                case "24" -> score += samochod.getRodzina().getOsoby24();
                case "5" -> score += samochod.getRodzina().getOsoby5plus();
            }


            switch (typauta) {
                case "fast" -> score += samochod.getTypSamochodu().getSzybki();
                case "big" -> score += samochod.getTypSamochodu().getDuzy();
                case "sport" -> score += samochod.getTypSamochodu().getSportowy();
                case "wygoda" -> score += samochod.getTypSamochodu().getWygodny();
            }

            switch(cel){
                case "long" ->score += samochod.getJazdy().getDlugie();
                case "average" -> score += samochod.getJazdy().getPrzecietne();
                case "short" ->score += samochod.getJazdy().getRzadke();
            }

            switch(bagaznik){
                case "smallbag" ->score += samochod.getBagaz().getMaly();
                case "averagebag" -> score += samochod.getBagaz().getSredni();
                case "bigbag" ->score += samochod.getBagaz().getDuzy();
            }

            switch(skrzynia){
                case "manual" ->score += samochod.getBiegi().getManual();
                case "auto" -> score +=  samochod.getBiegi().getAutomat();
                case "bigbag" ->score += samochod.getBagaz().getDuzy();
            }
            scoredSamochody.add(new AbstractMap.SimpleEntry<>(samochod, score));
        }

        scoredSamochody.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        int numberOfResults = ilosc_wynikow;
        List<Samochody> topSamochody = scoredSamochody.stream()
                .limit(numberOfResults)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());




        // AgentKlienta1 AK1 = new AgentKlienta1();
        // List<String> a =new ArrayList<>();
        // a.add(AK1.propozycja());
        return topSamochody;
    }

}
