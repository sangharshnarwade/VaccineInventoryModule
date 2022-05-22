package com.cg.vaccination.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vaccination.model.VaccineInventory;
import com.cg.vaccination.repository.VaccineInventoryRepository;
import com.cg.vaccination.service.VaccineInventoryService;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService {

	@Autowired
	private VaccineInventoryRepository vaccineInventoryRepository;

	@Override
	public VaccineInventory addVaccineInventory(VaccineInventory inv) {
		return vaccineInventoryRepository.save(inv);
	}

	@Override
	public List<VaccineInventory> allVaccineInventory() {
		return vaccineInventoryRepository.findAll();
	}

	@Override
	public Optional<VaccineInventory> getVaccineInventoryById(int invId) {
		return vaccineInventoryRepository.findById(invId);
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inv) {
		return vaccineInventoryRepository.save(inv);
	}

	@Override
	public void deleteVaccineInventory(VaccineInventory inv) {
		vaccineInventoryRepository.delete(inv);

	}

}
