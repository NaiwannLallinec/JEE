package produits;

//TShirt.java
public abstract class TShirt implements Vetement {
 private int id;
 private String taille;
 private String couleur;
 private String imagePath;

 public TShirt(int id, String taille, String couleur, String path) {
     this.id = id;
     this.setTaille(taille);
     this.setCouleur(couleur);
     this.setImagePath(path);
 }

 @Override
 public int getId() {
     return id;
 }

public String getCouleur() {
	return couleur;
}

public void setCouleur(String couleur) {
	this.couleur = couleur;
}

public String getTaille() {
	return taille;
}

public void setTaille(String taille) {
	this.taille = taille;
}

public String getImagePath() {
	return imagePath;
}

public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

public void afficherDetails() {
	// TODO Auto-generated method stub
	
}


 
}
