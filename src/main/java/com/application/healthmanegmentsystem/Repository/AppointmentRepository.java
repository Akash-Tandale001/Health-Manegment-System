package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Appointment findAppointmentById(Long id);
}
