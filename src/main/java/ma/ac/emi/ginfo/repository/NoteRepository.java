package ma.ac.emi.ginfo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.ginfo.model.Matiere;
import ma.ac.emi.ginfo.model.Note;
import ma.ac.emi.ginfo.model.PK;
import ma.ac.emi.ginfo.model.Student;

public interface NoteRepository extends JpaRepository<Note, PK>{

	Page<Note> findByIdStudentAndIdMatiere(Student student, Matiere matiere, Pageable pageable);
	Page<Note> findByIdStudent(Student student, Pageable pageable);
	Page<Note> findByIdMatiere(Matiere matiere, Pageable pageable);
}
