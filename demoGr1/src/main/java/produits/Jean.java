package produits;

//Jean.java
public class Jean extends Pantalon {
 public Jean(int id, String taille, String style, String path) {
     super(id, taille, style, path);
 }

 @Override
 public void afficherDetails() {
     System.out.println("Jean - ID: " + getId() + ", Taille : " + getTaille() + ", Style : " + getStyle());
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
