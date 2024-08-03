package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.services.MapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/search")
    public String searchCity(
            @RequestParam String cityName) {
        return mapService.searchByCity(cityName);
    }

}
