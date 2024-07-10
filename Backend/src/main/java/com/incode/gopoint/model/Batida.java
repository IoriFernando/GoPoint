package com.incode.gopoint.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "batida")
public class Batida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbatida;

    @ManyToOne
    @JoinColumn(name = "user_iduser", nullable = false)
    private User user;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "horario", nullable = false)
    private java.sql.Timestamp horario;

    // Getters and Setters
    public int getIdbatida() {
        return idbatida;
    }

    public void setIdbatida(int idbatida) {
        this.idbatida = idbatida;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public java.sql.Timestamp getHorario() {
        return horario;
    }

    public void setHorario(java.sql.Timestamp timestamp) {
        this.horario = timestamp;
    }

    public enum Tipo {
        ZERO("0"),
        UM("1");

        private String code;

        Tipo(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}