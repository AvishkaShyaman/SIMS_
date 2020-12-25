/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import com.sims.model.User;
import com.sims.model.UserDAO;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AdminUserprofileController implements Initializable {

    @FXML
    private Button btn_addProfile;
    @FXML
    private TableView<User> table_view;
    @FXML
    private TableColumn<User, String> table_cl_id;
    @FXML
    private TableColumn<User, String> table_cl_name;
    @FXML
    private TableColumn<User, String> table_cl_email;
    @FXML
    private TableColumn<User, String> table_cl_dpt;
    @FXML
    private TableColumn<User, String> table_cl_;
    
    ObservableList<User> obslist = FXCollections.observableArrayList();
    
    UserDAO dao = new UserDAO();

    /**
     * Initializes the controller class.
     * 
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<User> users = dao.getAllUser();
        
        for(User user : users){
            obslist.add(user);
            System.out.println(" "+user.getUserID()+" "+user.getAddress()+" "+user.getEmail()+" "+user.getFirstName());
        }
        
        table_cl_id.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        table_cl_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        table_cl_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table_cl_dpt.setCellValueFactory(new PropertyValueFactory<>("gender"));
        table_cl_.setCellValueFactory(new PropertyValueFactory<>("usernic"));
        
        table_view.setItems(obslist);
    }    

    @FXML
    private void btn_addProfileActionHandel(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sims/view/AdminUserProfileAdd.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
