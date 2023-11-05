package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaiementController {

    @Autowired
    private CommandeLigneRepository commandeLigneRepository;
    
    @Autowired
    private PaiementRepository paiementRepository;
    
    @Autowired
    private CommandeRepository commandeRepository;
    
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    

    @GetMapping("/paiement")
    public String afficher(Model model) {
        Iterable<Commande> commandes = commandeLigneRepository.findAll(); 
        
        double totalPanier = 0.0;
        for (Commande commande : commandes) {
            List<CommandeLigne> commandeLignes = commande.getCommandeLignes();
            for (CommandeLigne ligne : commandeLignes) {
                totalPanier += ligne.getProduct().getPrix() * ligne.getQuantite();
            }
        }
        
        double tauxTVA = 0.20; 
        double tva = totalPanier * tauxTVA;

        double totalAvecTVA = totalPanier + tva;

        model.addAttribute("totalPanier", totalPanier);
        model.addAttribute("tva", tva);
        model.addAttribute("totalAvecTVA", totalAvecTVA);

        return "paiement";
    }
    
    @GetMapping("/paiementValide")
    public String validerPaiement() {
        return "paiementValide";
    }
    
    @PostMapping("/process_payment")
    public String processPayment(@RequestParam double montant, @RequestParam double tva, @RequestParam String adresse,HttpSession session) {
        Paiement paiement = new Paiement();

        paiement.setMontant(montant);
        paiement.setTva(tva);
        paiement.setAdresse(adresse);
        
        Person person = (Person) session.getAttribute("person");
        Commande commande = commandeRepository.findByPerson(person);
        paiement.setCommande(commande);

        paiementRepository.save(paiement);
        
        
        Commande commandeActuelle = commandeRepository.findByPerson(person);

        List<CommandeLigne> commandeLignes = ligneCommandeRepository.findByCommandeDesLignes(commande);
        if (commandeLignes != null && !commandeLignes.isEmpty()) {
            ligneCommandeRepository.deleteAll(commandeLignes);
        }
        
        commandeActuelle.setCommandeLignes(new ArrayList<>()); 
        commandeRepository.save(commandeActuelle);

        return "redirect:/paiementValide";
    }
    
}

