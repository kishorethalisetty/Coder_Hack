package org.example.ServiceLayer;

import org.example.Entites.UserEntity;
import org.example.Exceptions.InvalidScore;
import org.example.Exceptions.UserNotFoundException;
import org.example.RepositoryLayer.RepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private RepositoryImp repositoryImp;
    @Override
    public UserEntity addUser(String name){
        UserEntity user =new UserEntity(name);
        repositoryImp.insert(user);
        return user;
    }

    @Override
    public UserEntity getUserById(String id){
       Optional<UserEntity> userOp= repositoryImp.findById(id);
        UserEntity user =userOp.get();
        if(user ==null){
            throw new UserNotFoundException("UserEntity Not Found Exception");
        }
        return user;
    }

    public UserEntity updateScore(String id, int score){
        UserEntity userEntity =getUserById(id);

        userEntity.setScore(score);

        if(score<0 || score>100) throw new InvalidScore("Invalid Score Exception");

        userEntity.getBadges().clear();

        if(score>=1){
            userEntity.getBadges().add("Code Ninja");
        }

        if(score>30 ){
            userEntity.getBadges().add("Code Champ");
        }
        if(score>60 ){
            userEntity.getBadges().add("Code Master");
        }
        repositoryImp.save(userEntity);
        return  userEntity;
    }
    @Override
    public void deleteUser(String id){
        repositoryImp.deleteAllById(new HashSet<String>(Collections.singleton(id)));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userList =repositoryImp.findAll();
        Collections.sort(userList,(a, b)->b.getScore()-a.getScore());
        return userList;
    }
}
