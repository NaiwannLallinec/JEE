package fr.cytech.pau.demoGr1;

public enum Couleur {
	ROUGE("ROUGE"),
    VERT("VERT"),
    BLEU("BLEU"),
    JAUNE("JAUNE"),
    BLANC("BLANC"),
    NOIR("NOIR");
	
	private String description;
	
	Couleur(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
