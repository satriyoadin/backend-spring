package com.exampleSatriyo.demoCRUD.repository;

import com.exampleSatriyo.demoCRUD.entity.Pendidikan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface PendidikanRepository extends CrudRepository<Pendidikan, Long> {
    List<Pendidikan> findAll();

}
