package com.cg.vaccination.exception;

public class VaccineInventoryNotFoundException extends Exception {
	public VaccineInventoryNotFoundException() {
	}
	public VaccineInventoryNotFoundException(String message) {
		super(message);
	}
}