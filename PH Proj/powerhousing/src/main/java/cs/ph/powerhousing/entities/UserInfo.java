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
@Table(name="users")
public class UserInfo {


    @Id
    @Column(name="username")
    private String username;


    @Column(name="password")
    private String userPassword;

    public UserInfo(){}

    public UserInfo(String username, String userPassword) {
        this.username = username;
        this.userPassword = userPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
