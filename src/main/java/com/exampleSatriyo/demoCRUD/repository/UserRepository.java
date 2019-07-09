package com.exampleSatriyo.demoCRUD.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exampleSatriyo.demoCRUD.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    List<User> findAll();
//    List<User> findById(long Id);
    Optional<User> findByEmail(String email);
    User findByPhoneNo(String phone);
}
