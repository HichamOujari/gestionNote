package ma.ac.emi.ginfo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.ginfo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Page<Student> findByNom(String nom, Pageable pageable);
}
