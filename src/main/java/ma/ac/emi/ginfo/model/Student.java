package ma.ac.emi.ginfo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Student extends Personne {

	@NotNull
	private int niveau = 1;
	private Boolean anneeReserve = false;

	@OneToMany(mappedBy = "id.student")
	private List<Note> notes = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance) {
		super(matricule, nom, prenom, date_naissance);
	}

	public Student(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull int niveau) {
		this(matricule, nom, prenom, date_naissance);
		this.niveau = niveau;
	}

	public Student(@NotNull Long matricule, @NotNull String nom, @NotNull String prenom, LocalDate date_naissance,
			@NotNull int niveau, boolean anneeReserve) {
		this(matricule, nom, prenom, date_naissance, niveau);
		this.anneeReserve = anneeReserve;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public boolean isAnneeReserve() {
		return anneeReserve;
	}

	public void setAnneeReserve(boolean anneeReserve) {
		this.anneeReserve = anneeReserve;
	}

	public int size() {
		return notes.size();
	}

	public boolean contains(Object o) {
		return notes.contains(o);
	}

	public boolean add(Note e) {
		return notes.add(e);
	}

	public boolean remove(Object o) {
		return notes.remove(o);
	}

	public Note get(int index) {
		return notes.get(index);
	}

	@Override
	public String toString() {
		return "Student [personne=" + super.toString() + ", niveau=" + niveau + ", anneeReserve=" + anneeReserve + ", email=" + anneeReserve + "]";
	}

}
