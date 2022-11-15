package com.application.healthmanegmentsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {
    @GetMapping("/services")
    public String getServicesPage(){
        return "/View/Services";
    }
}
