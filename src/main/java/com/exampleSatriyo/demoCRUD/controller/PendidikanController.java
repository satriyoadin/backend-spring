package com.exampleSatriyo.demoCRUD.controller;

import java.util.List;

import com.exampleSatriyo.demoCRUD.entity.Pendidikan;
import com.exampleSatriyo.demoCRUD.model.GeneralResponse;
import com.exampleSatriyo.demoCRUD.repository.PendidikanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exampleSatriyo.demoCRUD.entity.User;
import com.exampleSatriyo.demoCRUD.repository.UserRepository;

    @RestController
    @RequestMapping("/pendidikan/")
    public class PendidikanController {

        @Autowired
        private final UserRepository userRepository;
        private final PendidikanRepository pendidikanRepository;

        @Autowired
        public PendidikanController(UserRepository userRepository, PendidikanRepository pendidikanRepository){
            this.userRepository = userRepository;
            this.pendidikanRepository = pendidikanRepository;
        }

        @GetMapping("getAllUser")
        public List<Pendidikan> getAllPendidikan(){
            return pendidikanRepository.findAll();
        }

        @PostMapping("addPendidikan")
        public GeneralResponse addPendidikan(@RequestBody Pendidikan pendidikan){
            try {
                pendidikanRepository.save(pendidikan);
            }catch(Exception ex){
                return new GeneralResponse(300,pendidikan,ex.getLocalizedMessage());
            }

            return new GeneralResponse(200,pendidikan,"success");

        }

        @GetMapping("getPendidikanData/{id}")
        public GeneralResponse getPendidikanDataById(@PathVariable("id") long id, Model model){
            Pendidikan pendidikan = pendidikanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User ID" + id));
            //model.addAttribute("user", userRepository.findById(id));

            GeneralResponse resp = new GeneralResponse();
            resp.setCode(200);
            resp.setData(pendidikan);
            resp.setMessage("success");
            return resp;
        }

        @PostMapping("updateUser/{id}")
        public GeneralResponse updatePendidikan(@RequestBody Pendidikan pendidikan){
            try {
                pendidikanRepository.save(pendidikan);
            }catch (Exception ex){
                return new GeneralResponse(300,pendidikan,ex.getLocalizedMessage());
            }

            return new GeneralResponse(200,pendidikan,"success");
        }

        @GetMapping("deletePendidikan/{id}")
        public String deletePendidikan(@PathVariable("id") long id, Model model){
            Pendidikan pendidikan = pendidikanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Pendidikan ID:" + id));

            try {
                pendidikanRepository.delete(pendidikan);
            }
            catch (Exception ex){
                return ex.getLocalizedMessage();
            }
            return "success delete pendidikan";

        }
    }

