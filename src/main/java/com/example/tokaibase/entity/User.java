package com.example.tokaibase.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data


public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "furigana")
    private String furigana;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "postal_code")
    private String postal_code;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone_number")
    private String phonenumber;
    
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    
    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;   
    
}


