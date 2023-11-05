package fr.cytech.pau.demoGr1;

public enum Taille {
	XS(1),
	S(2),
	M(3),
	L(4),
	XL(5),
	XXL(6);
	
	private int description;
	
	Taille(int description) {
		this.setDescription(description);
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}
}
