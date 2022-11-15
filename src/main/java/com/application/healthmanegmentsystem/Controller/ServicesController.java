package com.application.healthmanegmentsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServicesController {
    @GetMapping("/")
    public String getServicesPage(){
        return "/View/Services";
    }

    @GetMapping("/freeCheckup")
    public String getServicesFreeCheckupPage(){
        return "/ServicesForm/FreeCheckup";
    }

    @GetMapping("/ambulance")
    public String getServicesAmbulancePage(){
        return "/ServicesForm/Ambulance";
    }

    @GetMapping("/medicines")
    public String getServicesMedicinesPage(){
        return "/ServicesForm/Medicines";
    }

    @GetMapping("/bedFacility")
    public String getServicesBedFacilityPage(){
        return "/ServicesForm/BedFacility";
    }

    @GetMapping("/totalCare")
    public String getServicesTotalCarePage(){
        return "/ServicesForm/TotalCare";
    }


}
