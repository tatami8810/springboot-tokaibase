package com.example.tokaibase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tokaibase.entity.Camp;

public interface CampRepository extends JpaRepository<Camp, Integer> {

    @Query("""
        SELECT c FROM Camp c
        WHERE (:prefecture IS NULL OR c.prefecture = :prefecture)
        AND (:keyword IS NULL OR c.cityAddress LIKE %:keyword%)
        """)
    List<Camp> search(String prefecture, String keyword);
}
