/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.analista;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import controller.DenunciaController;
import controller.MensagemController;
import controller.UtilizadorController;
import entidades.Autor;
import entidades.Denuncia;
import entidades.Mensagem;
import entidades.Utilizador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import view.admin.AdminIniFXMLController;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AnalistaIniFXMLController implements Initializable {

     static ResultSetImpl res;
    static UtilizadorController uControle = new UtilizadorController();
    static DenunciaController denControle = new DenunciaController();
    static MensagemController msgControle = new MensagemController();
    private static Utilizador util = new Utilizador();

    
    
    @FXML
    private TableColumn<Utilizador, String> lblID;

    @FXML
    private TableColumn<Utilizador, String> lblNome;

    @FXML
    private TableColumn<Utilizador, String> lblSob;

    @FXML
    private TableColumn<Utilizador, Integer> lblcontacto;
    
    @FXML
    private TableColumn<?, ?> lblestado;
    
    @FXML
    private TableColumn<?, ?> lbladicional;

    @FXML
    private TableColumn<Utilizador, String> lblusr;
    
     @FXML
    private TextField txtpesquisa;

    @FXML
    private TableView<Utilizador> tbview;
    
     @FXML
    private TableView<Denuncia> tbview1;
    
    @FXML
    private Button btnavaliar;
    
    @FXML
    private Button btnInvestigar;
    
     @FXML
    private Button btnbloquear;

    @FXML
    private Button btndesbloquear;
    
    @FXML
    private TableColumn<?, ?> lbladicional1;
    
     @FXML
    private TableColumn<?, ?> lblID1;

    @FXML
    private TableColumn<?, ?> lblNome1;


    @FXML
    private TableColumn<?, ?> lblSob1;


    @FXML
    private TableColumn<?, ?> lbladicional11;


    @FXML
    private TableColumn<?, ?> lblcontacto1;

    @FXML
    private TableColumn<?, ?> lblestado1;


    @FXML
    private TableColumn<?, ?> lblusr1;
    
    @FXML
    private TextArea txtarea;
    
     @FXML
    private Text textlorem;
     
       @FXML
    private TableColumn<?, ?> lblID2;

    @FXML
    private TableColumn<?, ?> lblNome2;


    @FXML
    private TableColumn<?, ?> lblSob2;
    @FXML
    private TableColumn<?, ?> lblusr2;
     
     @FXML
    private TableView<Mensagem> tbview2;

    
    ObservableList<Utilizador> usrlista = FXCollections.observableArrayList();
    ObservableList<Denuncia> denlista = FXCollections.observableArrayList();
    ObservableList<Mensagem> msglista = FXCollections.observableArrayList();
    Utilizador utl = new Utilizador();
    Autor autor = new Autor();
    int id;
    String estado;
    
    public static Utilizador getUtil() {
        return util;
    }

    public static void setUtil(Utilizador util) {
        AdminIniFXMLController.util = util;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnInvestigar.setVisible(false);
        btnavaliar.setVisible(false);
        lbladicional.setVisible(false);
        lbladicional1.setVisible(false);
        tbview1.setVisible(false);
        txtarea.setVisible(false);
        tbview2.setVisible(false);
        
        //textlorem.setText("Holeg Názaré Francisco António");
        
        res = uControle.visualizarNotUser(util.getId());
        usrlista.clear();
        lblID.setCellValueFactory(new PropertyValueFactory<>("id"));
            lblNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            lblSob.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
            lblcontacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
            lblusr.setCellValueFactory(new PropertyValueFactory<>("nomeUsuario"));
            lblestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        try
        {
           while(res.next())
           {
               usrlista.add(new Utilizador(
               res.getInt("id"),
               res.getString("nome"),
               res.getInt("contacto"),
               res.getString("nome_usuario"),
               res.getString("sobrenome"),
               res.getString("estado")));
           }
           tbview.setItems(usrlista);
           
        }
        catch (Exception e)
        {
            System.out.println(""+e.getMessage());
        }
        
        
    }

    @FXML
    public void pesquisarUtilizador(ActionEvent evento)
    {
        usrlista.clear();
        utl.setNome(txtpesquisa.getText());
        res = uControle.peqsuisarUtilizador(utl.getNome().toLowerCase());
        lblID.setCellValueFactory(new PropertyValueFactory<>("id"));
            lblNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            lblSob.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
            lblcontacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
            lblusr.setCellValueFactory(new PropertyValueFactory<>("nomeUsuario"));
            lblestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        try
        {
           while(res.next())
           {
               usrlista.add(new Utilizador(
               res.getInt("id"),
               res.getString("nome"),
               res.getInt("contacto"),
               res.getString("nome_usuario"),
               res.getString("sobrenome"),
               res.getString("estado")));
           }
           tbview.setItems(usrlista);
           
        }
        catch (Exception e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
    @FXML
    public void alterarDenuncia()
    {
        res = denControle.visualizarDenuncia();
        denlista.clear();
        lbladicional1.setVisible(true);
        btnInvestigar.setVisible(true);
        btnavaliar.setVisible(true);
        btnbloquear.setVisible(false);
        btndesbloquear.setVisible(false);
        tbview1.setVisible(true);
        tbview.setVisible(false);
        txtarea.setVisible(false);
        tbview2.setVisible(false);
        
        lblID1.setCellValueFactory(new PropertyValueFactory<>("id"));
        lblNome1.setCellValueFactory(new PropertyValueFactory<>("autor"));
        lblSob1.setCellValueFactory(new PropertyValueFactory<>("vitima"));
        lblcontacto1.setCellValueFactory(new PropertyValueFactory<>("tipoAssedio"));
        lblusr1.setCellValueFactory(new PropertyValueFactory<>("dataDeOcorrencia"));
        lblestado1.setCellValueFactory(new PropertyValueFactory<>("localDeOcorrencia"));
        lbladicional1.setCellValueFactory(new PropertyValueFactory<>("estado"));
        lbladicional11.setCellValueFactory(new PropertyValueFactory<>("utilizador"));
        
        try
        {
           while(res.next())
           {
               denlista.add(new Denuncia(
               res.getInt("id"),
               res.getInt("autor"),
               res.getInt("vitima"),
               res.getString("tipo_assedio"),
               res.getDate("data_de_ocorrencia"),
               res.getString("local_de_ocorrencia"),
               res.getString("estado"),
               res.getInt("usuario")));
           }
           tbview1.setItems(denlista);
           
        }
        catch (Exception e)
        {
            System.out.println(""+e.getMessage());
        }
        
    }
    
    @FXML
    public void alteraUtilizadores()
    {
        res = denControle.visualizarDenuncia();
        denlista.clear();
        btnInvestigar.setVisible(false);
        btnavaliar.setVisible(false);
        btnbloquear.setVisible(true);
        btndesbloquear.setVisible(true);
        tbview1.setVisible(false);
        tbview.setVisible(true);
        txtarea.setVisible(false);
        tbview2.setVisible(false);
        
        lblID.setCellValueFactory(new PropertyValueFactory<>("id"));
        lblNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        lblSob.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
        lblcontacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        lblusr.setCellValueFactory(new PropertyValueFactory<>("nomeUsuario"));
        lblestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        try
        {
           while(res.next())
           {
               usrlista.add(new Utilizador(
               res.getInt("id"),
               res.getString("nome"),
               res.getInt("contacto"),
               res.getString("nome_usuario"),
               res.getString("sobrenome"),
               res.getString("estado")));
           }
           tbview.setItems(usrlista);
           
        }
        catch (Exception e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
    @FXML
    public void alterarMensagem()
    {
        msglista.clear();
        res = msgControle.visualizarMensagem();
        txtarea.setVisible(true);
        tbview2.setVisible(true);
        tbview1.setVisible(false);
        tbview.setVisible(false);
        
        lblID2.setCellValueFactory(new PropertyValueFactory<>("utilizador"));
        lblNome2.setCellValueFactory(new PropertyValueFactory<>("texto"));
        lblSob2.setCellValueFactory(new PropertyValueFactory<>("data"));
        lblusr2.setCellValueFactory(new PropertyValueFactory<>("hora"));
        
        try
        {
           while(res.next())
           {
               msglista.add(new Mensagem(
               res.getString("id"),
               res.getDate("nome"),
               res.getString("contacto"),
               res.getString("nome_usuario")));
           }
           tbview2.setItems(msglista);
           
        }
        catch (Exception e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
    @FXML
    public void bloquearUtilizador ()
    {
        try
        {
            uControle.bloquearUtilizador(tbview.getSelectionModel().getSelectedItem().getId());
        }catch(Exception e)
        {
            System.out.println(""+e.getMessage());
        }
        alteraUtilizadores();
    }
    
    @FXML
    public void desbloquearUtilizador ()
    {
        uControle.desbloquearUtilizador(tbview.getSelectionModel().getSelectedItem().getId());
        alteraUtilizadores();
    }
    
    @FXML
    public void avaliarDenuncia ()
    {
        id = tbview1.getSelectionModel().getSelectedItem().getId();
        denControle.aceitarDenuncia (id, "Em Avalição");
        alterarDenuncia();
    }
    
    @FXML
    public void investigarDenuncia ()
    {
        id = tbview1.getSelectionModel().getSelectedItem().getId();
        denControle.aceitarDenuncia (id, "Investigar");
        alterarDenuncia();
    }
    
    @FXML
    public void rejeitarDenuncia ()
    {
        id = tbview1.getSelectionModel().getSelectedItem().getId();
        denControle.aceitarDenuncia (id, "Rejeitada");
        alterarDenuncia();
    }
    
    @FXML
    public void terminarSessao()
    {
        uControle.terminarSessao(1);
        System.exit(0);
    }  
    
}
