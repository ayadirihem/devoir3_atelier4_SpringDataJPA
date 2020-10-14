package com.rihem.medicament.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihem.medicament.entities.Medicament;
import com.rihem.medicament.repos.MedicamentRepository;

@Service
public class MedicamentServiceImpl implements MedicamentService {

	@Autowired
	MedicamentRepository medicamentRepository;
	@Override
	public Medicament saveMedicament(Medicament m) {
		// TODO Auto-generated method stub
		return medicamentRepository.save(m);
	}

	@Override
	public Medicament updateMedicament(Medicament m) {
		// TODO Auto-generated method stub
		return medicamentRepository.save(m);
	}

	@Override
	public void deleteMedicament(Medicament m) {
		// TODO Auto-generated method stub
		medicamentRepository.delete(m);
	}

	@Override
	public void deleteMedicamentById(Long id) {
		// TODO Auto-generated method stub
		medicamentRepository.deleteById(id);
		
	}

	@Override
	public Medicament getMedicament(Long id) {
		// TODO Auto-generated method stub
		return medicamentRepository.findById(id).get();
	}

	@Override
	public List<Medicament> getAllMedicaments() {
		// TODO Auto-generated method stub
		return medicamentRepository.findAll();
	}

}
