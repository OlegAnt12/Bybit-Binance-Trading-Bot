/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author User
 */
public class Conta {
    
    private Utilizador usuario;
    private String senha;
    private String nivemAcesso;
    private String estado;

    public Conta(Utilizador usuario, String senha, String nivemAcesso, String estado) {
        this.usuario = usuario;
        this.senha = senha;
        this.nivemAcesso = nivemAcesso;
        this.estado = estado;
    }

    public Conta() {
    }

    
    public Utilizador getUsuario() {
        return usuario;
    }

    public void setUsuario(Utilizador usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivemAcesso() {
        return nivemAcesso;
    }

    public void setNivemAcesso(String nivemAcesso) {
        this.nivemAcesso = nivemAcesso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
