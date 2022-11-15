package com.application.healthmanegmentsystem.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApppointmentController {
    @GetMapping("/bookAppointment")
    public String getAppointmentPage(){
        return "/View/BookAppointment";
    }
}
