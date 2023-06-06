package com.bryja.samochody.repos;

import com.bryja.samochody.klasy.*;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements
        ApplicationListener<ContextRefreshedEvent> {

    private final SamochodyRepository samochodyRepository;

    boolean alreadySetup = false;

    public LoadData(SamochodyRepository samochodyRepository) {
        this.samochodyRepository = samochodyRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;


        Samochody toyotacamry = new Samochody("Toyota Camry",new Rodzina(2,3,2),new TypSamochodu(2,1,1,2),new Jazdy(2,3,2),new Bagaz(2,0,2),new Biegi(1,1));
        Samochody golf = new Samochody("Volkswagen Golf",new Rodzina(2,3,1),new TypSamochodu(2,1,2,1),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody subaru_outback = new Samochody("Subaru Outback",new Rodzina(2,3,2),new TypSamochodu(1,3,1,3),new Jazdy(3,2,1),new Bagaz(0,2,3),new Biegi(1,2));
        Samochody bmwm3 = new Samochody("BMW M3",new Rodzina(3,0,0),new TypSamochodu(3,1,3,2),new Jazdy(2,1,1),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody fordexp = new Samochody("Ford Explorer",new Rodzina(1,3,3),new TypSamochodu(1,3,1,3),new Jazdy(3,3,2),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody hondacivi = new Samochody("Honda Civic",new Rodzina(2,2,1),new TypSamochodu(2,1,1,1),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody kiasoul = new Samochody("Kia Soul",new Rodzina(1,2,2),new TypSamochodu(1,2,1,3),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody keepwrangl = new Samochody("Jeep Wrangler",new Rodzina(1,3,3),new TypSamochodu(1,3,1,3),new Jazdy(3,2,1),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody merc = new Samochody("Mercedes Benz S Klasa",new Rodzina(2,2,1),new TypSamochodu(1,1,2,2),new Jazdy(3,2,2),new Bagaz(1,1,2),new Biegi(0,3));
        Samochody chev = new Samochody("Chevrolet Corvette",new Rodzina(3,0,0),new TypSamochodu(3,1,3,2),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody nis = new Samochody("Nissan Pathfinder",new Rodzina(1,3,3),new TypSamochodu(1,2,1,3),new Jazdy(2,2,2),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody audi = new Samochody("Audi A4",new Rodzina(2,2,1),new TypSamochodu(2,1,1,2),new Jazdy(2,2,2),new Bagaz(1,1,1),new Biegi(1,1));
        Samochody dodge = new Samochody("Dodge Grand Caravan",new Rodzina(1,2,3),new TypSamochodu(1,2,1,1),new Jazdy(2,2,1),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody toy = new Samochody("Toyota Camry",new Rodzina(2,2,1),new TypSamochodu(1,0,1,2),new Jazdy(2,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody ford = new Samochody("Ford F-150",new Rodzina(1,2,3),new TypSamochodu(1,2,0,2),new Jazdy(3,3,2),new Bagaz(1,2,3),new Biegi(1,1));
        Samochody bbb = new Samochody("BMW 7 Seria",new Rodzina(2,2,1),new TypSamochodu(2,1,2,2),new Jazdy(3,2,2),new Bagaz(2,1,0),new Biegi(1,2));
        Samochody sub = new Samochody("Subaru Outback",new Rodzina(1,2,2),new TypSamochodu(1,2,3,2),new Jazdy(1,2,2),new Bagaz(2,2,1),new Biegi(1,1));
        Samochody pors = new Samochody("Porshe Cayenne",new Rodzina(2,1,1),new TypSamochodu(3,3,1,1),new Jazdy(1,1,3),new Bagaz(3,3,1),new Biegi(1,1));
        Samochody tesla = new Samochody("Tesla S",new Rodzina(1,2,1),new TypSamochodu(2,0,1,2),new Jazdy(2,2,2),new Bagaz(2,1,0),new Biegi(0,4));
        Samochody niss = new Samochody("Nissan Leaf",new Rodzina(1,2,1),new TypSamochodu(3,1,1,2),new Jazdy(2,2,2),new Bagaz(1,1,0),new Biegi(1,2));
        Samochody audiq5 = new Samochody("Audi Q5",new Rodzina(1,2,2),new TypSamochodu(1,2,1,2),new Jazdy(2,2,2),new Bagaz(1,2,0),new Biegi(1,2));

//        samochodyRepository.save(toyotacamry);
//        samochodyRepository.save(golf);
//        samochodyRepository.save(subaru_outback);
//        samochodyRepository.save(bmwm3);
//        samochodyRepository.save(fordexp);
//        samochodyRepository.save(hondacivi);
//        samochodyRepository.save(kiasoul);
//        samochodyRepository.save(keepwrangl);
//        samochodyRepository.save(merc);
//        samochodyRepository.save(chev);
//        samochodyRepository.save(nis);
//        samochodyRepository.save(audi);
//        samochodyRepository.save(dodge);
//        samochodyRepository.save(toy);
//        samochodyRepository.save(ford);
//        samochodyRepository.save(bbb);
//        samochodyRepository.save(sub);
//        samochodyRepository.save(tesla);
//        samochodyRepository.save(niss);
//        samochodyRepository.save(pors);
//        samochodyRepository.save(audiq5);


        alreadySetup = true;
    }
}





















