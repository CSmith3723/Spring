package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.user.WebUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    // --- HOME PAGE --- //

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String redirectHome(){
        return "redirect:/home";
    }


}
