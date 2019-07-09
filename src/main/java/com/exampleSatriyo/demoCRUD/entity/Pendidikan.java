package com.exampleSatriyo.demoCRUD.entity;

import javax.persistence.*;


@Entity
public class Pendidikan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pendidikanId;

    @Column(name = "pendidikan_name")
    private String pendidikanName;

    @OneToMany(mappedBy = "pendidikan", cascade = CascadeType.ALL)
    private Set<>


}
