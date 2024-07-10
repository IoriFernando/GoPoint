package com.incode.gopoint.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incode.gopoint.dto.BatidaDTO;
import com.incode.gopoint.exception.ResourceNotFoundException;
import com.incode.gopoint.model.Batida;
import com.incode.gopoint.model.User;
import com.incode.gopoint.service.BatidaService;
import com.incode.gopoint.service.UserService;

@RestController
@RequestMapping("/api/batidas")
public class BatidaController {

    @Autowired
    private BatidaService batidaService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<BatidaDTO> getAllBatidas() {
        return batidaService.getAllBatidas().stream()
                .map(BatidaDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatidaDTO> getBatidaById(@PathVariable int id) {
        Batida batida = batidaService.getBatidaById(id);
        if (batida == null) {
            throw new ResourceNotFoundException("Batida not found with id: " + id);
        }
        return ResponseEntity.ok(new BatidaDTO(batida));
    }

    @PostMapping
    public BatidaDTO createBatida(@RequestBody BatidaDTO batidaDTO) {
        User user = userService.getUserById(batidaDTO.getUserId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id: " + batidaDTO.getUserId());
        }
        Batida batida = new Batida();
        batida.setUser(user);
        batida.setTipo(Batida.Tipo.valueOf(batidaDTO.getTipo()));
        batida.setHorario(batidaDTO.getHorario());
        return new BatidaDTO(batidaService.createBatida(batida));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatidaDTO> updateBatida(@PathVariable int id, @RequestBody BatidaDTO batidaDTO) {
        Batida batida = batidaService.getBatidaById(id);
        if (batida == null) {
            throw new ResourceNotFoundException("Batida not found with id: " + id);
        }
        User user = userService.getUserById(batidaDTO.getUserId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id: " + batidaDTO.getUserId());
        }
        batida.setUser(user);
        batida.setTipo(Batida.Tipo.valueOf(batidaDTO.getTipo()));
        batida.setHorario(batidaDTO.getHorario());
        return ResponseEntity.ok(new BatidaDTO(batidaService.updateBatida(batida)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatida(@PathVariable int id) {
        if (batidaService.getBatidaById(id) == null) {
            throw new ResourceNotFoundException("Batida not found with id: " + id);
        }
        batidaService.deleteBatida(id);
        return ResponseEntity.noContent().build();
    }
}