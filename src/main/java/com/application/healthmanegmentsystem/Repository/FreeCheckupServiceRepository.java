package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.FreeCheckupService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeCheckupServiceRepository extends JpaRepository<FreeCheckupService,Long> {
    @Query("select f from FreeCheckupService as f where f.id = ?1")
    FreeCheckupService findFreeCheckupServiceById(Long id);

    Long deleteFreeCheckupServiceById(Long id);
}
