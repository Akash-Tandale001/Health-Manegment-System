package com.application.healthmanegmentsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/home")
    public String getDashBoardPage(){
        return "View/Home";
    }
}
