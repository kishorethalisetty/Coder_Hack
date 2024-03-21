package org.example.ServiceLayer;

import org.example.Entites.UserEntity;

import java.util.List;


public interface UserService {
    UserEntity addUser(String name);
    UserEntity getUserById(String id);

    UserEntity updateScore(String id, int score);

    void deleteUser(String id);

    List<UserEntity> getAllUsers();
}
