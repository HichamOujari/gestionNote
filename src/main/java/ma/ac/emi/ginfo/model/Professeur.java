package ma.ac.emi.ginfo.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Professeur extends Personne {
	@NotNull
	private int numSomme;
	@Enumerated(EnumType.STRING)
	private GradeType grade = GradeType.PA;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "professeurs")
	private Set<Matiere> matieres = new HashSet<>();

	public Professeur() {
		super();
	}

	public Professeur(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull int numSomme) {
		super(matricule, nom, prenom, date_naissance);
		this.numSomme = numSomme;
	}

	public Professeur(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull int numSomme, GradeType grade) {
		this(matricule, nom, prenom, date_naissance, numSomme);
		this.grade = grade;
	}

	public int getNumSomme() {
		return numSomme;
	}

	public void setNumSomme(int numSomme) {
		this.numSomme = numSomme;
	}

	public GradeType getGrade() {
		return grade;
	}

	public void setGrade(GradeType grade) {
		this.grade = grade;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Professeur [personne=" + super.toString() + ", numSomme=" + numSomme + ", grade=" + grade + "]";
	}

	public int size() {
		return matieres.size();
	}

	public boolean contains(Object o) {
		return matieres.contains(o);
	}

	public boolean add(Matiere e) {
		return matieres.add(e);
	}

	public boolean remove(Object o) {
		return matieres.remove(o);
	}

}
