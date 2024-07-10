package com.incode.gopoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incode.gopoint.model.Batida;
import com.incode.gopoint.repository.BatidaRepository;

@Service
public class BatidaService {

    @Autowired
    private BatidaRepository batidaRepository;

    public List<Batida> getAllBatidas() {
        return batidaRepository.findAll();
    }

    public Batida getBatidaById(int id) {
        return batidaRepository.findById(id).orElse(null);
    }

    public Batida createBatida(Batida batida) {
        return batidaRepository.save(batida);
    }

    public Batida updateBatida(Batida batida) {
        return batidaRepository.save(batida);
    }

    public void deleteBatida(int id) {
        batidaRepository.deleteById(id);
    }
}