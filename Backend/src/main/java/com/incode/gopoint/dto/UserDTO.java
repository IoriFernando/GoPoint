package com.incode.gopoint.dto;

import com.incode.gopoint.model.User;

public class UserDTO {

    private int iduser;
    private String nome;
    private String email;
    private String senha;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.iduser = user.getIduser();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    }

    // Getters and Setters
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}