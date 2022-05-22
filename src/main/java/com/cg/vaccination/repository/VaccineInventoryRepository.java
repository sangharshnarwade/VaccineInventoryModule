package com.cg.vaccination.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.vaccination.model.VaccineInventory;
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Integer> {
//public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date);
//public VaccineInventory addVaccineInventoryByVaccineCount(VaccineInventory inv);
//public Optional<VaccineInventory> getVaccineInventoryByCenter(Integer centerId);
//public Optional<VaccineInventory>getVaccineInventoryByVaccine(long vaccineId);

}
