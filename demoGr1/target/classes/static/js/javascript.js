function openModal(title, description, price, image, recommendedProducts) {
	var modal = document.getElementById("productModal");
	modal.style.display = "flex";

	// Mettre à jour les informations du produit
	var productTitle = document.getElementById("productTitle");
	var productDescription = document.getElementById("productDescription");
	var productPrice = document.getElementById("productPrice");
	var productImage = document.querySelector(".modal-image");

	productTitle.textContent = title;
	productDescription.textContent = description;
	productPrice.textContent = "Prix : $" + price;
	productImage.src = image;

	// Mettre à jour les produits connexes (recommandations)
	var relatedProducts = document.getElementById("relatedProducts");
	relatedProducts.innerHTML = "";

	recommendedProducts.forEach(function(product) {
		addRecommendedProduct(product.title, product.image);
	});
}

function addRecommendedProduct(title, image) {
	var relatedProducts = document.getElementById("relatedProducts");

	var relatedProduct = document.createElement("div");
	relatedProduct.classList.add("col-md-4");

	var productImage = document.createElement("img");
	productImage.src = image;
	productImage.classList.add("img-fluid");
	productImage.classList.add("temp");

	relatedProduct.appendChild(productImage);
	relatedProducts.appendChild(relatedProduct);
}

function closeModal() {
	var modal = document.getElementById("productModal");
	modal.style.display = "none";
}

window.onclick = function(event) {
	if (event.target.classList.contains('custom-modal')) {
		event.target.style.display = "none";
	}
};