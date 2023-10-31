package produits;

//Short.java
public class Short extends Pantalon {
 public Short(int id, String taille, String style, String path) {
     super(id, taille, style, path);
 }

 @Override
 public void afficherDetails() {
     System.out.println("Short - ID: " + getId() + ", Taille : " + getTaille() + ", Style : " + getStyle());
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
