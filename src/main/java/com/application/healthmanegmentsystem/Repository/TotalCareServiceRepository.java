package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.TotalcareService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCareServiceRepository extends JpaRepository<TotalcareService,Long> {
    @Query("select t from TotalcareService as t where t.id = ?1")
    TotalcareService findTotalcareServiceById(Long id);
    Long deleteTotalcareServiceById(Long id);
    @Query(value = "select a.totalcare_service medicineService from totalcareService as a where a.totalCare_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
