package com.application.healthmanegmentsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    @GetMapping()
    public String getAdminDashboard(){
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
}
