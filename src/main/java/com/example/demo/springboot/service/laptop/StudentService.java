package com.example.demo.springboot.service.laptop;

import com.example.demo.springboot.model.LapTop;
import com.example.demo.springboot.repository.ILapTopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IService {
    @Autowired
    private ILapTopRepository lapTopRepository;

    @Override
    public Iterable<LapTop> findAll() {
        return lapTopRepository.findAll();
    }

    @Override
    public Optional<LapTop> findById(Long id) {
        return lapTopRepository.findById(id);
    }

    @Override
    public LapTop save(LapTop lapTop) {
        return lapTopRepository.save(lapTop);
    }

    @Override
    public void remove(Long id) {
        lapTopRepository.deleteById(id);
    }
}
