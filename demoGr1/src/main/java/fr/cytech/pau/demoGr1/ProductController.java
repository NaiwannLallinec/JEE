package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductService productService;

	@GetMapping("/productregister")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}

	@PostMapping("/productregister")
	public String submitForm(@ModelAttribute Product product) {

		Category existingCategory = categoryRepository.findByCategoryType(product.getType());

		if (existingCategory == null) {
			existingCategory = new Category();
			existingCategory.setCategoryType(product.getType());
			categoryRepository.save(existingCategory);
		}

		product.addCategory(existingCategory);
		productRepository.save(product);

		return "redirect:/productlist";
	}

	@GetMapping("/productlist")
	public String listProducts(Model model, HttpSession session) {
		Iterable<Product> product = productRepository.findAll();
		model.addAttribute("product", product);

		Long personId = (Long) session.getAttribute("personId");
		Byte commonType = productService.findCommonType(personId);
		String commonColor = productService.findCommonColor(personId);
		Integer commonSize = productService.findCommonSize(personId);

		model.addAttribute("commonType", commonType);
		model.addAttribute("commonColor", commonColor);
		model.addAttribute("commonSize", commonSize);

		return "product-list";
	}

	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Long productId) {

		productRepository.deleteById(productId);
		return "redirect:/productlist";
	}

	@PostMapping("/updateStock/{productId}")
	public String updateStock(@PathVariable Long productId, @RequestParam("stock") int newStock) {
		Product product = productRepository.findById(productId).orElse(null);

		product.setStock(newStock);
		productRepository.save(product);

		return "redirect:/productlist";
	}
}