package ma.ac.emi.ginfo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

	@Id
	@NotNull
	private Long matricule;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	private LocalDate date_naissance;

	@OneToOne()
	@JoinColumn(name = "matricule", referencedColumnName = "id", insertable = false, updatable = false)
	private Compte compte;

	public Personne() {
		super();
	}

	public Personne(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		setDate_naissance(date_naissance);
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Personne [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance="
				+ date_naissance + ", Email=" + compte.getEmail() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		return true;
	}

}
