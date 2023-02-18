package be.technobel.fbrassine.validation.constraints;

import be.technobel.fbrassine.validation.validators.InFutureValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InFutureValidator.class)
public @interface InFuture {

    long amount() default 0;

    String message() default "should be 3 days in the future";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
