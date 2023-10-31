package fr.cytech.pau.demoGr1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String afficherContact() {
        return "contact";
    }
}
