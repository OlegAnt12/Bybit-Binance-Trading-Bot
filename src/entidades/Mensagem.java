/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author User
 */
public class Mensagem {
    
    private String texto;
    private Date data;
    private String hora;
    private Conversa conversa;
    private String utilizador;

    public Mensagem(String texto, Date data, String hora, Conversa conversa) {
        this.texto = texto;
        this.data = data;
        this.hora = hora;
        this.conversa = conversa;
    }

    public Mensagem(String texto, Date data, String hora, String utilizador) {
        this.texto = texto;
        this.data = data;
        this.hora = hora;
        this.utilizador = utilizador;
    }
    
    

    public Mensagem() {
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }
}
