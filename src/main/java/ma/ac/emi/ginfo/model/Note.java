package ma.ac.emi.ginfo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Note {

	@EmbeddedId
	private PK id;
	@NotNull
	private float note;
	private String abreciation;
	
	public Note(@NotNull float note, String abreciation, Student student, Matiere matiere) {
		super();
		this.note = note;
		this.abreciation = abreciation;
		this.id = new PK(student, matiere);
	}

	public Note() {
		super();
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public String getAbreciation() {
		return abreciation;
	}

	public void setAbreciation(String abreciation) {
		this.abreciation = abreciation;
	}

	public Student getStudent() {
		return id.getStudent();
	}


	public Matiere getMatiere() {
		return id.getMatiere();
	}

	@Override
	public String toString() {
		return "Note [note=" + note + ", abreciation=" + abreciation + ", student=" + id.getStudent()
				+ ", matiere=" + id.getMatiere() + "]";
	}

}
