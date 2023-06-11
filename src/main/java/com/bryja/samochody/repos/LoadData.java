package com.bryja.samochody.repos;

import com.bryja.samochody.klasy.*;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements
        ApplicationListener<ContextRefreshedEvent> {

    private final Sklep1Repository sklep1Repository;

    private final Sklep2Repository sklep2Repository;

    boolean alreadySetup = false;

    public LoadData(Sklep1Repository sklep1Repository, Sklep2Repository sklep2Repository) {
        this.sklep1Repository = sklep1Repository;
        this.sklep2Repository = sklep2Repository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;


        Samochody toyotacamry = new Samochody("Toyota Camry",10000,new Rodzina(2,3,2),new TypSamochodu(2,1,1,2),new Jazdy(2,3,2),new Bagaz(2,0,2),new Biegi(1,1));
        Samochody golf = new Samochody("Volkswagen Golf",20000,new Rodzina(2,3,1),new TypSamochodu(2,1,2,1),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody subaru_outback = new Samochody("Subaru Outback",22000,new Rodzina(2,3,2),new TypSamochodu(1,3,1,3),new Jazdy(3,2,1),new Bagaz(0,2,3),new Biegi(1,2));
        Samochody bmwm3 = new Samochody("BMW M3",30000,new Rodzina(3,0,0),new TypSamochodu(3,1,3,2),new Jazdy(2,1,1),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody fordexp = new Samochody("Ford Explorer",12000,new Rodzina(1,3,3),new TypSamochodu(1,3,1,3),new Jazdy(3,3,2),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody hondacivi = new Samochody("Honda Civic",11000,new Rodzina(2,2,1),new TypSamochodu(2,1,1,1),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody kiasoul = new Samochody("Kia Soul",16500,new Rodzina(1,2,2),new TypSamochodu(1,2,1,3),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody keepwrangl = new Samochody("Jeep Wrangler",11110,new Rodzina(1,3,3),new TypSamochodu(1,3,1,3),new Jazdy(3,2,1),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody merc = new Samochody("Mercedes Benz S Klasa",53000,new Rodzina(2,2,1),new TypSamochodu(1,1,2,2),new Jazdy(3,2,2),new Bagaz(1,1,2),new Biegi(0,3));
        Samochody chev = new Samochody("Chevrolet Corvette",38300,new Rodzina(3,0,0),new TypSamochodu(3,1,3,2),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody nis = new Samochody("Nissan Pathfinder",21200,new Rodzina(1,3,3),new TypSamochodu(1,2,1,3),new Jazdy(2,2,2),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody audi = new Samochody("Audi A4",6500,new Rodzina(2,2,1),new TypSamochodu(2,1,1,2),new Jazdy(2,2,2),new Bagaz(1,1,1),new Biegi(1,1));
        Samochody dodge = new Samochody("Dodge Grand Caravan",10000,new Rodzina(1,2,3),new TypSamochodu(1,2,1,1),new Jazdy(2,2,1),new Bagaz(0,2,3),new Biegi(1,1));
        Samochody toy = new Samochody("Toyota Yaris",12200,new Rodzina(2,2,1),new TypSamochodu(1,0,1,2),new Jazdy(2,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        Samochody ford = new Samochody("Ford F-150",11894,new Rodzina(1,2,3),new TypSamochodu(1,2,0,2),new Jazdy(3,3,2),new Bagaz(1,2,3),new Biegi(1,1));
        Samochody bbb = new Samochody("BMW 7 Seria",13330,new Rodzina(2,2,1),new TypSamochodu(2,1,2,2),new Jazdy(3,2,2),new Bagaz(2,1,0),new Biegi(1,2));
        Samochody sub = new Samochody("Subaru Outback",33450,new Rodzina(1,2,2),new TypSamochodu(1,2,3,2),new Jazdy(1,2,2),new Bagaz(2,2,1),new Biegi(1,1));
        Samochody pors = new Samochody("Porshe Cayenne",55550,new Rodzina(2,1,1),new TypSamochodu(3,3,1,1),new Jazdy(1,1,3),new Bagaz(3,3,1),new Biegi(1,1));
        Samochody tesla = new Samochody("Tesla S",78500,new Rodzina(1,2,1),new TypSamochodu(2,0,1,2),new Jazdy(2,2,2),new Bagaz(2,1,0),new Biegi(0,4));
        Samochody niss = new Samochody("Nissan Leaf",55000,new Rodzina(1,2,1),new TypSamochodu(3,1,1,2),new Jazdy(2,2,2),new Bagaz(1,1,0),new Biegi(1,2));
        Samochody audiq5 = new Samochody("Audi Q5",12340,new Rodzina(1,2,2),new TypSamochodu(1,2,1,2),new Jazdy(2,2,2),new Bagaz(1,2,0),new Biegi(1,2));


        SamochodySklep2 kiasoul2 = new SamochodySklep2("Kia Soul",17500,new Rodzina(1,2,2),new TypSamochodu(1,2,1,3),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        SamochodySklep2 keepwrangl2 = new SamochodySklep2("Jeep Wrangler",12110,new Rodzina(1,3,3),new TypSamochodu(1,3,1,3),new Jazdy(3,2,1),new Bagaz(0,2,3),new Biegi(1,1));
        SamochodySklep2 merc2 = new SamochodySklep2("Mercedes Benz S Klasa",54000,new Rodzina(2,2,1),new TypSamochodu(1,1,2,2),new Jazdy(3,2,2),new Bagaz(1,1,2),new Biegi(0,3));
        SamochodySklep2 chev2 = new SamochodySklep2("Chevrolet Corvette",37300,new Rodzina(3,0,0),new TypSamochodu(3,1,3,2),new Jazdy(1,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        SamochodySklep2 nis2 = new SamochodySklep2("Nissan Pathfinder",22200,new Rodzina(1,3,3),new TypSamochodu(1,2,1,3),new Jazdy(2,2,2),new Bagaz(0,2,3),new Biegi(1,1));
        SamochodySklep2 audi2 = new SamochodySklep2("Audi A4",7700,new Rodzina(2,2,1),new TypSamochodu(2,1,1,2),new Jazdy(2,2,2),new Bagaz(1,1,1),new Biegi(1,1));
        SamochodySklep2 dodge2 = new SamochodySklep2("Dodge Grand Caravan",11000,new Rodzina(1,2,3),new TypSamochodu(1,2,1,1),new Jazdy(2,2,1),new Bagaz(0,2,3),new Biegi(1,1));
        SamochodySklep2 toy2 = new SamochodySklep2("Toyota Camry",13200,new Rodzina(2,2,1),new TypSamochodu(1,0,1,2),new Jazdy(2,2,2),new Bagaz(2,1,0),new Biegi(1,1));
        SamochodySklep2 ford2 = new SamochodySklep2("Ford F-150",10894,new Rodzina(1,2,3),new TypSamochodu(1,2,0,2),new Jazdy(3,3,2),new Bagaz(1,2,3),new Biegi(1,1));
        SamochodySklep2 bbb2 = new SamochodySklep2("BMW 7 Seria",14330,new Rodzina(2,2,1),new TypSamochodu(2,1,2,2),new Jazdy(3,2,2),new Bagaz(2,1,0),new Biegi(1,2));
        SamochodySklep2 sub2 = new SamochodySklep2("Subaru Outback",35450,new Rodzina(1,2,2),new TypSamochodu(1,2,3,2),new Jazdy(1,2,2),new Bagaz(2,2,1),new Biegi(1,1));
        SamochodySklep2 pors2 = new SamochodySklep2("Porshe Cayenne",59950,new Rodzina(2,1,1),new TypSamochodu(3,3,1,1),new Jazdy(1,1,3),new Bagaz(3,3,1),new Biegi(1,1));
        SamochodySklep2 tesla2 = new SamochodySklep2("Tesla S",68440,new Rodzina(1,2,1),new TypSamochodu(2,0,1,2),new Jazdy(2,2,2),new Bagaz(2,1,0),new Biegi(0,4));
        SamochodySklep2 niss2 = new SamochodySklep2("Nissan Leaf",51000,new Rodzina(1,2,1),new TypSamochodu(3,1,1,2),new Jazdy(2,2,2),new Bagaz(1,1,0),new Biegi(1,2));
        SamochodySklep2 audiq52 = new SamochodySklep2("Audi Q5",15940,new Rodzina(1,2,2),new TypSamochodu(1,2,1,2),new Jazdy(2,2,2),new Bagaz(1,2,0),new Biegi(1,2));



//        sklep1Repository.save(toyotacamry);
//        sklep1Repository.save(golf);
//        sklep1Repository.save(subaru_outback);
//        sklep1Repository.save(bmwm3);
//        sklep1Repository.save(fordexp);
//        sklep1Repository.save(hondacivi);
//        sklep1Repository.save(kiasoul);
//        sklep1Repository.save(keepwrangl);
//        sklep1Repository.save(merc);
//        sklep1Repository.save(chev);
//        sklep1Repository.save(nis);
//        sklep1Repository.save(audi);
//        sklep1Repository.save(dodge);
//        sklep1Repository.save(toy);
//        sklep1Repository.save(ford);
//        sklep1Repository.save(bbb);
//        sklep1Repository.save(sub);
//        sklep1Repository.save(tesla);
//        sklep1Repository.save(niss);
//        sklep1Repository.save(pors);
//        sklep1Repository.save(audiq5);
//
//        sklep2Repository.save(kiasoul2);
//        sklep2Repository.save(keepwrangl2);
//        sklep2Repository.save(merc2);
//        sklep2Repository.save(chev2);
//        sklep2Repository.save(nis2);
//        sklep2Repository.save(audi2);
//        sklep2Repository.save(dodge2);
//        sklep2Repository.save(toy2);
//        sklep2Repository.save(ford2);
//        sklep2Repository.save(bbb2);
//        sklep2Repository.save(sub2);
//        sklep2Repository.save(tesla2);
//        sklep2Repository.save(niss2);
//        sklep2Repository.save(pors2);
//        sklep2Repository.save(audiq52);


        alreadySetup = true;
    }
}





















