package DAO;

import Entity.UserEntity;

import java.util.List;

public interface UserDAO {

    void createUser(UserEntity user);
    void updateUser(UserEntity user);
    List<UserEntity> getUsers();
    UserEntity getUserByID(String userID);
    UserEntity getUserByUniqueEmailCode(String uniqueEmailCode);
}
