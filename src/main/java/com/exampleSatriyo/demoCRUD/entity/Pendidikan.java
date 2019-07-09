package com.exampleSatriyo.demoCRUD.entity;

import javax.persistence.*;


@Entity
@Table(name = "pendidikan")
public class Pendidikan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pendidikanId;

    @Column(name = "pendidikan_name")
    private String pendidikanName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id", nullable=false)
    private User user;


    public Pendidikan(){};

    public Pendidikan(Long pendidikanId, String pendidikanName){
        this.pendidikanId = pendidikanId;
        this.pendidikanName = pendidikanName;
    }

    public void setPendidikanId(long pendidikanId){
        this.pendidikanId = pendidikanId;
    }

    public long getPendidikanId(){
        return pendidikanId;
    }

    public void setPendidikanName(String name){
        this.pendidikanName = pendidikanName;
    }

    public String getPendidikanName(){
        return pendidikanName;
    }


}
