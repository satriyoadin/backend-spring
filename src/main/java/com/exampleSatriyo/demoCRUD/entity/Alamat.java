package com.exampleSatriyo.demoCRUD.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alamat")
public class Alamat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long alamatId;


    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

}
