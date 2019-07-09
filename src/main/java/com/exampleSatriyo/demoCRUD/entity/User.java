package com.exampleSatriyo.demoCRUD.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotBlank(message = "Name is Mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;

    @ManyToOne
    @JoinColumn
    private Pendidikan pendidikan;

    public User(){}

    public User(String name, Long phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public void setId(long Id){
        this.Id = Id;
    }

    public long getId(){
        return Id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPhoneNo(long phoneNo){
        this.phoneNo = phoneNo;
    }

    public long getPhoneNo(){
        return phoneNo;
    }

}
