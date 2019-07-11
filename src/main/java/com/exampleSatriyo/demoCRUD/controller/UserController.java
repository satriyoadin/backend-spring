package com.exampleSatriyo.demoCRUD.controller;

import java.util.List;

import com.exampleSatriyo.demoCRUD.entity.Alamat;
import com.exampleSatriyo.demoCRUD.entity.Pendidikan;
import com.exampleSatriyo.demoCRUD.model.GeneralResponse;
import com.exampleSatriyo.demoCRUD.repository.AlamatRepository;
import com.exampleSatriyo.demoCRUD.repository.PendidikanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exampleSatriyo.demoCRUD.entity.User;
import com.exampleSatriyo.demoCRUD.repository.UserRepository;

import javax.transaction.Transactional;


@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PendidikanRepository pendidikanRepository;

    @Autowired
    private AlamatRepository alamatRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    @Transactional
    @PostMapping("addUser")
    public GeneralResponse addUser(@RequestBody User user){
        User user1 = new User();
        user1.setPhoneNo(user.getPhoneNo());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        userRepository.save(user1);

        Alamat alamat = new Alamat();
        alamat.setCity(user.getAlamat().getCity());
        alamat.setUser(user1);
        alamat.setStreet(user.getAlamat().getStreet());
        alamatRepository.save(alamat);


        for (Pendidikan p: user.getPendidikan()) {
            Pendidikan pendidikan = new Pendidikan();
            pendidikan.setUser(user1);
            pendidikan.setPendidikanName(p.getPendidikanName());
            pendidikanRepository.save(pendidikan);
        }

        return new GeneralResponse(200,user1,"success");

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

    @PostMapping ("updateUser/{id}")
    public GeneralResponse updateUser(@PathVariable(value = "id")@RequestBody User user){

            user.setName(user.getName());
            user.setEmail(user.getEmail());
            user.setPhoneNo(user.getPhoneNo());
            userRepository.save(user);

        return new GeneralResponse(200,user,"success");
    }

    @PostMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User ID:" + id));
        try
        {
            userRepository.delete(user);
        }
        catch (Exception ex){
            return ex.getLocalizedMessage();
        }
        return "success delete user";

    }

}
