package be.technobel.fbrassine.models.dto;

import be.technobel.fbrassine.models.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String Login;
    private String name;
    private String firstName;
    private String phoneNumber;
    private String adress;
    private Role role;
}
