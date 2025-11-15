package com.example.tokaibase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "camp")
@Data
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "camp_name")
    private String campName;

    private Integer score;

    @Column(name = "image_name")
    private String imageName;

    private String introduction;
    private String prefecture;

    @Column(name = "city_address")
    private String cityAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "regular_holiday")
    private String regularHoliday;

    private String parking;

    @Column(name = "parking_fee")
    private String parkingFee;

    @Column(name = "drive_in")
    private String driveIn;

    @Column(name = "check_in_time")
    private String checkInTime;

    @Column(name = "check_out_time")
    private String checkOutTime;
}
