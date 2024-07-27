package cs.ph.powerhousing.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WebUser {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String username;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    public @NotNull(message = "is required") @Size(min = 1, message = "is required") String getUsername() {
        return username;
    }

    public void setUserName(@NotNull(message = "is required") @Size(min = 1, message = "is required") String username) {
        this.username = username;
    }

    public @NotNull(message = "is required") @Size(min = 1, message = "is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "is required") @Size(min = 1, message = "is required") String password) {
        this.password = password;
    }
}
