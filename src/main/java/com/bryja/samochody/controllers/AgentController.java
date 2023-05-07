package com.bryja.samochody.controllers;

import com.bryja.samochody.agenci.AgentKlienta1;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("/cars")
    public List<String> getCar(@RequestParam("rodzina") String rodzina,
                               @RequestParam("rodzinaprio") String rodzinaprio,
                               @RequestParam("typauta") String typauta,
                               @RequestParam("typautaprio") String typautaprio,
                               @RequestParam("cel") String cel,
                               @RequestParam("celprio") String celprio,
                               @RequestParam("bagaznik") String bagaznik,
                               @RequestParam("bagaznikprio") String bagaznikprio,
                               @RequestParam("skrzynia") String skrzynia,
                               @RequestParam("skrzyniaprio") String skrzyniaprio){
        AgentKlienta1 AK1 = new AgentKlienta1();
        List<String> a =new ArrayList<>();
        a.add(AK1.propozycja());
        a.add(AK1.propozycja());
        a.add(AK1.propozycja());
        a.add(AK1.propozycja());
        a.add(AK1.propozycja());
        return a;
    }
}
