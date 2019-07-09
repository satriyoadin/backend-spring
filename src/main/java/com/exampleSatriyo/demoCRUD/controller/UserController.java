package com.exampleSatriyo.demoCRUD.controller;

import javax.validation.Valid;
import java.util.List;


import com.exampleSatriyo.demoCRUD.model.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.exampleSatriyo.demoCRUD.entity.User;
import com.exampleSatriyo.demoCRUD.repository.UserRepository;


@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("addUser")
    public GeneralResponse addUser(@RequestBody User user){
        try {
            userRepository.save(user);
        }catch(Exception ex){
            return new GeneralResponse(300,user,ex.getLocalizedMessage());
        }

        return new GeneralResponse(200,user,"success");

    }

    @GetMapping("getUserData/{id}")
    public GeneralResponse getUserDataById(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User ID" + id));
        //model.addAttribute("user", userRepository.findById(id));

        GeneralResponse resp = new GeneralResponse();
        resp.setCode(200);
        resp.setData(user);
        resp.setMessage("success");
        return resp;
    }

    @PostMapping("updateUser/{id}")
    public GeneralResponse updateUser(@RequestBody User user){
        try {
            userRepository.save(user);
        }catch (Exception ex){
            return new GeneralResponse(300,user,ex.getLocalizedMessage());
        }

        return new GeneralResponse(200,user,"success");
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User ID:" + id));
        User user1 = userRepository.findByEmail("email@email.com").orElseThrow(() -> new IllegalArgumentException("not found!"));
       User user2 = userRepository.findByPhoneNo("079788898");
        try
        {userRepository.delete(user);}
        catch (Exception ex){
            return ex.getLocalizedMessage();
        }
        return "success delete user";

    }
}
