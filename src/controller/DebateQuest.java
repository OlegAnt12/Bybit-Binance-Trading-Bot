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
public class DebateQuest {
    
    private ConexaoBD conexao = new ConexaoBD();
    private ResultSetImpl res;
    private int intRes;
    
    public int registarFAQ()
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("insert into tb_faq() values()");
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public ResultSetImpl selectDebate(int id)
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("select * from tb_utilizador where id = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        
        return res;
        
    }
    
    public int alterarEstadoDebate (int id, String estado)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_debate set estado = '"+estado+"' where id = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    } 
}
