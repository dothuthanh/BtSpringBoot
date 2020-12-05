package com.example.demo.springboot.repository;

import com.example.demo.springboot.model.LapTop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILapTopRepository extends JpaRepository<LapTop, Long> {
}
