package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.entities.UserInfo;
import cs.ph.powerhousing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestRegisterController {

    @Autowired
    private final UserService userService;

    public RestRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserInfo register(@RequestBody UserInfo userInfo){
        return userService.register(userInfo);
    }
}
