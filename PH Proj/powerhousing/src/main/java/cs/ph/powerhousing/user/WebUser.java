package cs.ph.powerhousing.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebUser {
    @NotNull(message = "Username is required")
    @Size(min = 5, message = "Username must be at least 5 characters long")
    private String username;


    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;


    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String confirmPassword;
}