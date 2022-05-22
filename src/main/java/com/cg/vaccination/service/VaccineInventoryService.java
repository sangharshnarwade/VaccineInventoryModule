package com.cg.vaccination.service;


import java.util.List;
import java.util.Optional;


import com.cg.vaccination.model.VaccineInventory;

public interface VaccineInventoryService {
	
	public List<VaccineInventory> allVaccineInventory();

	public VaccineInventory addVaccineInventory(VaccineInventory inv);
	
	public Optional<VaccineInventory> getVaccineInventoryById(int invId);
	
	public VaccineInventory updateVaccineInventory(VaccineInventory inv);

	public void deleteVaccineInventory(VaccineInventory inv);

	
    
	
}
