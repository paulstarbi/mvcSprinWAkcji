package spitter.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

@Component
public class Spitter {

    private long id;

    @NotBlank
    @Size(min =5, max = 25)
    private String firstName;

    @NotBlank
    @Size(min =5, max = 25)
    private String lastName;

    @NotBlank
    @Size(min =5, max = 25)
    private String userName;

    @NotBlank
    @Size(min =5, max = 25)
    private String password;
    private String email;

    public Spitter() {
    }

    public Spitter(String firstName, String lastName, String userName, String password) {
        this.id = new Random().nextLong();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
