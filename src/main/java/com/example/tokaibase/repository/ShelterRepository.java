package com.example.tokaibase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tokaibase.entity.Shelter;

public interface ShelterRepository extends JpaRepository<Shelter, Integer> {

    @Query("""
        SELECT s FROM Shelter s
        WHERE (:prefecture IS NULL OR s.prefecture = :prefecture)
        AND (:keyword IS NULL OR s.cityAddress LIKE %:keyword%)
        """)
    List<Shelter> search(String prefecture, String keyword);
}
