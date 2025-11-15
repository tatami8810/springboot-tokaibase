package com.example.tokaibase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "shelter")
@Data
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shelter_name")
    private String shelterName;

    @Column(name = "image_name")
    private String imageName;

    private String prefecture;

    @Column(name = "city_address")
    private String cityAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "capacity_short")
    private Integer capacityShort;

    @Column(name = "capacity_long")
    private Integer capacityLong;

    private Integer space;

    private Boolean quake;
    private Boolean damage;

    @Column(name = "safety_precautions")
    private String safetyPrecautions;
}
