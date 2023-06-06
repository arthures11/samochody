package com.bryja.samochody.agenci;
import com.bryja.samochody.klasy.Samochody;
import com.bryja.samochody.repos.SamochodyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class AgentSprzedawcy1 {

    String name;

    public AgentSprzedawcy1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String RandomString() {
            String[] options = {"Toyota Camry", "Volkswagen Golf", "Subaru Outback", "BMW M3", "Ford Explorer",
                    "Honda Civic", "Kia Soul", "Jeep Wrangler", "Mercedes Benz S Klasa", "Chevrloet Corvette",
                    "Nissan Pathfinder", "Audi A4", "Dodge Grand Caravan", "Toyota Camry", "Ford F-150",
                    "BMW 7 Seria", "Subaru Outback", "Porshe Cayenne", "Tesla S model", "Nissan Leaf", "Audi Q5"};

            Random rand = new Random();
            int index = rand.nextInt(options.length);
            String randomString = options[index];

            return randomString;

    }


    public List<Samochody> propozycja(List<Samochody> samochodyList, String rodzina, String rodzinaprio, String typauta, String typautaprio, String cel,
                                      String celprio, String bagaznik, String bagaznikprio, String skrzynia, String skrzyniaprio){

        String rodzinaParam = rodzina;
        int rodzinaprioParam = Integer.parseInt(rodzinaprio);
        String typautaParam = typauta;
        int typautaprioParam = Integer.parseInt(typautaprio);
        String celParam = cel;
        int celprioParam = Integer.parseInt(celprio);
        String bagaznikParam = bagaznik;
        int bagaznikprioParam = Integer.parseInt(bagaznikprio);
        String skrzyniaParam = skrzynia;
        int skrzyniaprioParam = Integer.parseInt(skrzyniaprio);

        List<Map.Entry<Samochody, Integer>> scoredSamochody = new ArrayList<>();




        for (Samochody samochod : samochodyList) {
            int score = 0;

            score += samochod.getRodzina().getSamotnik() *  (rodzinaParam.equals("samotnik") ? rodzinaprioParam : 0);
            score += samochod.getRodzina().getOsoby24() *  (rodzinaParam.equals("2-4") ? rodzinaprioParam : 0);
            score += samochod.getRodzina().getOsoby5plus() *  (rodzinaParam.equals("5+") ? rodzinaprioParam : 0);

            score += samochod.getTypSamochodu().getSzybki() * (typautaParam.equals("fast") ? typautaprioParam : 0);
            score += samochod.getTypSamochodu().getDuzy() * (typautaParam.equals("big") ? typautaprioParam : 0);
            score += samochod.getTypSamochodu().getSportowy() * (typautaParam.equals("sport") ? typautaprioParam : 0);
            score += samochod.getTypSamochodu().getWygodny() * (typautaParam.equals("wygoda") ? typautaprioParam : 0);

            score += samochod.getJazdy().getDlugie() * (celParam.equals("long") ? celprioParam : 0);
            score += samochod.getJazdy().getPrzecietne() * (celParam.equals("average") ? celprioParam : 0);
            score += samochod.getJazdy().getRzadke() * (celParam.equals("short") ? celprioParam : 0);

            score += samochod.getBagaz().getMaly() * (bagaznikParam.equals("smallbag") ? bagaznikprioParam : 0);
            score += samochod.getBagaz().getSredni() * (bagaznikParam.equals("averagebag") ? bagaznikprioParam : 0);
            score += samochod.getBagaz().getDuzy() * (bagaznikParam.equals("bigbag") ? bagaznikprioParam : 0);

            score += samochod.getBiegi().getManual() * (skrzyniaParam.equals("manual") ? skrzyniaprioParam : 0);
            score += samochod.getBiegi().getAutomat() * (skrzyniaParam.equals("auto") ? skrzyniaprioParam : 0);
            scoredSamochody.add(new AbstractMap.SimpleEntry<>(samochod, score));
        }

        scoredSamochody.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        int numberOfResults = 5;
        List<Samochody> topSamochody = scoredSamochody.stream()
                .limit(numberOfResults)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        // AgentKlienta1 AK1 = new AgentKlienta1();
        // List<String> a =new ArrayList<>();
        // a.add(AK1.propozycja());
        return topSamochody;
    }


    public String dane_dla_AK1(){
        return RandomString();
    }
}
