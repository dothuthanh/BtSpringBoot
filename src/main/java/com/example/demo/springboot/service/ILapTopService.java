package com.example.demo.springboot.service;

import java.util.Optional;

public interface ILapTopService<T> {
    Iterable<T> findAll();
    Optional findById(Long id);
    T save (T t);
    void remove(Long id);
}
