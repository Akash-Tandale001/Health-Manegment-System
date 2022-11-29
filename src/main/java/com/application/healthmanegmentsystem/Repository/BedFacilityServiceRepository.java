package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.BedFacilityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedFacilityServiceRepository extends JpaRepository<BedFacilityService,Long> {
    BedFacilityService findBedFacilityServiceById(Long id);
}
