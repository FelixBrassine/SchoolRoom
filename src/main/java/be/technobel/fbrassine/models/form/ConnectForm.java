package be.technobel.fbrassine.models.form;

import be.technobel.fbrassine.validation.constraints.UserExist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@UserExist
public class ConnectForm {
    @NotBlank(message = "Enter an login")
    private String userLogin;
    @NotBlank(message = "Enter a password")
    @Pattern(regexp = "^^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{4,}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;
}
