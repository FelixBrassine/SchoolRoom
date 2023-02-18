package be.technobel.fbrassine.models.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RoomForm {
    @NotBlank(message = "Enter a name")
    @NotNull(message = "Enter a name")
    private String name;

    @Positive (message = "Enter a value greater than 0")
    private int numberPlaces;
    private boolean teacherRoom;
}
