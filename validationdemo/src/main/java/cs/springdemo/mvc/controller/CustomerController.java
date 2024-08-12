package cs.springdemo.mvc.controller;

import cs.springdemo.mvc.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //trim input strings
    //we are telling the string trimmer that empty string becomes null
    //then we're registering this editor as a custom editor to be applied to all instances of the String class
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){

        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    //performs validation based on the rules we defined earlier in the Customer class
    //BindingResult holds the results of the validation
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){

        System.out.println("Binding result: " + theBindingResult);
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }

}
