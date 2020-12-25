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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Helanka
 */
public class LecturerProfileUpdateController implements Initializable {

    @FXML
    private TextField txt_Fname;
    @FXML
    private TextField txt_Lname;
    @FXML
    private DatePicker date_dob;
    @FXML
    private RadioButton rad_male;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton rad_female;
    @FXML
    private TextField txt_NIC;
    @FXML
    private TextField txt_Contact;
    @FXML
    private TextField txt_Email;
    @FXML
    private TextArea txa_Address;
    @FXML
    private Button btn_Update;
    @FXML
    private Button btn_Edit;
    @FXML
    private Button btn_Cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_UpdateActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_EditActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_CancelActionHandel(ActionEvent event) {
    }
    
}
