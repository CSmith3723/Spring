package cs.ph.powerhousing.RestControllers;

import cs.ph.powerhousing.entities.SavedProfile;
import cs.ph.powerhousing.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfilesRestController {

    private ProfileService profileService;

    public ProfilesRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public List<SavedProfile> allProfiles(){
        return profileService.findAllProfiles();
    }

    @PostMapping("/saveProfile")
    public SavedProfile savedProfile(@RequestBody SavedProfile savedProfile){
         profileService.saveProfile(savedProfile);
         return savedProfile;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable Long id){
        profileService.deleteSavedProfileById(id);
    }

}
