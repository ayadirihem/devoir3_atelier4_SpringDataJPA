package com.rihem.medicament.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihem.medicament.entities.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

}
