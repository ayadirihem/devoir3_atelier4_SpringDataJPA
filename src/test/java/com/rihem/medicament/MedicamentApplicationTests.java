package com.rihem.medicament;


import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rihem.medicament.entities.Medicament;
import com.rihem.medicament.repos.MedicamentRepository;

@SpringBootTest
class MedicamentApplicationTests {

	@Autowired
	private MedicamentRepository medicamentRepository;
	@Test
	void contextLoads() {
	}
	@Test
	void testCreateMedicament() {
		Medicament med = new Medicament("Adole",2500.0,50,new Date());
		medicamentRepository.save(med);
	}

}
