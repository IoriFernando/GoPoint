package com.incode.gopoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incode.gopoint.model.Batida;

@Repository
public interface BatidaRepository extends JpaRepository<Batida, Integer> {
}