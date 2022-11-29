package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.MedicineService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineServiceRepository extends JpaRepository<MedicineService,Long> {
    MedicineService findMedicineServiceById(Long id);
}
