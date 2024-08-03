package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.entities.Housing;
import cs.ph.powerhousing.services.HousingService;
import cs.ph.powerhousing.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EndpointController {

    HousingService housingService;
    UserService userService;

    public EndpointController(HousingService housingService, UserService userService) {
        this.housingService = housingService;
        this.userService = userService;
    }


    // --- NEIGHBORHOOD INFO --- //

    @GetMapping("/neighborhoodInfo")
    public List<Housing> neighborhoodInfo(){
        return housingService.findAll();
    }


    // --- USER INFO --- //

    @GetMapping("/usernames")
    public List<String> usernames(){
        return userService.findAllUsernames();
    }
}
