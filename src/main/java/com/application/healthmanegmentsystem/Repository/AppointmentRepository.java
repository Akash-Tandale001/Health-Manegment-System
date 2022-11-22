package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
