package com.rihem.medicament.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rihem.medicament.entities.Medicament;
import com.rihem.medicament.service.MedicamentService;

@Controller
public class MedicamentController {
	
	@Autowired
	MedicamentService medicamentService;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createMedicament";
	}
	
	@RequestMapping("/saveMedicament")
		public String saveMedicament(@ModelAttribute("medicament") Medicament medicament,
				@RequestParam("date") String date,
				ModelMap modelMap) throws ParseException{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		medicament.setDateCreation(dateCreation);
		
		Medicament saveMedicament = medicamentService.saveMedicament(medicament);
		String msg = "medicament enregistré avec Id"+saveMedicament.getIdMedicament();
		modelMap.addAttribute("msg",msg);
		List<Medicament> drugs= medicamentService.getAllMedicaments();
		modelMap.addAttribute("medicaments",drugs);
		return "listeMedicaments";
	}
	
	@RequestMapping("/ListeMedicaments")
	public String listeMedicament(ModelMap modelMap) {
		List<Medicament> drugs= medicamentService.getAllMedicaments();
		modelMap.addAttribute("medicaments", drugs);
		return "listeMedicaments";
	}
	@RequestMapping("/supprimerMedicament")
	public String supprimerProduit(@RequestParam("id") Long id,
			ModelMap modelMap) {
		medicamentService.deleteMedicamentById(id);
		List<Medicament> drugs= medicamentService.getAllMedicaments();
		modelMap.addAttribute("medicaments", drugs);
		return "listeMedicaments";
	}
	
	@RequestMapping("/modifierMedicament")
	public String editerMedicament(@RequestParam("id") Long id,
			ModelMap modelMap) {
		Medicament m = medicamentService.getMedicament(id);
		modelMap.addAttribute("medicament", m);
		return "editerMedicament";
	}
	
	@RequestMapping("/updateMedicament")
	public String updateMedicament(@ModelAttribute("medicament") Medicament medicament,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		medicament.setDateCreation(dateCreation);
		
		medicamentService.updateMedicament(medicament);
		List<Medicament> drugs= medicamentService.getAllMedicaments();
		modelMap.addAttribute("medicaments",drugs);
		return "listeMedicaments";
	}
}
