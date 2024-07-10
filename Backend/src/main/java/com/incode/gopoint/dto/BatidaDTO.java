package com.incode.gopoint.dto;


import java.sql.Timestamp;

import com.incode.gopoint.model.Batida;

public class BatidaDTO {

    private int idbatida;
    private int userId;
    private String tipo;
    private Timestamp horario;

    public BatidaDTO() {
    }

    public BatidaDTO(Batida batida) {
        this.idbatida = batida.getIdbatida();
        this.userId = batida.getUser().getIduser();
        this.tipo = batida.getTipo().name();
        this.horario = batida.getHorario();
    }

    // Getters and Setters
    public int getIdbatida() {
        return idbatida;
    }

    public void setIdbatida(int idbatida) {
        this.idbatida = idbatida;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getHorario() {
        return horario;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }
}