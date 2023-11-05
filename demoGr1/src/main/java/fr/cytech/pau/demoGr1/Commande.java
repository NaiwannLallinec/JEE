package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    @OneToMany(mappedBy = "commandeDesLignes")
    List<CommandeLigne> commandeLignes;

    @OneToOne
    private Paiement paiement; 


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<CommandeLigne> getCommandeLignes() {
        return commandeLignes;
    }

    public void setCommandeLignes(List<CommandeLigne> commandeLignes) {
        this.commandeLignes = commandeLignes;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Commande other = (Commande) obj;
        return Objects.equals(commandeLignes, other.commandeLignes) && Objects.equals(id, other.id)
                && Objects.equals(person, other.person);
    }

	public int getQuantite() {
		return 0;
	}

	public Object getProduct() {
		return null;
	}
}
