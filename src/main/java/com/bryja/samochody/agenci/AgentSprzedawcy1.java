package com.bryja.samochody.agenci;
import java.util.Random;
public class AgentSprzedawcy1 {


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


    public String dane_dla_AK1(){
        return RandomString();
    }
}
