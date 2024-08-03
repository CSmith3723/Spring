package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.configs.GoogleMapsConfig;
import cs.ph.powerhousing.entities.UserInfo;
import cs.ph.powerhousing.services.CalculatorService;
import cs.ph.powerhousing.services.HousingService;
import cs.ph.powerhousing.services.UserService;
import cs.ph.powerhousing.entities.Calculator;
import cs.ph.powerhousing.entities.Housing;
import cs.ph.powerhousing.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContentController {

    private UserService userService;
    private HousingService housingService;
    private CalculatorService calculatorService;

    public ContentController(UserService userService, HousingService housingService, CalculatorService calculatorService) {
        this.userService = userService;
        this.calculatorService = calculatorService;
        this.housingService = housingService;
    }

    // --- HOME PAGE --- //

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String redirectHome(){
        return "redirect:/home";
    }


    // --- LOGIN PAGE --- //

    @GetMapping("/userLogin")
    public String login(Model theModel) {
        theModel.addAttribute("webUser", new WebUser());
        return "login-page";
    }

    @GetMapping("/confirmLogin")
    public String confirmLogin(Model theModel){
        theModel.addAttribute("webUser", new WebUser());
        return "login-confirmation";
    }


    // --- CALCULATOR --- //

    @GetMapping("/calculator")
    public String showCalculator(Model theModel, HttpSession session, GoogleMapsConfig googleMapsConfig){

        String username = (String) session.getAttribute("currentUser");
        String defaultCity = googleMapsConfig.getDefaultCity();

        theModel.addAttribute("calculator", new Calculator());
        theModel.addAttribute("housing", new Housing());
        theModel.addAttribute("currentUser", username);
        theModel.addAttribute("cityName", defaultCity);

        return "calculator-form";
    }

    @PostMapping("/processCalculation")
    public String processForm(@ModelAttribute("calculator") Calculator calculator){

        calculator.setGrossMonthlyWages(calculatorService.calculateGrossWages(calculator));
        calculator.setNetMonthlyWages(calculatorService.calculateNetWages(calculator));

        return "calculator-confirmation";
    }

    @ModelAttribute("neighborhoods")
    public List<String> neighborhoods(){
        List<String> neighborhoods = housingService.neighborhoodsList();
        return neighborhoods;
    }


    // --- MAP --- //

    @GetMapping("/showMap")
    public String showMapInCalculator(@RequestParam(name = "cityName", defaultValue = "Tampa") String cityName,
                                      Model model) {
        model.addAttribute("cityName", cityName);
        return "calculator"; // Ensure this matches your Thymeleaf template name
    }




    // --- USER REGISTRATION --- //

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/createUser")
    public String createUser(Model theModel){
        theModel.addAttribute("webUser", new WebUser());
        theModel.addAttribute("success", false);
        return "create-user";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(@Valid @ModelAttribute("webUser") WebUser webUser,
                                      BindingResult bindingResult,
                                      HttpSession session,
                                      Model theModel) {

        UserInfo existingUser = userService.findByUsername(webUser.getUsername());
        if(existingUser != null){
            theModel.addAttribute("webUser", new WebUser());
            theModel.addAttribute("registrationError",
                    "Username already exists.");
            System.out.println("Username already exists.");
            return "create-user";
        }

        if(!webUser.getPassword().equals(webUser.getConfirmPassword())){
            theModel.addAttribute("passwordMatchError",
                    "Password and Confirm Password do not match.");
        }

        try {

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            UserInfo newUser = new UserInfo();
            newUser.setUsername(webUser.getUsername());
            newUser.setUserPassword(bCryptPasswordEncoder.encode(webUser.getPassword()));

            userService.save(webUser);
            theModel.addAttribute("success", true);
            System.out.println("Successfully created user: " + webUser);

        }catch (Exception ex){
            bindingResult.addError(new FieldError("webUser", "username",
                    ex.getMessage()));
        }

        return "home";
    }

}
