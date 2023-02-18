package com.validation.service;

import com.validation.dao.UserRepo;
import com.validation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void add(User user) {
        User user1 = userRepo.save(user);
        return;
    }

    public User getbyId(Integer id) {
        return userRepo.findById(id).get();
    }

    public List<User> getall() {
        return userRepo.findAll();
    }

    public void update(Integer id,User newuser) {
        User user = userRepo.findById(id).get();
        user.setUserId(newuser.getUserId());
        user.setUsername(newuser.getUsername());
        user.setDate(newuser.getDate());
        user.setEmail(newuser.getEmail());
        user.setPhone_Num(newuser.getPhone_Num());
        user.setTime(newuser.getTime());
        user.setDateOfBirth(newuser.getDateOfBirth());
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }
}
