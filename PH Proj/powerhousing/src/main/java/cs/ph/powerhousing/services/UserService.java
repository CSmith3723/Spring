package cs.ph.powerhousing.services;

import cs.ph.powerhousing.user.WebUser;
import cs.ph.powerhousing.entities.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService{

    List<String> findAllUsernames();

    void save(WebUser webUser);

    UserInfo findByUsername(String username);

    UserInfo getUserByUsername(String username) throws UsernameNotFoundException;
}
