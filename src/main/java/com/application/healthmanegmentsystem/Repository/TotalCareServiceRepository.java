package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.TotalcareService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCareServiceRepository extends JpaRepository<TotalcareService,Long> {
    TotalcareService findTotalcareServiceById(Long id);
}
