/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pragith
 */
public class TechnicalOfficerMedicalsUpdateController implements Initializable {

    @FXML
    private TextField txtStudentID;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnOk;
    @FXML
    private TextField txtRefNo;
    @FXML
    private ComboBox<?> combStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateActionController(ActionEvent event) {
    }

    @FXML
    private void okActionController(ActionEvent event) {
    }
    
}
