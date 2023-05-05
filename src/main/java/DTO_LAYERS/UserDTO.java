package DTO_LAYERS;

import Entity.Gender;
import Entity.Role;
import lombok.Builder;
import lombok.Value;
import java.time.LocalDate;

@Value
@Builder
public class UserDTO {
    private int id;
    private String login;
    private String password;
    private String email;

}
