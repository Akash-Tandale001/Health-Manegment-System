package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.AmbulanceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceServiceRepository extends JpaRepository<AmbulanceService,Long> {
    AmbulanceService findAmbulanceServiceById(Long id);
}
