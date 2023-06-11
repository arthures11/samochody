package com.bryja.samochody.controllers;

import com.bryja.samochody.agenci.AgentKlienta;
import com.bryja.samochody.agenci.AgentSprzedawcy1;
import com.bryja.samochody.agenci.AgentSprzedawcy2;
import com.bryja.samochody.klasy.BazaWynikow;
import com.bryja.samochody.klasy.Samochody;
import com.bryja.samochody.klasy.SamochodySklep2;
import com.bryja.samochody.repos.BazaWynikowRepository;
import com.bryja.samochody.repos.Sklep1Repository;
import com.bryja.samochody.repos.Sklep2Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;


@RestController
public class AgentController {

    @PostMapping("/submit")
    public RedirectView submit(@RequestParam String family, @RequestParam String cartype, @RequestParam String cel, @RequestParam String bagaznik, @RequestParam String skrzynia , @RequestParam String btnradio, @RequestParam String btnradio2, @RequestParam String btnradio3, @RequestParam String btnradio4, @RequestParam String btnradio5) {

       // return AK1.propozycja()+"\n\nDla twoich potrzeb:\n"+
        //        "priorytet rodzinny:"+btnradio+": "+family+"\n"+
        //        "priorytet typu samochodu:"+btnradio2+": "+cartype+"\n"+
         //       "priorytet celu zakupu:"+btnradio+": "+cel+"\n"+
        //        "priorytet bagażnika:"+btnradio+": "+bagaznik+"\n"+
         //       "priorytet skrzyni biegów:"+btnradio+": "+skrzynia;

        return new RedirectView("/results?rodzina="+family+"&rodzinaprio="+btnradio+"&typauta="+cartype+"&typautaprio="+btnradio2+"&cel="+cel+"&celprio="+btnradio3+"&bagaznik="+bagaznik+"&bagaznikprio="+btnradio4+"&skrzynia="+skrzynia+"&skrzyniaprio="+btnradio5);

    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/submit")
    public ResponseEntity<String> handleMissingServletRequestParameterExceptionForSubmit(MissingServletRequestParameterException ex, WebRequest request) {
        if (request.getDescription(false).contains("/submit")) {
            return ResponseEntity.badRequest().body("wymagane jest podanie wszystkiego");
        } else {
            return ResponseEntity.badRequest().body("wymagane jest podanie wszystkiego");
        }
    }


    @Autowired
    Sklep1Repository ofertaSklepu1;

    @Autowired
    Sklep2Repository ofertaSklepu2;
    @Autowired
    BazaWynikowRepository bazaWynikowRepository;
    @GetMapping("/cars")
    public List<Object> getCar(@RequestParam("rodzina") String rodzina,
                                        @RequestParam("rodzinaprio") String rodzinaprio,
                                        @RequestParam("typauta") String typauta,
                                        @RequestParam("typautaprio") String typautaprio,
                                        @RequestParam("cel") String cel,
                                        @RequestParam("celprio") String celprio,
                                        @RequestParam("bagaznik") String bagaznik,
                                        @RequestParam("bagaznikprio") String bagaznikprio,
                                        @RequestParam("skrzynia") String skrzynia,
                                        @RequestParam("skrzyniaprio") String skrzyniaprio){




        List<Samochody> samochodySklepu1 = ofertaSklepu1.findAll();
        List<SamochodySklep2> samochodySklepu2 = ofertaSklepu2.findAll();
        AgentSprzedawcy1 sklep1 = new AgentSprzedawcy1(samochodySklepu1);
        AgentSprzedawcy2 sklep2 = new AgentSprzedawcy2(samochodySklepu2);




        List<AgentKlienta> agenciKlienta = new ArrayList<>();
        agenciKlienta.add(new AgentKlienta(sklep1, "Agent1", rodzina,rodzinaprio, typauta,typautaprio, cel,celprio, bagaznik,bagaznikprio, skrzynia,skrzyniaprio));
        agenciKlienta.add(new AgentKlienta(sklep2,"Agent2", rodzina,rodzinaprio, typauta,typautaprio, cel,celprio, bagaznik,bagaznikprio, skrzynia,skrzyniaprio));
        agenciKlienta.add(new AgentKlienta(sklep2, "Agent3", rodzina,rodzinaprio, typauta,typautaprio, cel,celprio, bagaznik,bagaznikprio, skrzynia,skrzyniaprio));







    List<Object> wyn = new ArrayList<>();
        List<Thread> watkiKlientow = new ArrayList<>();
        for (AgentKlienta agentKlienta : agenciKlienta) {
            Thread thread = new Thread(agentKlienta);
            watkiKlientow.add(thread);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(agentKlienta.wynikiSklepu2.isEmpty()){
                wyn.add(agentKlienta.wynikiSklepu1);
//                for(int i=0;i<agentKlienta.wynikiSklepu1.size();i++){
//                    System.out.println(agentKlienta.wynikiSklepu1.get(i).name);
//                }
            }
            else{
                wyn.add(agentKlienta.wynikiSklepu2);
            }
        }
        List<Object> nef = new ArrayList<>(wyn);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            String json = mapper.writeValueAsString(nef);
            BazaWynikow ba = new BazaWynikow(json);
            bazaWynikowRepository.save(ba);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return wyn;


//        String rodzinaParam = rodzina;
//        int rodzinaprioParam = Integer.parseInt(rodzinaprio);
//        String typautaParam = typauta;
//        int typautaprioParam = Integer.parseInt(typautaprio);
//        String celParam = cel;
//        int celprioParam = Integer.parseInt(celprio);
//        String bagaznikParam = bagaznik;
//        int bagaznikprioParam = Integer.parseInt(bagaznikprio);
//        String skrzyniaParam = skrzynia;
//        int skrzyniaprioParam = Integer.parseInt(skrzyniaprio);
//
//        List<Map.Entry<Samochody, Integer>> scoredSamochody = new ArrayList<>();
//
//
//        List<Samochody> samochodyList = samochodyRepository.findAll();
//
//        for (Samochody samochod : samochodyList) {
//            int score = 0;
//
//            score += samochod.getRodzina().getSamotnik() *  (rodzinaParam.equals("samotnik") ? rodzinaprioParam : 0);
//            score += samochod.getRodzina().getOsoby24() *  (rodzinaParam.equals("2-4") ? rodzinaprioParam : 0);
//            score += samochod.getRodzina().getOsoby5plus() *  (rodzinaParam.equals("5+") ? rodzinaprioParam : 0);
//
//            score += samochod.getTypSamochodu().getSzybki() * (typautaParam.equals("fast") ? typautaprioParam : 0);
//            score += samochod.getTypSamochodu().getDuzy() * (typautaParam.equals("big") ? typautaprioParam : 0);
//            score += samochod.getTypSamochodu().getSportowy() * (typautaParam.equals("sport") ? typautaprioParam : 0);
//            score += samochod.getTypSamochodu().getWygodny() * (typautaParam.equals("wygoda") ? typautaprioParam : 0);
//
//            score += samochod.getJazdy().getDlugie() * (celParam.equals("long") ? celprioParam : 0);
//            score += samochod.getJazdy().getPrzecietne() * (celParam.equals("average") ? celprioParam : 0);
//            score += samochod.getJazdy().getRzadke() * (celParam.equals("short") ? celprioParam : 0);
//
//            score += samochod.getBagaz().getMaly() * (bagaznikParam.equals("smallbag") ? bagaznikprioParam : 0);
//            score += samochod.getBagaz().getSredni() * (bagaznikParam.equals("averagebag") ? bagaznikprioParam : 0);
//            score += samochod.getBagaz().getDuzy() * (bagaznikParam.equals("bigbag") ? bagaznikprioParam : 0);
//
//            score += samochod.getBiegi().getManual() * (skrzyniaParam.equals("manual") ? skrzyniaprioParam : 0);
//            score += samochod.getBiegi().getAutomat() * (skrzyniaParam.equals("auto") ? skrzyniaprioParam : 0);
//            System.out.println(score);
//            scoredSamochody.add(new AbstractMap.SimpleEntry<>(samochod, score));
//        }
//
//        scoredSamochody.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//
//
//        int numberOfResults = 5;
//        List<Samochody> topSamochody = scoredSamochody.stream()
//                .limit(numberOfResults)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//
//
//       // AgentKlienta1 AK1 = new AgentKlienta1();
//       // List<String> a =new ArrayList<>();
//       // a.add(AK1.propozycja());
//        return topSamochody;
    }
}
