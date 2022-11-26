package com.application.healthmanegmentsystem.Controller;

import com.application.healthmanegmentsystem.Entity.Appointment;
import com.application.healthmanegmentsystem.Entity.UserInfo;
import com.application.healthmanegmentsystem.Services.ServicesImplementation.PatientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    @Autowired
    private PatientServicesImpl patientServices;
    @GetMapping()
    public String getAdminDashboard(Model model){
        List<UserInfo> userInfoList = patientServices.getAllUser();
        model.addAttribute("patients",userInfoList);
        return "/Auth/AdminDashboard";
    }
    @GetMapping("/ambulanceRequest")
    public String getAmbulanceRequest(){
        return "/Auth/AdminRequestView/AmbulanceRequest";
    }
    @GetMapping("/bedFacilityRequest")
    public String getBedFacilityRequest(){
        return "/Auth/AdminRequestView/BedFacilityRequest";
    }
    @GetMapping("/medicineRequest")
    public String getMedicineRequest(){
        return "/Auth/AdminRequestView/MedicineRequest";
    }
    @GetMapping("/freeCheckupRequest")
    public String getFreeCheckupRequest(){
        return "/Auth/AdminRequestView/FreeCheckupRequest";
    }
    @GetMapping("/totalCareRequest")
    public String getTotalCareRequest(){
        return "/Auth/AdminRequestView/TotalCareRequest";
    }
    @GetMapping("/appointmentRequest")
    public String getApplicationRequest(Model model){
        List<Appointment> appointmentList = patientServices.getAllAppointment() ;
        model.addAttribute("appointmentList",appointmentList);
        return "/Auth/AdminRequestView/AppointmentRequest";
    }
    @GetMapping("/acceptAppointmentRequest/{id}")
    public String acceptApplicationRequest(@PathVariable("id") Long id){
        patientServices.acceptAppointmentById(id);
        return "redirect:/admin/appointmentRequest";
    }
    @GetMapping("/rejectAppointmentRequest/{id}")
    public String rejectApplicationRequest(@PathVariable("id") Long id){
        patientServices.rejectAppointmentById(id);
        return "redirect:/admin/appointmentRequest";
    }
    @GetMapping("/updateRole/{id}/{role}")
    public String updateUserRole(@PathVariable("id") Long id,@PathVariable("role") String role){
//        patientServices.updateUserRole(id,role);
        return "/Auth/AdminDashboard";
    }
}
