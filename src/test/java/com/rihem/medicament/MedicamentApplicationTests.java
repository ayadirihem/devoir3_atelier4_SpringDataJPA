package com.rihem.medicament;


import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.rihem.medicament.entities.Categorie;
import com.rihem.medicament.entities.Medicament;
import com.rihem.medicament.repos.MedicamentRepository;
import com.rihem.medicament.service.MedicamentService;

@SpringBootTest
class MedicamentApplicationTests {

	@Autowired
	private MedicamentRepository medicamentRepository;
	private MedicamentService medicamentService;
	@Test
	void contextLoads() {
	}
	@Test
	void testCreateMedicament() {
		Medicament med = new Medicament("Adole",2500.0,50,new Date());
		medicamentRepository.save(med);
	}
	@Test
	public void testFindByNomMedicament() {
		
		List<Medicament> drugs = medicamentRepository.findByNomMedicament("panadol");
		for (Medicament m : drugs) {
			System.out.println(m);
		}
	}
	@Test
	public void findByNomMedicamentContains() {
		List<Medicament> drugs=medicamentRepository.findByNomMedicamentContains("panadol");
		for(Medicament m: drugs) {
			System.out.println(m);
		}
	}
	@Test
	public void testfindByNomPrix() {
		List<Medicament> drugs = medicamentRepository.findByNomPrix("panadol", 2530.0);
	}
	@Test
	public void testfindByCategorie()
	{
	    Categorie cat = new Categorie();
	    cat.setIdCat(1L);
	    List<Medicament> drugs = medicamentRepository.findByCategorie(cat);
	    for (Medicament d : drugs)
	           {
	              System.out.println(d);
	           }
	}
	@Test
	public void findByCategorieIdCat()
	{
	List<Medicament> drugs = medicamentRepository.findByCategorieIdCat(1L);
	for (Medicament d : drugs)
	  {
	   System.out.println(d);
	  }
	}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	    List<Medicament> drugs = medicamentRepository.findByOrderByNomMedicamentAsc();
	    for (Medicament d : drugs){
	           System.out.println(d);
	     }
	}
	@Test public void testTrierProduitsNomsPrix()
	{
	      List<Medicament> drugs = medicamentRepository.trierMedicamentsNomsPrix();
	      for (Medicament d : drugs)
	         {
	             System.out.println(d);
	         }
	}

}
