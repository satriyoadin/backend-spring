package com.exampleSatriyo.demoCRUD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Alamat(){}

    public long getAlamatId() {
        return alamatId;
    }

    public void setAlamatId(long alamatId) {
        this.alamatId = alamatId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getStreet(){
        return street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

}
