package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usernames")
    public List<String> usernames(){
        return userService.findAllUsernames();
    }
}
