package com.rihem.medicament.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rihem.medicament.entities.Categorie;
import com.rihem.medicament.entities.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
	
	List<Medicament> findByNomMedicament(String nom);
	List<Medicament> findByNomMedicamentContains(String nom);
	@Query("select m from Medicament m where m.nomMedicament like %:nom and m.prixMedicament > :prix")
	List<Medicament> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	@Query("select m from Medicament m where m.categorie = ?1") 
	List<Medicament> findByCategorie (Categorie categorie);
	List<Medicament> findByCategorieIdCat(Long id);
	List<Medicament> findByOrderByNomMedicamentAsc();
	@Query("select m from Medicament m order by m.nomMedicament ASC, m.prixMedicament DESC")
	List<Medicament> trierMedicamentsNomsPrix ();
}
