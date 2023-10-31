package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/productregister")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}

	@PostMapping("/productregister")
	public String submitForm(@ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:/productlist";
	}

	@GetMapping("/productlist")
	public String listPeople(Model model) {
		Iterable<Product> product = productRepository.findAll();
		model.addAttribute("product", product);
		return "product-list";
	}

	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Long productId) {

		productRepository.deleteById(productId);
		return "redirect:/productlist";
	}
	
	@PostMapping("/updateStock/{productId}")
    public String updateStock(@PathVariable Long productId, @RequestParam("stock") int newStock) {
        // Récupérez le produit de la base de données en utilisant productId
        Product product = productRepository.findById(productId).orElse(null);

        product.setStock(newStock);
        productRepository.save(product);

        return "redirect:/productlist"; // Redirigez vers la liste des produits après la mise à jour
    }
}
