package Service;

import java.util.Optional;

public class UserService {
//    private static final UserService INSTANCE = new UserService();
//
//    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
//    private final UserDao userDao = UserDao.getInstance();
//    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
//    private final UserMapper userMapper = UserMapper.getInstance();
//
//    public Optional<UserDto> login(String email, String password) {
//        return userDao.findByEmailAndPassword(email, password)
//                .map(userMapper::mapFrom);
//    }
//
//    public Integer create(CreateUserDto userDto) {
//        var validationResult = createUserValidator.isValid(userDto);
//        if (!validationResult.isValid()) {
//            throw new ValidationException(validationResult.getErrors());
//        }
//        var userEntity = createUserMapper.mapFrom(userDto);
//        userDao.save(userEntity);
//        return userEntity.getId();
//    }
//
//    public static UserService getInstance() {
//        return INSTANCE;
//    }
}
