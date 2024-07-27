package cs.ph.powerhousing.dao;

import cs.ph.powerhousing.entities.UserInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResository extends JpaRepository<UserInfo, String> {

   UserInfo findByUsername(@NotNull(message = "is required") @Size(min = 1, message = "is required") @Pattern(regexp = "^[a-zA-Z0-9]") String username);
}
