package be.technobel.fbrassine.models.form;

import be.technobel.fbrassine.validation.constraints.InFuture;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DemandForm {
    @InFuture(amount = 3)
    private LocalDateTime timeSolts;
    @Positive
    private int term;
}
