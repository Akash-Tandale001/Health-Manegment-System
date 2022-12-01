package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query("select a from Appointment as a where a.id = ?1")
    Appointment findAppointmentById(Long id);
}
