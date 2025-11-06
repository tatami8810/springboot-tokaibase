package com.example.tokaibase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tokaibase.entity.VerificationToken;


public interface VerificationTokenRepository extends JpaRepository< VerificationToken, Integer> {
    public VerificationToken findByToken(String token);
}