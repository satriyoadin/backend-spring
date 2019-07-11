package com.exampleSatriyo.demoCRUD.controller;

import com.exampleSatriyo.demoCRUD.entity.Alamat;
import com.exampleSatriyo.demoCRUD.model.GeneralResponse;
import com.exampleSatriyo.demoCRUD.repository.AlamatRepository;
import com.exampleSatriyo.demoCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alamat/")
public class AlamatController {

    @Autowired
    private final UserRepository userRepository;
    private final AlamatRepository alamatRepository;

    @Autowired
    public AlamatController(UserRepository userRepository, AlamatRepository alamatRepository){
        this.userRepository = userRepository;
        this.alamatRepository = alamatRepository;
    }

    @GetMapping("getAllAlamat")
    public List<Alamat> getAllAlamat(){
        return alamatRepository.findAll();
    }

    @PostMapping("addAlamat")
    public GeneralResponse addAlamat(@RequestBody Alamat alamat){
        try {
            alamatRepository.save(alamat);
        }catch(Exception ex){
            return new GeneralResponse(300,alamat,ex.getLocalizedMessage());
        }

        return new GeneralResponse(200,alamat,"success");

    }

    @GetMapping("getAlamatByCity/{city}")
    public GeneralResponse getAlamatByCity(@PathVariable("city") String city, Model model){
        Alamat alamat = alamatRepository.findByCity(city).orElseThrow(() -> new IllegalArgumentException("Invalid City" + city));
        //model.addAttribute("user", userRepository.findById(id));

        GeneralResponse resp = new GeneralResponse();
        resp.setCode(200);
        resp.setData(alamat);
        resp.setMessage("success");
        return resp;
    }

    @PostMapping("updateAlamat/{id}")
    public GeneralResponse updateAlamat(@RequestBody Alamat alamat){
        try {
            alamatRepository.save(alamat);
        }catch (Exception ex){
            return new GeneralResponse(300,alamat,ex.getLocalizedMessage());
        }

        return new GeneralResponse(200,alamat,"success");
    }

    @GetMapping("deleteAlamat/{id}")
    public String deleteAlamat(@PathVariable("id") long id, Model model){
        Alamat alamat = alamatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Alamat ID:" + id));

        try {
            alamatRepository.delete(alamat);
        }
        catch (Exception ex){
            return ex.getLocalizedMessage();
        }
        return "success delete alamat";

    }
}
