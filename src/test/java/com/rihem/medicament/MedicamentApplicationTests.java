package com.rihem.medicament;


import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

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
	public void testFindByNomMedicamentContains()
	{
	Page<Medicament> prods = medicamentService.getAllMedicamentsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements()); 
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {
		System.out.println(p.toString()
				);
	});
	}

}
