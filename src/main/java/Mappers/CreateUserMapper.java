package Mappers;

import DTO_LAYERS.CreateUserDto;
import Models.User;
import Models.UserBean;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, UserBean>{
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .login(object.getLogin())
                .email(object.getEmail())
                .password(object.getPassword())
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

}
