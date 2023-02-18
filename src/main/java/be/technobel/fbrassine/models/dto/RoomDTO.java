package be.technobel.fbrassine.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDTO {
    private long id;
    private String name;
    private int numberPlaces;
    private boolean teacherRoom;
}
