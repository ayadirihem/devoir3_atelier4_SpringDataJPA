package com.rihem.medicament.entities;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Medicament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicament;
	private String nomMedicament;
	private Double prixMedicament;
	private int qteMedicament;
	private Date dateCreation;
	
	public Medicament() {
		super();
	}
	public Medicament(String nomMedicament, Double prixMedicament, int qteMedicament, Date dateCreation) {
		super();
		this.nomMedicament= nomMedicament;
		this.prixMedicament= prixMedicament;
		this.qteMedicament= qteMedicament;
		this.dateCreation= dateCreation;
	}
	public Long getIdMedicament() {
		return idMedicament;
	}
	public void setIdMedicament(Long idMedicament) {
		this.idMedicament = idMedicament;
	}
	public String getNomMedicament() {
		return nomMedicament;
	}
	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}
	public Double getPrixMedicament() {
		return prixMedicament;
	}
	public void setPrixMedicament(Double prixMedicament) {
		this.prixMedicament = prixMedicament;
	}
	public int getQteMedicament() {
		return qteMedicament;
	}
	public void setQteMedicament(int qteMedicament) {
		this.qteMedicament = qteMedicament;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", prixMedicament="
				+ prixMedicament + ", qteMedicament=" + qteMedicament + ", dateCreation=" + dateCreation + "]";
	}

}
