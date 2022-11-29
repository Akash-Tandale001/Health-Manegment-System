package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.FreeCheckupService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeCheckupServiceRepository extends JpaRepository<FreeCheckupService,Long> {
    FreeCheckupService findFreeCheckupServiceById(Long id);
}
