package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.mapper;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.UserEntity;

public class UserMapper {
    private static final UserMapper instance = new UserMapper();

    public static UserMapper getInstance() {
        return instance;
    }

    public User toDto(UserEntity entity) {
        return new User(entity.getUsername(), entity.getPassword(), entity.getFio(), entity.getBirthday());
    }

    public UserEntity toEntity(User dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(dto.getBirthday());
        userEntity.setFio(dto.getFio());
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        return userEntity;
    }
}
