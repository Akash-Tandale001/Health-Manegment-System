package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.BedFacilityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BedFacilityServiceRepository extends JpaRepository<BedFacilityService,Long> {
    @Query("select b from BedFacilityService as b where b.id = ?1")
    BedFacilityService findBedFacilityServiceById(Long id);

    Long deleteBedFacilityServiceById(Long id);

    @Query(value = "select a.bedFacility_service from bedFacilityService as a where a.bedFacility_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
