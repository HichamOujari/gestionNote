package ma.ac.emi.ginfo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ac.emi.ginfo.model.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long>{

	Page<Professeur> findByNom(String nom, Pageable pageable);
	
	List<Professeur> findByNom(String nom);

	@Query("select p from Professeur p where p.nom like :x")
	public Page<Professeur> findProfesseurByNom(@Param("x") String nom, Pageable pageable);

}
