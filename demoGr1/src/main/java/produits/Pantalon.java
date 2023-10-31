package produits;

//Pantalon.java
public abstract class Pantalon implements Vetement {
 private int id;
 private String taille;
 private String style;
 private String imagePath;

 public Pantalon(int id, String taille, String style, String path) {
     this.id = id;
     this.setTaille(taille);
     this.setStyle(style);
     this.setImagePath(path);
 }

 @Override
 public int getId() {
     return id;
 }

public String getTaille() {
	return taille;
}

public void setTaille(String taille) {
	this.taille = taille;
}

public String getStyle() {
	return style;
}

public void setStyle(String style) {
	this.style = style;
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

 // ... autres getters et méthodes
}
