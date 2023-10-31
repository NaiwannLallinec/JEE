package produits;

//TShirtHomme.java
public class TShirtHomme extends TShirt {
 public TShirtHomme(int id, String taille, String couleur, String path) {
     super(id, taille, couleur, path);
 }

 @Override
 public void afficherDetails() {
     System.out.println("T-shirt pour homme - ID: " + getId() + ", Taille : " + getTaille() + ", Couleur : " + getCouleur());
 }

@Override
public String getNom() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getDescription() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public double getPrix() {
	// TODO Auto-generated method stub
	return 0;
}
}
