package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.entities.Calculator;
import cs.ph.powerhousing.entities.Housing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CalculatorController {

    @GetMapping("/showCalculator")
    public String showCalculator( Model theModel){

        Calculator theCalculator = new Calculator();
        Housing theHousing = new Housing();
        theModel.addAttribute("calculator", theCalculator);
        theModel.addAttribute("housing", theHousing);
        return "calculator-form";
    }

    @PostMapping("/processCalculation")
    public String processForm(@ModelAttribute("student") Calculator theCalculator){

        return "calculator-confirmation";
    }

}
