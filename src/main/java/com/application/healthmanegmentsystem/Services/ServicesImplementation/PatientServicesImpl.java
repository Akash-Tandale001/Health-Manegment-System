package com.application.healthmanegmentsystem.Services.ServicesImplementation;

import com.application.healthmanegmentsystem.Entity.Role;
import com.application.healthmanegmentsystem.Entity.UserInfo;
import com.application.healthmanegmentsystem.Repository.AuthoritiesRepository;
import com.application.healthmanegmentsystem.Repository.UserInfoRepository;
import com.application.healthmanegmentsystem.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class PatientServicesImpl implements PatientServices {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Override
    public String processRegistration(UserInfo userInfo) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role("USER"));
        userInfo.setRoles(roleSet);
        userInfo.setEnabled(true);
        userInfoRepository.save(userInfo);
        return "Saved";
    }
}
