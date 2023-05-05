package DTO_LAYERS;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    private int id;
    private String login;
    private String password;
    private String email;

}
