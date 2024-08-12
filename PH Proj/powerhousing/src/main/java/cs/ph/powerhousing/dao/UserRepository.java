package cs.ph.powerhousing.dao;

import cs.ph.powerhousing.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {

   UserInfo findByUsername(String username);


}
