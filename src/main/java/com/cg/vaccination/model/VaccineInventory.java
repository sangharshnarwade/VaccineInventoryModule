package com.cg.vaccination.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int quantity;
	private double price;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "center_Code")
	private VaccinationCenter center;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;

	public VaccineInventory() {
		super();

	}

	public VaccineInventory(int id, int quantity, double price, LocalDate date, VaccinationCenter center,
			Vaccine vaccine) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.center = center;
		this.vaccine = vaccine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public VaccinationCenter getCenter() {
		return center;
	}

	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	@Override
	public String toString() {
		return "VaccineInventory [id=" + id + ", quantity=" + quantity + ", price=" + price + ", date=" + date
				+ ", center=" + center + ", vaccine=" + vaccine + "]";
	}

}
