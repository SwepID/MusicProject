package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Id
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;
}
