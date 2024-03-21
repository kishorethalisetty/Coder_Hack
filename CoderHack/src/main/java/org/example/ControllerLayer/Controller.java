package org.example.ControllerLayer;

import org.example.Entites.UserEntity;
import org.example.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserEntity> registerUser(@RequestParam(name = "name") String name){
        UserEntity user =userService.addUser(name);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/userById")
    public ResponseEntity<UserEntity> userById(@RequestParam(name = "userId") String id){
        UserEntity UserEntity =userService.getUserById(id);
        return ResponseEntity.ok(UserEntity);
    }

    @PutMapping("/users")
    public ResponseEntity<UserEntity> updateScore(@RequestParam(name = "id") String id,
                                         @RequestParam(name = "score") int score){
       UserEntity user= userService.updateScore(id, score);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users")
    public ResponseEntity<?>  deleteUserById(@RequestParam(name = "id") String id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
       List<UserEntity> userList = userService.getAllUsers();
       return ResponseEntity.ok(userList);
    }

}
