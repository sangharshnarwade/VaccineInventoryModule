package com.cg.vaccination.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vaccineId;
	private String vaccineName;
	private String description;

	public Vaccine() {
		super();
		
	}

	public Vaccine(int vaccineId, String vaccineName, String description) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.description = description;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", vaccineName=" + vaccineName + ", description=" + description
				+ "]";
	}

}
