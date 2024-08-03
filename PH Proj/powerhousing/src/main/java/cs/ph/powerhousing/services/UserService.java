package cs.ph.powerhousing.services;


import cs.ph.powerhousing.dao.UserRepository;
import cs.ph.powerhousing.entities.UserInfo;
import cs.ph.powerhousing.user.WebUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }


    public List<String> findAllUsernames() {
        List<UserInfo> usernameList = userRepository.findAll();

        return usernameList.stream().map(UserInfo::getUsername)
                .collect(Collectors.toList());
    }

    public UserInfo register(UserInfo userInfo){
        return userRepository.save(userInfo);
    }

    public void save(WebUser webUser) {
        System.out.println("Saving user to database.");
        UserInfo userInfo = new UserInfo();

        userInfo.setUsername(webUser.getUsername());
        userInfo.setUserPassword(passwordEncoder.encode(webUser.getPassword()));
        userRepository.save(userInfo);
    }


    public UserInfo findByUsername(String username) {
        return userRepository.findByUsername(username);

    }


}
