package be.technobel.fbrassine.models.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MaterialForm {
    @NotBlank(message = "Enter a name")
    private String name;
}
