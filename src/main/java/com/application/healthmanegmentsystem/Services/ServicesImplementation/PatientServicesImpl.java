package com.application.healthmanegmentsystem.Services.ServicesImplementation;

import com.application.healthmanegmentsystem.Entity.*;
import com.application.healthmanegmentsystem.Repository.*;
import com.application.healthmanegmentsystem.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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

    @Autowired
    AmbulanceServiceRepository ambulanceServiceRepository;

    @Autowired
    BedFacilityServiceRepository bedFacilityServiceRepository;

    @Autowired
    FreeCheckupServiceRepository freeCheckupServiceRepository;

    @Autowired
    MedicineServiceRepository medicineServiceRepository;

    @Autowired
    TotalCareServiceRepository totalCareServiceRepository;
    @Override
    public String processRegistration(UserInfo userInfo) {
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(new Role("USER"));
//        userInfo.setRoles(roleSet);
        String[] name = userInfo.getFirstName().split(" ",2);
        userInfo.setFirstName(name[0]);
        userInfo.setLastName(name.length == 2 ? name[1]:"");
        userInfo.setEnabled(true);
        Role role = new Role("USER");
        userInfo.setRoles(role);
        userInfoRepository.save(userInfo);
        return "Saved";
    }

    @Override
    public List<UserInfo> getAllUser() {
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        for(UserInfo i : userInfoList){
            i.setRole(i.getRoles().getName());
        }
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
    public List<AmbulanceService> getAllAmbulanceService() {
        List<AmbulanceService> ambulanceServices = ambulanceServiceRepository.findAll();
        return ambulanceServices;
    }

    @Override
    public List<BedFacilityService> getAllBedFacilityService() {
        List<BedFacilityService> bedFacilityServices = bedFacilityServiceRepository.findAll();
        return bedFacilityServices;
    }

    @Override
    public List<FreeCheckupService> getAllFreeCheckupService() {
        List<FreeCheckupService> freeCheckupServices = freeCheckupServiceRepository.findAll();
        return freeCheckupServices;
    }

    @Override
    public List<MedicineService> getAllMedicineService() {
        List<MedicineService> medicineServices = medicineServiceRepository.findAll();
        return medicineServices;
    }

    @Override
    public List<TotalcareService> getAllTotalcareService() {
        List<TotalcareService> totalcareServices = totalCareServiceRepository.findAll();
        return totalcareServices;
    }

    @Override
    public void updateProfile(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void saveAppoinment(Appointment appointment,String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<Appointment> appointmentSet = new HashSet<>();
        appointment.setStatus(false);
        appointmentSet.add(appointment);
        userinfo.setAppointmentList(appointmentSet);
        userInfoRepository.save(userinfo);
    }

    @Override
    public void saveAmbulanceService(AmbulanceService ambulanceService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<AmbulanceService> ambulanceServiceSet = new HashSet<>();
        ambulanceService.setStatus(false);
        ambulanceServiceSet.add(ambulanceService);
        userinfo.setAmbulanceServiceList(ambulanceServiceSet);
        userInfoRepository.save(userinfo);
    }

    @Override
    public void saveBedFacilityService(BedFacilityService bedFacilityService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<BedFacilityService> bedFacilityServiceSet = new HashSet<>();
        bedFacilityService.setStatus(false);
        bedFacilityServiceSet.add(bedFacilityService);
        userinfo.setBedFacilityServiceList(bedFacilityServiceSet);
        userInfoRepository.save(userinfo);
    }

    @Override
    public void saveFreeCheckupService(FreeCheckupService freeCheckupService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<FreeCheckupService> freeCheckupServiceSet = new HashSet<>();
        freeCheckupService.setStatus(false);
        freeCheckupServiceSet.add(freeCheckupService);
        userinfo.setFreeCheckupServiceList(freeCheckupServiceSet);
        userInfoRepository.save(userinfo);
    }

    @Override
    public void saveMedicineService(MedicineService medicineService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<MedicineService> medicineServiceSet = new HashSet<>();
        medicineService.setStatus(false);
        medicineServiceSet.add(medicineService);
        userinfo.setMedicineServicesList(medicineServiceSet);
        userInfoRepository.save(userinfo);
    }

    @Override
    public void saveTotalcareService(TotalcareService totalcareService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<TotalcareService> totalcareServiceSet = new HashSet<>();
        totalcareService.setStatus(false);
        totalcareServiceSet.add(totalcareService);
        userinfo.setTotalcareServicesList(totalcareServiceSet);
        userInfoRepository.save(userinfo);
    }

    @Override
    public void acceptAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        appointment.setStatus(true);
        appointmentRepository.save(appointment);
    }

    @Override
    public void rejectAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        appointment.setStatus(false);
        appointmentRepository.save(appointment);

    }

    @Override
    public void deleteAppointmentById(Long id) {
        Long deletedCount = appointmentRepository.deleteAppointmentById(id);
    }

    @Override
    public void acceptBedFacilityServiceById(Long id) {
        BedFacilityService bedFacilityService = bedFacilityServiceRepository.findBedFacilityServiceById(id);
        bedFacilityService.setStatus(true);
        bedFacilityServiceRepository.save(bedFacilityService);
    }

    @Override
    public void rejectBedFacilityServiceById(Long id) {
        BedFacilityService bedFacilityService = bedFacilityServiceRepository.findBedFacilityServiceById(id);
        bedFacilityService.setStatus(false);
        bedFacilityServiceRepository.save(bedFacilityService);
    }

    @Override
    public void deleteBedFacilityServiceById(Long id) {
        Long deletedCount =bedFacilityServiceRepository.deleteBedFacilityServiceById(id);
    }

    @Override
    public void acceptAmbulanceServiceById(Long id) {
        AmbulanceService ambulanceService = ambulanceServiceRepository.findAmbulanceServiceById(id);
        ambulanceService.setStatus(true);
        ambulanceServiceRepository.save(ambulanceService);
    }

    @Override
    public void rejectAmbulanceServiceById(Long id) {
        AmbulanceService ambulanceService = ambulanceServiceRepository.findAmbulanceServiceById(id);
        ambulanceService.setStatus(false);
        ambulanceServiceRepository.save(ambulanceService);
    }

    @Override
    public void deleteAmbulanceServiceById(Long id) {
        Long deletedCount =ambulanceServiceRepository.deleteAmbulanceServiceById(id);
    }

    @Override
    public void acceptFreeCheckupServiceById(Long id) {
        FreeCheckupService freeCheckupService = freeCheckupServiceRepository.findFreeCheckupServiceById(id);
        freeCheckupService.setStatus(true);
        freeCheckupServiceRepository.save(freeCheckupService);
    }

    @Override
    public void rejectFreeCheckupServiceById(Long id) {
        FreeCheckupService freeCheckupService = freeCheckupServiceRepository.findFreeCheckupServiceById(id);
        freeCheckupService.setStatus(false);
        freeCheckupServiceRepository.save(freeCheckupService);
    }

    @Override
    public void deleteFreeCheckupServiceById(Long id) {
        Long deletedCount = freeCheckupServiceRepository.deleteFreeCheckupServiceById(id);
    }

    @Override
    public void acceptMedicineServiceById(Long id) {
        MedicineService medicineService = medicineServiceRepository.findMedicineServiceById(id);
        medicineService.setStatus(true);
        medicineServiceRepository.save(medicineService);
    }

    @Override
    public void rejectMedicineServiceById(Long id) {
        MedicineService medicineService = medicineServiceRepository.findMedicineServiceById(id);
        medicineService.setStatus(true);
        medicineServiceRepository.save(medicineService);
    }

    @Override
    public void deleteMedicineServiceById(Long id) {
        Long deletedCount = medicineServiceRepository.deleteMedicineServiceById(id);
    }

    @Override
    public void acceptTotalcareServiceById(Long id) {
        TotalcareService totalcareService = totalCareServiceRepository.findTotalcareServiceById(id);
        totalcareService.setStatus(true);
        totalCareServiceRepository.save(totalcareService);
    }

    @Override
    public void rejectTotalcareServiceById(Long id) {
        TotalcareService totalcareService = totalCareServiceRepository.findTotalcareServiceById(id);
        totalcareService.setStatus(false);
        totalCareServiceRepository.save(totalcareService);
    }

    @Override
    public void deleteTotalcareServiceById(Long id) {
        Long deletedCount =totalCareServiceRepository.deleteTotalcareServiceById(id);
    }
}
