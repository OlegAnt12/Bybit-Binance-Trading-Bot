/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author User
 */
public class Conversa {
    
    private int id;
    private int emissor;
    private int distinatario;

    public Conversa(int id, int emissor, int distinatario) {
        this.id = id;
        this.emissor = emissor;
        this.distinatario = distinatario;
    }

    public Conversa() {
    }

    public Conversa(int distinatario) {
        this.distinatario = distinatario;
    }

    public int getDistinatario() {
        return distinatario;
    }

    public void setDistinatario(int distinatario) {
        this.distinatario = distinatario;
    }

    public int getEmissor() {
        return emissor;
    }

    public void setEmissor(int emissor) {
        this.emissor = emissor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
