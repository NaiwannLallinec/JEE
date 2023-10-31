package fr.cytech.pau.demoGr1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import produits.ProductInfo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProduitsController {

    @GetMapping("/produits")
    public String showProductList(Model model) {

    	List<ProductInfo> products = new ArrayList<>();

    	ProductInfo product1 = new ProductInfo("Produit 1", "Description du produit 1.", 19.99, "/images/jean.jpg");
    	products.add(product1);

    	ProductInfo product2 = new ProductInfo("Produit 2", "Description du produit 2.", 24.99, "/images/short.jpg");
    	products.add(product2);

    	System.out.println("Contenu de la liste 'products':");
    	for (ProductInfo product : products) {
    	    System.out.println("Nom du produit : " + product.getName());
    	    System.out.println("Description du produit : " + product.getDescription());
    	    System.out.println("Prix du produit : " + product.getPrice());
    	    System.out.println("Image du produit : " + product.getImage());
    	}

    	model.addAttribute("products", products);

        return "produits";
    }
}

