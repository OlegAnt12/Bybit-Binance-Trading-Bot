/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import conexao.ConexaoBD;
import entidades.Conversa;
import entidades.Mensagem;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class MensagemController {
    
    private ConexaoBD conexao = new ConexaoBD();
    private ResultSetImpl res;
    private int intRes;
    
    public int enviarMensagem(Mensagem mensagem, Conversa conversa)
    {
        try {
            if(verrifConversa(conversa))
            {
                intRes = conexao.conectarBD().executeUpdate(
                    "insert into tb_mensagem(texto, data, hora, conversa) "
                    + "values('"+mensagem.getTexto()+"','"+mensagem.getData()+"',"
                    +mensagem.getHora()+","+mensagem.getConversa()+")");
            }
            else
            {
                intRes = conexao.conectarBD().executeUpdate(
                    "insert into tb_conversa(emissor, destinatario) "
                    + "values("+conversa.getEmissor()+","+conversa.getDistinatario()+")");
                res=(ResultSetImpl)conexao.conectarBD().executeQuery(
                "Select * from tb_conversa where emissor = "+conversa.getEmissor()+
                " and destinatario = "+conversa.getDistinatario());
                
                intRes = conexao.conectarBD().executeUpdate(
                    "insert into tb_mensagem(texto, data, hora, conversa) "
                    + "values('"+mensagem.getTexto()+"','"+mensagem.getData()+"',"
                    +mensagem.getHora()+","+res.getInt("id")+")");
            }
            
        } catch (SQLException e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return intRes;
        }
    }
    
    public ResultSetImpl visualizarMensagem()
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery(
             "Select texto, data, hora, emissor, destinatario from "
                + "tb_mensagem inner JOIN tb_conversa on "
                     + "tb_mensagem.conversa= tb_conversa.id");
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        finally
        {
            return res;
        }
    }
    
    public boolean verrifConversa(Conversa conversa) throws SQLException
    {
        try {
            res = (ResultSetImpl) conexao.conectarBD().executeQuery(
            "select destinatario from tb_conversa where emissor = "
            +conversa.getEmissor());
            
            res.next();
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        
        if(res.getInt("destinatario")== conversa.getDistinatario())
            return true;
        else
            return false;
    }
}
