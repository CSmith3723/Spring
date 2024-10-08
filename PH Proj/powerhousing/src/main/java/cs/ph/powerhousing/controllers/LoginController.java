package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.user.WebUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/userLogin")
    public String login(Model theModel) {

        theModel.addAttribute("webUser", new WebUser());
        return "login-page";
    }

}
