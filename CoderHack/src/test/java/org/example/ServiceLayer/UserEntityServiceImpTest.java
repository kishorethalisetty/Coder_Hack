package org.example.ServiceLayer;

import org.example.Entites.UserEntity;
import org.example.RepositoryLayer.RepositoryImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;

public class UserEntityServiceImpTest {

    @InjectMocks
    private UserServiceImp userService;

    @Mock
    private RepositoryImp repositoryImp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addUser() {
        UserEntity ans= userService.addUser("kishore");
//        System.out.println(ans.getName());
        Assert.assertNotNull(ans);
    }

    @Test
    public void getUserById() {
        UserEntity user=new UserEntity("Kishore");
        user.setId("123");
        when(repositoryImp.findById("123")).thenReturn(Optional.of(user));
        UserEntity ans=userService.getUserById("123");
        Assert.assertEquals(ans, user);
    }

    @Test
    public void updateScore() {
        UserEntity user=new UserEntity("Sandi");
        user.setId("123");
        when(repositoryImp.findById("123")).thenReturn(Optional.of(user));

        UserEntity ans=userService.updateScore("123",100);
//        Code Ninja, Code Champ, Code Master
        Assert.assertEquals("Code Ninja",ans.getBadges().get(0));
        Assert.assertEquals("Code Champ",ans.getBadges().get(1));
        Assert.assertEquals("Code Master",ans.getBadges().get(2));
    }

//    @Test
//    public void deleteUser() {
//    }

    @Test
    public void getAllUsers() {
        UserEntity u1=new UserEntity("kishore");
        UserEntity u2=new UserEntity("sai");
        UserEntity u3=new UserEntity("suresh");
        u1.setId("1");
        u2.setId("2");
        u3.setId("3");

        u1.setScore(100);
        u2.setScore(50);
        u3.setScore(80);
        List<UserEntity> userList =new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        when(repositoryImp.findAll()).thenReturn(userList);

        List<UserEntity> ans=userService.getAllUsers();

        Assert.assertEquals(userList.size(),ans.size());
        Assert.assertEquals(100,ans.get(0).getScore());
        Assert.assertEquals(80,ans.get(1).getScore());
        Assert.assertEquals(50,ans.get(2).getScore());


    }
}