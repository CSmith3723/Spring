package cs.ph.powerhousing.RestControllers;

import cs.ph.powerhousing.services.MapService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maps")
public class MapAPIController {

    private final MapService mapService;

    public MapAPIController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/search")
    public String searchCity(@RequestParam String cityName) {
        return mapService.searchByCity(cityName);
    }



}
