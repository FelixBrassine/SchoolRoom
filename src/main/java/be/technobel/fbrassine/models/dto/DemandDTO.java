package be.technobel.fbrassine.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DemandDTO {
    private long id;
    private LocalDateTime timeSolts;
    private int term;
}
