package com.application.healthmanegmentsystem.Services;

import com.application.healthmanegmentsystem.Entity.UserInfo;

import java.util.List;

public interface PatientServices {
    String processRegistration(UserInfo userPatient);
    List<UserInfo> getAllUser();
}
