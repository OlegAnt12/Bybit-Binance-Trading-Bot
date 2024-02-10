/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import conexao.ConexaoBD;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DenunciaController {
    
    private ResultSetImpl res;
    private ConexaoBD conexao = new ConexaoBD();
    private int intRes;
    
    public ResultSetImpl visualizarDenuncia()
    {
        try 
        {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("select * from tb_denuncia");
        } 
        catch (SQLException e) 
        {
            System.out.println(""+e.getErrorCode());
        } 
        finally 
        {
            return res;
        }
    }
    
    public int aceitarDenuncia (int id, String estado)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_denuncia set estado = '"+estado+"' where id = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    } 
           
}
