package cs.ph.powerhousing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;


@Getter
@Setter
@Entity
@Table(name="user_credentials")
public class UserInfo {


    @Id
    @Column(name="username")
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9_.]{8,20}$")
    private String username;


    @Column(name="user_password")
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String userPassword;

    @Column(name="email")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;


    public @NotNull(message = "is required") @Size(min = 1, message = "is required") @Pattern(regexp = "^[a-zA-Z0-9_.]{8,20}$") String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(message = "is required") @Size(min = 1, message = "is required") @Pattern(regexp = "^[a-zA-Z0-9_.]{8,20}$") String username) {
        this.username = username;
    }

    public @NotNull(message = "is required") @Size(min = 1, message = "is required") String getPassword() {
        return userPassword;
    }

    public void setPassword(@NotNull(message = "is required") @Size(min = 1, message = "is required") String userPassword) {
        this.userPassword = userPassword;
    }

    public @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") String getEmail() {
        return email;
    }

    public void setEmail(@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
