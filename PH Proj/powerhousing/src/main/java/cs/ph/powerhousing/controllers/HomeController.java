package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.dao.UserResository;
import cs.ph.powerhousing.entities.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    UserResository userResository;

    public HomeController(UserResository userResository) {
        this.userResository = userResository;
    }

    @GetMapping("/")
    public String home(Model theModel){

        theModel.addAttribute("userinfo",new UserInfo());

        return "home";
    }


    @GetMapping("/userCalculator")
    public String userCalculator(Model theModel){
        theModel.addAttribute("userinfo", new UserInfo());
        return "login-confirmation";
    }


}
