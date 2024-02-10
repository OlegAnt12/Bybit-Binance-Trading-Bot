/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author User
 */
public class ConexaoBD {
    
    private String caminho = "jdbc:mysql://localhost/denuncia_assedio?zeroDateTimeBehavior=convertToNull";
    private String user = "root";
    private String passe = "";
    private String nomeClasse = "com.mysql.cj.jdbc.Driver";
    private Connection conexao;
    private Statement testamento;
    
    public Statement conectarBD ()
    {
        try
        {
            Class.forName(nomeClasse);
            conexao = DriverManager.getConnection(caminho,user,passe);
            testamento = conexao.createStatement();
            return testamento;
        }
        catch(Exception e)
        {
            
        }
        
        finally
        {
            return testamento;
        }
    }
}
