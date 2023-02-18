package be.technobel.fbrassine.validation.validators;

import be.technobel.fbrassine.validation.constraints.InFuture;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class InFutureValidator implements ConstraintValidator<InFuture, Temporal> {

    private InFuture annotation;

    @Override
    public void initialize(InFuture constraintAnnotation) {
        annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Temporal value, ConstraintValidatorContext context) {

        if(value == null)
            return true;

        context.disableDefaultConstraintViolation();

        if(
                (value instanceof LocalDateTime && !checkLocalDateTime((LocalDateTime)value) )
        ){
            context.buildConstraintViolationWithTemplate("Should be "+annotation.amount()+" days in the future" )
                    .addConstraintViolation();
            return false;
        }
        else if( !(value instanceof LocalDate) && !(value instanceof LocalDateTime)  ) {
            throw  new IllegalArgumentException();
        }
        else
            return true;
    }

    private boolean checkLocalDateTime(LocalDateTime localDateTime){
        return LocalDateTime.now()
                .plus( annotation.amount(), ChronoUnit.DAYS )
                .isBefore( localDateTime );
    }
}
