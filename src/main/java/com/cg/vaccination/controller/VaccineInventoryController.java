package com.cg.vaccination.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vaccination.dto.VaccineInventoryDto;
import com.cg.vaccination.exception.VaccineInventoryNotFoundException;
import com.cg.vaccination.model.VaccinationCenter;
import com.cg.vaccination.model.Vaccine;
import com.cg.vaccination.model.VaccineInventory;
import com.cg.vaccination.service.VaccineInventoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class VaccineInventoryController {

	@Autowired
	private VaccineInventoryService vaccineInventoryService;

	
	@PostMapping("/vaccine/inventory/new")
	private VaccineInventory addVaccineInventory(@RequestBody VaccineInventoryDto inv) {
		VaccinationCenter center = new VaccinationCenter();
		Vaccine vaccine = new Vaccine();
		center.setCode(inv.getCenterCode());
		vaccine.setVaccineId(inv.getVaccineId());
		VaccineInventory inventory = new VaccineInventory(inv.getId(),inv.getQuantity(),inv.getPrice(),inv.getDate(), center, vaccine);
		return vaccineInventoryService.addVaccineInventory(inventory);

	}

	@GetMapping("/vaccine/inventory/all")
	private List<VaccineInventoryDto> allVaccineInventory() {
		List<VaccineInventory> vList = vaccineInventoryService.allVaccineInventory();
		List<VaccineInventoryDto> vDtoList = new ArrayList<VaccineInventoryDto>();
		Iterator<VaccineInventory> vaccines = vList.iterator();
		while(vaccines.hasNext()) {
			VaccineInventory vc = vaccines.next();
			VaccineInventoryDto vd = new VaccineInventoryDto();
			vd.setId(vc.getId());
			vd.setPrice(vc.getPrice());
			vd.setDate(vc.getDate());
			vd.setQuantity(vc.getQuantity());
			vd.setCenterCode(vc.getCenter().getCode());
			vd.setVaccineId(vc.getVaccine().getVaccineId());
			vDtoList.add(vd);
		}
		return vDtoList;
		
	}
	
	
	@GetMapping("/vaccine/inventory/invId/{invId}")
	private ResponseEntity<VaccineInventory> getVaccineInventoryById(@PathVariable(value = "invId") int invId)
			throws VaccineInventoryNotFoundException {
		VaccineInventory inv = vaccineInventoryService.getVaccineInventoryById(invId).orElseThrow(
				() -> new VaccineInventoryNotFoundException("No vaccineinventory found with this id " + invId));
		return ResponseEntity.ok().body(inv);
	}
	
	@PutMapping("/vaccine/inventory/update/{invId}")
	private ResponseEntity<VaccineInventory> updateVaccineInventory(@PathVariable(value = "invId") int invId,
			@RequestBody VaccineInventory invDetails) throws VaccineInventoryNotFoundException {
		VaccineInventory inv = vaccineInventoryService.getVaccineInventoryById(invId).orElseThrow(
				() -> new VaccineInventoryNotFoundException("No vaccineinventory with this is id " + invId));
		 inv.setDate(invDetails.getDate());
		//inv.setCenter(invDetails.getCenter());
		inv.setQuantity(invDetails.getQuantity());
		//inv.setVaccine(invDetails.getVaccine());
		inv.setPrice(invDetails.getPrice());
		 VaccineInventory updateInv = vaccineInventoryService.updateVaccineInventory(inv);
		 return ResponseEntity.ok().body(updateInv);
	}



	@DeleteMapping("/vaccine/inventory/delete/{id}")
	private Map<String, Boolean> deleteVaccineInventory(@PathVariable(value = "id") Integer invId)
			throws VaccineInventoryNotFoundException {
		VaccineInventory inv = vaccineInventoryService.getVaccineInventoryById(invId)
				.orElseThrow(() -> new VaccineInventoryNotFoundException(
						"No Vaccine inventory found with this invId " + invId));
		vaccineInventoryService.deleteVaccineInventory(inv);
		Map<String, Boolean> response = new HashMap();
		response.put("Delete", true);
		return response;
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handlerMethodAreNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}