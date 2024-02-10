/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestaodedenuncia;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import controller.UtilizadorController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author User
 */
public class GestaoDeDenuncia extends Application{

    static ResultSetImpl res;
    static UtilizadorController uControle = new UtilizadorController();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        launch(args);
        
    }
    
    @Override
    public void start(Stage estagioPrimario) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../autenticidade/LoginFXML.fxml"));
       
        Scene scene = new Scene(root);
        estagioPrimario.setTitle("Olá Mundo!");
        estagioPrimario.initStyle(StageStyle.UNDECORATED);
        estagioPrimario.setScene(scene);
        
        estagioPrimario.show();
    }
    
}
