package be.technobel.fbrassine.validation.validators;

import be.technobel.fbrassine.models.form.ConnectForm;
import be.technobel.fbrassine.service.UserService;
import be.technobel.fbrassine.validation.constraints.UserExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UserExistValidator implements ConstraintValidator<UserExist, ConnectForm> {
    private final UserService userService;

    public UserExistValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(ConnectForm value, ConstraintValidatorContext context) {
        return userService.userExist(value.getPassword(), value.getEmail());
    }
}
