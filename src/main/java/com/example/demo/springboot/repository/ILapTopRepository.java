package com.example.demo.springboot.repository;

import com.example.demo.springboot.model.LapTop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILapTopRepository extends JpaRepository<LapTop, Long> {
}
