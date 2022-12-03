package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.MedicineService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineServiceRepository extends JpaRepository<MedicineService,Long> {
    @Query("select m from MedicineService as m where m.id = ?1")
    MedicineService findMedicineServiceById(Long id);

    Long deleteMedicineServiceById(Long id);

    @Query(value = "select a.medicine_service medicineService from freeCheckupService as a where a.medicine_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
