package ma.ac.emi.ginfo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.ginfo.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long>{
	
	Page<Matiere> findByNom(String nom, Pageable pageable);
	Matiere findByNom(String nom);
}
