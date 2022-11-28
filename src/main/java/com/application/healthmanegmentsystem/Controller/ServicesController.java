package com.application.healthmanegmentsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServicesController {
    @GetMapping()
    public String getServicesPage(){
        return "/View/Services";
    }

    @GetMapping("/freeCheckup")
    public String getServicesFreeCheckupPage(){
        return "/ServicesForm/FreeCheckup";
    }
    @PostMapping("/applyFreeCheckup")
    public String applyFreeCheckupPage(){
        return "redirect:/freeCheckup";
    }

    @GetMapping("/ambulance")
    public String getServicesAmbulancePage(){
        return "/ServicesForm/Ambulance";
    }
    @PostMapping("/applyAmbulance")
    public String applyAmbulancePage(){
        return "redirect:/ambulance";
    }


    @GetMapping("/medicines")
    public String getServicesMedicinesPage(){
        return "/ServicesForm/Medicines";
    }
    @PostMapping("/applyMedicines")
    public String applyMedicinesPage(){
        return "redirect:/medicines";
    }


    @GetMapping("/bedFacility")
    public String getServicesBedFacilityPage(){
        return "/ServicesForm/BedFacility";
    }
    @PostMapping("/applyBedFacility")
    public String applyBedFacilityPage(){
        return "redirect:/bedFacility";
    }

    @GetMapping("/totalCare")
    public String getServicesTotalCarePage(){
        return "/ServicesForm/TotalCare";
    }
    @PostMapping("/applyTotalCare")
    public String applyTotalCarePage(){
        return "redirect:/totalCare";
    }


}
