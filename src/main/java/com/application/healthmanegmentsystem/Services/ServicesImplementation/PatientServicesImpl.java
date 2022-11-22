package com.application.healthmanegmentsystem.Services.ServicesImplementation;

import com.application.healthmanegmentsystem.Entity.Appointment;
import com.application.healthmanegmentsystem.Entity.Role;
import com.application.healthmanegmentsystem.Entity.UserInfo;
import com.application.healthmanegmentsystem.Repository.AppointmentRepository;
import com.application.healthmanegmentsystem.Repository.AuthoritiesRepository;
import com.application.healthmanegmentsystem.Repository.UserInfoRepository;
import com.application.healthmanegmentsystem.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class PatientServicesImpl implements PatientServices {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public String processRegistration(UserInfo userInfo) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role("ADMIN"));
        String[] name = userInfo.getFirstName().split(" ",2);
        userInfo.setFirstName(name[0]);
        userInfo.setLastName(name.length == 2 ? name[1]:"");
        userInfo.setRoles(roleSet);
        userInfo.setEnabled(true);
        userInfoRepository.save(userInfo);
        return "Saved";
    }

    @Override
    public List<UserInfo> getAllUser() {
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        return userInfoList;
    }

    @Override
    public UserInfo getLogedInUserDetailss(String username) {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        System.out.println(userInfo.getAppointmentList());
        return userInfo;
    }

    @Override
    public List<Appointment> getAllAppointment() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    @Override
    public void updateProfile(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void saveAppoinment(Appointment appointment,String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<Appointment> appointmentSet = new HashSet<>();
        System.out.println(appointment);
        appointmentSet.add(appointment);
        userinfo.setAppointmentList(appointmentSet);
        userInfoRepository.save(userinfo);
    }
}
