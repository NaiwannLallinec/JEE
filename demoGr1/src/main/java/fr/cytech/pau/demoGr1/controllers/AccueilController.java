package fr.cytech.pau.demoGr1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @GetMapping(path = "/accueil")
    public String afficherAccueil() {
        return "accueil";
    }
}
