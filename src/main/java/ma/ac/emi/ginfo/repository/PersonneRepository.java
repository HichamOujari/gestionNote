package ma.ac.emi.ginfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.ginfo.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long>{
	public List<Personne> findByNom(String nom);
	
}
