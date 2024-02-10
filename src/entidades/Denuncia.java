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
public class Denuncia {
    
    private int id;
    private int autor;
    private int vitima;
    private Evidencia evidencia;
    private String tipoAssedio;
    private Date dataDeOcorrencia;
    private String localDeOcorrencia;
    private String estado;
    private int utilizador;

    public Denuncia(int id, int autor, int vitima, String tipoAssedio, 
            Date dataDeOcorrencia, String localDeOcorrencia, String estado, int utilizador) {
        this.id = id;
        this.autor = autor;
        this.vitima = vitima;
        this.tipoAssedio = tipoAssedio;
        this.dataDeOcorrencia = dataDeOcorrencia;
        this.localDeOcorrencia = localDeOcorrencia;
        this.estado = estado;
        this.utilizador = utilizador;
    }

    public Denuncia() {
    }
    
    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getVitima() {
        return vitima;
    }

    public void setVitima(int vitima) {
        this.vitima = vitima;
    }

    public Evidencia getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(Evidencia evidencia) {
        this.evidencia = evidencia;
    }

    public String getTipoAssedio() {
        return tipoAssedio;
    }

    public void setTipoAssedio(String tipoAssedio) {
        this.tipoAssedio = tipoAssedio;
    }

    public Date getDataDeOcorrencia() {
        return dataDeOcorrencia;
    }

    public void setDataDeOcorrencia(Date dataDeOcorrencia) {
        this.dataDeOcorrencia = dataDeOcorrencia;
    }

    public String getLocalDeOcorrencia() {
        return localDeOcorrencia;
    }

    public void setLocalDeOcorrencia(String localDeOcorrencia) {
        this.localDeOcorrencia = localDeOcorrencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(int utilizador) {
        this.utilizador = utilizador;
    }
    
    
}
