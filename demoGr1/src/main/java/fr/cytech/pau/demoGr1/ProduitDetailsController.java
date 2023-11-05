package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class ProduitDetailsController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/produit-details/{productId}")
	public String getProductDetails(@PathVariable Long productId, Model model) {
		Product product = productRepository.findById(productId).orElse(null);
		if (product != null) {
			model.addAttribute("product", product);
			return "details_produits";
		} else {
			return "redirect:/produits"; 
		}
	}

}
