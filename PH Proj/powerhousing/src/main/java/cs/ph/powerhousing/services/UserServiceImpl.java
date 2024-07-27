package cs.ph.powerhousing.services;


import cs.ph.powerhousing.dao.UserResository;
import cs.ph.powerhousing.entities.UserInfo;
import cs.ph.powerhousing.user.WebUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class UserServiceImpl implements UserService {

    private UserResository userResository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserResository userResository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userResository = userResository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<String> findAllUsernames() {
        List<UserInfo> usernameList = userResository.findAll();

        return usernameList.stream().map(UserInfo::getUsername)
                .collect(Collectors.toList());
    }

    @Override
    public void save(WebUser webUser) {
        UserInfo userInfo = new UserInfo();

        userInfo.setUsername(webUser.getUsername());

    }

    @Override
    public UserInfo findByUsername(String username) {

        return userResository.findByUsername(username);

    }


    @Override
    public UserInfo getUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userResository.findByUsername(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid username or password.");c
        }

        return new UserInfo(userInfo.getUsername(),userInfo.getUserPassword());
    }


}
