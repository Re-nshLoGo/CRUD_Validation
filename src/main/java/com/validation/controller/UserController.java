package com.validation.controller;

import com.validation.model.User;
import com.validation.service.UserService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/ums")
@Validated
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@Valid @RequestBody String user){
        JSONObject json = new JSONObject(user);
        User user1 = setUser(json);
        userService.add(user1);
        return new ResponseEntity<>("user saved", HttpStatus.CREATED);
    }

    private User setUser(JSONObject json) {
        User newuser = new User();
        Integer id = json.getInt("UserId");
        newuser.setUserId(id);
        String name = json.getString("username");
        newuser.setUsername(name);
        String dob = json.getString("DateOfBirth");
        newuser.setDateOfBirth(dob);
        String mail = json.getString("email");
        newuser.setEmail(mail);
        String phon = json.getString("Phone_Num");
        newuser.setPhone_Num(phon);
        String dt = json.getString("Date");
        newuser.setDate(dt);
        String time = json.getString("Time");
        newuser.setTime(time);
        return newuser;
    }

    @GetMapping("getuser-by-id/{userid}")
    public User getUser(@PathVariable Integer id){
        return userService.getbyId(id);
    }
    @GetMapping("get-all")
    public List<User> getAll(){
        return userService.getall();
    }
    @PutMapping("/update-user/{id}")
    public void updateUser(@PathVariable Integer id ,@RequestBody User user){
        userService.update(id,user);
    }
    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
