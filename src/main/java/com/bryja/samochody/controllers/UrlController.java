package com.bryja.samochody.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlController {

    @RequestMapping(value="/")
    public ModelAndView getindex() {
        return new ModelAndView("index");
    }
    @RequestMapping(value="/results")
    public ModelAndView getresults() {
        return new ModelAndView("results");
    }

}
