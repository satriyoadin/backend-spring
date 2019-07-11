package com.exampleSatriyo.demoCRUD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "pendidikan")
public class Pendidikan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@JsonProperty("pendidikan_name")
    @Column(name = "pendidikan_name")
    private String pendidikanName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_Id", nullable=false)
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPendidikanName(String pendidikanName) {
        this.pendidikanName = pendidikanName;
    }

    public String getPendidikanName(){
        return pendidikanName;
    }


}
