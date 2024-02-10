/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author User
 */
public class Utilizador {
    
    private int id;
    private String nome;
    private String senha;
    private int contacto;
    private String nomeUsuario;
    private String sobrenome;
    private String estado;

    public Utilizador(int id, String nome, int contacto, String nomeUsuario, String sobrenome, String estado) {
        this.id = id;
        this.nome = nome;
        this.contacto = contacto;
        this.nomeUsuario = nomeUsuario;
        this.sobrenome = sobrenome;
        this.estado = estado;
    }

    public Utilizador(int id, String nome, String senha, int contacto, String nomeUsuario, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.contacto = contacto;
        this.nomeUsuario = nomeUsuario;
        this.sobrenome = sobrenome;
    }
    
    public Utilizador(String nome, String senha, int contacto, String nomeUsuario, String sobrenome) {
        this.nome = nome;
        this.senha = senha;
        this.contacto = contacto;
        this.nomeUsuario = nomeUsuario;
        this.sobrenome = sobrenome;
    }

    public Utilizador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
