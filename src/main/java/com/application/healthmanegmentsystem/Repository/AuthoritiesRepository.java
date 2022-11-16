package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Role,Long> {
}
