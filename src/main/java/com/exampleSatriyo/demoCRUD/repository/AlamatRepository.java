package com.exampleSatriyo.demoCRUD.repository;

import com.exampleSatriyo.demoCRUD.entity.Alamat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlamatRepository extends CrudRepository<Alamat, Long> {

    List<Alamat> findAll();
    Optional<Alamat> findByCity(String city);
}
