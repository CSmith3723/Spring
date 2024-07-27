package cs.ph.powerhousing.controllers;

import ch.qos.logback.classic.Logger;
import cs.ph.powerhousing.entities.UserInfo;
import cs.ph.powerhousing.user.WebUser;

import cs.ph.powerhousing.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    Logger logger;
    UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/createUser")
    public String createUser(Model theModel){
        theModel.addAttribute("userinfo", new WebUser());
        return "register/create-user";
    }




    @PostMapping("/newUserConfirmation")
    public String processRegistration(@Valid @ModelAttribute("webUser") WebUser webUser,
                                      BindingResult bindingResult,
                                      HttpSession session,
                                      Model theModel) {

        String username = webUser.getUsername();
        logger.info("Registering new user: " + username);

        if(bindingResult.hasErrors()){
            return "register/create-user";
        }

        UserInfo existingUser = userService.findByUsername(username);
        if(existingUser != null){
            theModel.addAttribute("userinfo", new WebUser());
            theModel.addAttribute("registrationError",
                    "Username already exists.");


        logger.warn("Username already exists.");
        return "register/create-user";
    }
        userService.save(webUser);
        logger.info("Successfully created user: " + webUser);


        session.setAttribute("user", webUser);

        return "register/new-user-confirmation";
    }
}
