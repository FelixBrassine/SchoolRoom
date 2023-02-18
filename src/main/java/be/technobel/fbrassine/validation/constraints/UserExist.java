package be.technobel.fbrassine.validation.constraints;

import be.technobel.fbrassine.validation.validators.UserExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserExistValidator.class)
public @interface UserExist {

    String message() default "user not exist or values are wrong";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
