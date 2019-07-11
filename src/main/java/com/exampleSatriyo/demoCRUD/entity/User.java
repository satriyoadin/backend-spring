package com.exampleSatriyo.demoCRUD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @NotBlank(message = "Name is Mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;

    //    @JsonIgnore
    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private List<Pendidikan> pendidikan;
    //private String pendidikanName;
    public List<Pendidikan> getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(List<Pendidikan> pendidikan) {
        this.pendidikan = pendidikan;
    }

    @OneToOne(mappedBy="user", fetch = FetchType.EAGER)
    private Alamat alamat;
    //private String street;
    //private String city;

    public Alamat getAlamat() {
        return alamat;
    }

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }
    /*
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    */

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
