package be.technobel.fbrassine.models.form;

import be.technobel.fbrassine.models.entity.Role;
import be.technobel.fbrassine.validation.constraints.EmailNotTaken;
import be.technobel.fbrassine.validation.constraints.PasswordConfirmed;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@PasswordConfirmed
public class RegisterForm {
    @NotBlank(message = "Enter an email")
    @Email
    @EmailNotTaken
    private String email;
    @NotBlank(message = "Enter a password")
    @Pattern(regexp = "^^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{4,}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;
    @NotBlank(message = "Enter a confirm password")
    private String confirm;
    @NotBlank(message = "Enter a login")
    private String login;
    @NotBlank(message = "Enter a name")
    private String name;
    @NotBlank(message = "Enter a firstname")
    private String firstName;
    @NotNull
    @Pattern(regexp = "^0\\d{8,9}$", message="Not valid phone number")
    private String phoneNumber;
    @NotBlank(message = "Enter an adress")
    private String adress;
    @NotNull(message = "Select a role")
    private Role role;

}
