package com.example.tokaibase.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tokaibase.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
