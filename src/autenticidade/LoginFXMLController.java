/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package autenticidade;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import controller.UtilizadorController;
import entidades.Utilizador;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.admin.AdminIniFXMLController;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginFXMLController implements Initializable {
    
    static ResultSetImpl res;
    AdminIniFXMLController admController = new AdminIniFXMLController();
    Utilizador util = new Utilizador();
    private String caminho;
    private Scene cena;
    private Stage estagio;
    private Parent menu;
    private String utilizador;
    private String senha;
    private String estadoConta;
    private String tipo;
    private boolean verif = false;
    
    static UtilizadorController uControle = new UtilizadorController();
    
    private double x = 0;
    private double y = 0;
    
    @FXML
    private Button btnlogin;

    @FXML
    private PasswordField txtsenha;

    @FXML
    private TextField txtusuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void login(ActionEvent evento)
    {
        estagio = new Stage();
        utilizador = txtusuario.getText();
        senha = txtsenha.getText();
        try {
           verif = uControle.autenticarUtilizador(utilizador, senha);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(verif)
        {
           res = uControle.peqsuisarUtilizador(utilizador);
            try {
                res.next();
                System.out.println(res.getString(8));
                if(res.getString(9).toLowerCase().equals("activo")){
                    if(res.getString(8).toLowerCase().equals("analista"))
                        analistaArea(evento);
                    else if(res.getString(8).toLowerCase().equals("administrador"))
                    {
                        //admController.setUtil();
                        util.setId(res.getInt("id"));
                        AdminIniFXMLController.setUtil(util);
                        adminArea(evento);
                        
                    }
                    
                }
                else
                {
                    System.out.println("Usuário não encontrado!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println("Não encontrado");
        }
    }
    
    private void adminArea(ActionEvent evento)
    {
        caminho="../view/admin/AdminIniFXML.fxml";
        try {
            menu = FXMLLoader.load(getClass().getResource(caminho));
        } catch (IOException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
            cena = new Scene(menu);
            estagio = (Stage)((Node)evento.getSource()).getScene().getWindow();

            estagio.setScene(cena);
            estagio.centerOnScreen();
            estagio.show();
    }
    
    private void analistaArea(ActionEvent evento)
    {
            caminho="../view/analista/AnalistaIniFXML.fxml";
        try {
            menu = FXMLLoader.load(getClass().getResource(caminho));
        } catch (IOException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
            cena = new Scene(menu);
            estagio = (Stage)((Node)evento.getSource()).getScene().getWindow();

            estagio.setScene(cena);
            estagio.centerOnScreen();
            estagio.show();
    }
    
    private void warner(ActionEvent evento)
    {
        caminho="../../gui/menu/WarnerBro.fxml";
            try {
                menu = FXMLLoader.load(getClass().getResource(caminho));
            } catch (IOException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            cena = new Scene(menu);
            estagio = (Stage)((Node)evento.getSource()).getScene().getWindow();
            estagio.setScene(cena);
            estagio.centerOnScreen();
            estagio.show();
    }
    
}
