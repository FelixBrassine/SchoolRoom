package be.technobel.fbrassine.validation.validators;

import be.technobel.fbrassine.models.form.RegisterForm;
import be.technobel.fbrassine.validation.constraints.PasswordConfirmed;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConfirmedValidator implements ConstraintValidator<PasswordConfirmed, RegisterForm> {
    @Override
    public boolean isValid(RegisterForm value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirm());
    }
}
