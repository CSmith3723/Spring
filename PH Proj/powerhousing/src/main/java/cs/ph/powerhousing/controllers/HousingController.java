package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.entities.Housing;
import cs.ph.powerhousing.services.HousingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HousingController {

    HousingService housingService;

    public HousingController(HousingService housingService) {
        this.housingService = housingService;
    }

    @GetMapping("/neighborhoodInfo")
    public List<Housing> neighborhoodInfo(){
        return housingService.findAll();
    }

}
