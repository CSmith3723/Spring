package cs.ph.powerhousing.dao;

import cs.ph.powerhousing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResository extends JpaRepository<User, String> {

}
