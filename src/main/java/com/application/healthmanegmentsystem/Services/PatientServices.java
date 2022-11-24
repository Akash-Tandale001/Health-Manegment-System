package com.application.healthmanegmentsystem.Services;

import com.application.healthmanegmentsystem.Entity.Appointment;
import com.application.healthmanegmentsystem.Entity.UserInfo;

import java.util.List;
import java.util.Set;

public interface PatientServices {
    String processRegistration(UserInfo userPatient);
    List<UserInfo> getAllUser();
    UserInfo getLogedInUserDetailss(String Username);

    List<Appointment> getAllAppointment();
    void updateProfile(UserInfo userInfo);

    void saveAppoinment(Appointment appointment,String username);
    void acceptAppointmentById(Long id);
    void rejectAppointmentById(Long id);
}
