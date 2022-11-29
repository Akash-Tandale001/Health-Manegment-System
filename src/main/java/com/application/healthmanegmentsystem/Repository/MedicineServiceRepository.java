package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.MedicineService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineServiceRepository extends JpaRepository<MedicineService,Long> {
    MedicineService findMedicineServiceById(Long id);
}
