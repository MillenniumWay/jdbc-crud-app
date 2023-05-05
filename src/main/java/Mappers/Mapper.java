package Mappers;

import Models.User;

public interface Mapper <F,T> {
 User mapFrom(F object);
}
