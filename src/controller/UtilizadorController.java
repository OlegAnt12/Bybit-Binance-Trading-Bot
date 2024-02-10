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
public class UtilizadorController {
    
    private ConexaoBD conexao = new ConexaoBD();
    private ResultSetImpl res;
    private int intRes;
    
    public int registarUtilizador(int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("insert into tb_utilizador() values()");
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public ResultSetImpl visualizarTBUtilizador()
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("SELECT * from tb_utilizador inner JOIN tb_conta on tb_utilizador.id= tb_conta.usuario");
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return res;
        }
    }
    
    public ResultSetImpl visualizarNotAdmin()
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("SELECT * from tb_utilizador inner JOIN tb_conta on tb_utilizador.id= tb_conta.usuario where nivel_acesso <> 'administrador'");
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return res;
        }
    }
    
    public ResultSetImpl visualizarNotUser(int id)
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("SELECT * from tb_utilizador inner JOIN tb_conta on tb_utilizador.id= tb_conta.usuario where id <>"+id);
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return res;
        }
    }
    
    public ResultSetImpl peqsuisarUtilizador(String nome)
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("SELECT *, estado from tb_utilizador inner JOIN tb_conta on tb_utilizador.id= tb_conta.usuario where nome = '"+nome+"'");
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return res;
        }
    }
    
    public int bloquearUtilizador(int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_conta set estado = 'bloqueado' where usuario = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public int desbloquearUtilizador(int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_conta set estado = 'activo' where usuario = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public boolean autenticarUtilizador(String email, String senha) throws SQLException
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("select nome, senha from tb_utilizador where nome = '"+email+"'");
            res.next();
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        
        return res.getString("senha").equals(senha);
    }
    
    public int aceitarPedidoDeRegisto (int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_utilizador set estadopedido = 'aceite' where id = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public int rejeitarPedidoDeRegisto (int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_pedidoderegisto set estadopedido = 'rejeitado' where id = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public ResultSetImpl selectUtilizador(int id)
    {
        try 
        {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery("select * from tb_utilizador where id="+id);
        } 
        catch (SQLException e) 
        {
        } 
        finally 
        {
            return res;
        }
    }
    
    public int loggar (int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_conta set log = 'logado' where id = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public int terminarSessao (int id)
    {
        try {
            intRes = conexao.conectarBD().executeUpdate("Update tb_conta set log = 'deslogado' where usuario = "+id);
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    
}
