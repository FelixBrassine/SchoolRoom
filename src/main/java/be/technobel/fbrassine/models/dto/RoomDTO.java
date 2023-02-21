package be.technobel.fbrassine.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomDTO {
    private long id;
    private String name;
    private int numberPlaces;
    private List<MaterialDTO> materialDTO;
    private boolean teacherRoom;
}
