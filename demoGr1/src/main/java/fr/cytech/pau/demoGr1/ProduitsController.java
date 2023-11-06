package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class ProduitsController {
	
	
	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

	@PostMapping("/viderPanier")
	public String viderPanier(HttpSession session) {
	    Person person = (Person) session.getAttribute("person");

	    if (person != null) {
	        Commande commande = commandeRepository.findByPerson(person);

	        if (commande != null) {
	            List<CommandeLigne> commandeLignes = ligneCommandeRepository.findByCommandeDesLignes(commande);

	            if (commandeLignes != null && !commandeLignes.isEmpty()) {
	                ligneCommandeRepository.deleteAll(commandeLignes); 
	            }
	        }
	    }

	    return "redirect:/panier";
	}


	@GetMapping("/panier")
	public String getCommande(Model model, HttpSession session) {

		if (session.getAttribute("person") != null) {
			
			Long personId = (Long) session.getAttribute("personId");
			Byte commonType = productService.findCommonType(personId);
			String commonColor = productService.findCommonColor(personId);
			Integer commonSize = productService.findCommonSize(personId);

			model.addAttribute("commonType", commonType);
			model.addAttribute("commonColor", commonColor);
			model.addAttribute("commonSize", commonSize);

			Person person = (Person) session.getAttribute("person");

			Commande commande = commandeRepository.findByPerson(person);
			List<CommandeLigne> commandeLignes = ligneCommandeRepository.findByCommandeDesLignes(commande);

			model.addAttribute("commande", commande);

			model.addAttribute("commandeLignes", commandeLignes);

			return "panier";
		}

		return "redirect:/form";

	}

	@PostMapping("/ajouterCommande")
	public String ajouterAuPanier(@RequestParam("productId") Long id, @RequestParam("quantite") Long quantite,
	        HttpSession session, Model model) {

	    Person person = (Person) session.getAttribute("person");

	    if (person == null) {
	        return "redirect:/form";
	    } else {
	        Product product = productRepository.findById(id).orElse(null);
	        Commande commande = commandeRepository.findByPerson(person);
	        
	        System.out.println(commande);

	        if (commande == null) {
	            commande = new Commande();
	            commande.setPerson(person);
	            commande = commandeRepository.save(commande);
	        }

	        CommandeLigne ligneCommande = new CommandeLigne();
	        ligneCommande.setQuantite(quantite);
	        ligneCommande.setCommandeDesLignes(commande);
	        ligneCommande.setProduct(product);

	        ligneCommandeRepository.save(ligneCommande);

	        return "redirect:/panier";
	    }
	}


    @GetMapping("/produits")
    public String showProductList(Model model, HttpSession session) {
        
        List<Product> products = (List<Product>) productRepository.findAll();
        

        model.addAttribute("products", products);


        return "produits";
    }
    
    
    
    
}
