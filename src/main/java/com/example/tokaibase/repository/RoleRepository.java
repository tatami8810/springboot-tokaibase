package com.example.tokaibase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tokaibase.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}