/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.File;

/**
 *
 * @author User
 */
public class Evidencia {
    
    private File[] anexos;

    public Evidencia(File[] anexos) {
        this.anexos = anexos;
    }

    public Evidencia() {
    }
    
    public File[] getAnexos() {
        return anexos;
    }

    public void setAnexos(File[] anexos) {
        this.anexos = anexos;
    }
    
}
