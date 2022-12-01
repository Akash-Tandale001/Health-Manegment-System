package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.AmbulanceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceServiceRepository extends JpaRepository<AmbulanceService,Long> {
    @Query("select a from AmbulanceService as a where a.id = ?1")
    AmbulanceService findAmbulanceServiceById(Long id);
}
