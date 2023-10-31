package produits;

//TShirtFemme.java
public class TShirtFemme extends TShirt {
 public TShirtFemme(int id, String taille, String couleur, String path) {
     super(id, taille, couleur, path);
 }

 @Override
 public void afficherDetails() {
     System.out.println("T-shirt pour femme - ID: " + getId() + ", Taille : " + getTaille() + ", Couleur : " + getCouleur());
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
