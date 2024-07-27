package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.entities.Calculator;
import cs.ph.powerhousing.entities.Housing;
import cs.ph.powerhousing.services.HousingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CalculatorController {

    HousingService housingService;

    public CalculatorController(HousingService theHousingService) {
        housingService= theHousingService;
    }


    @GetMapping("/calculator")
    public String showCalculator(Model theModel){

        theModel.addAttribute("calculator", new Calculator());
        theModel.addAttribute("housing", new Housing());

        return "calculator-form";
    }

    @PostMapping("/processCalculation")
    public String processForm(@ModelAttribute("calculator") Calculator calculator){

        //theModel.addAttribute("calculator", new Calculator());
        calculator.setGrossMonthlyWages(housingService.calculateGrossWages(calculator));
        calculator.setNetMonthlyWages(housingService.calculateNetWages(calculator));

        return "calculator-confirmation";
    }

    public List<Housing> neighborhoodInfo(){
        return housingService.findAll();
    }

    @ModelAttribute("neighborhoods")
    public List<String> neighborhoods(){
        List<String> neighborhoods = housingService.neighborhoodsList();
        return neighborhoods;
    }



}
