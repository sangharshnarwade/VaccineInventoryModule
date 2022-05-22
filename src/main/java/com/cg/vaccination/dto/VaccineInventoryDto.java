package com.cg.vaccination.dto;


import java.time.LocalDate;



import lombok.Data;


@Data
public class VaccineInventoryDto {

	private int id;
	private int quantity;
	private double price;
	private LocalDate date;
	private int centerCode;
    private int vaccineId;
	
}
