/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import java.net.URL;
import java.util.ResourceBundle;
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
public class TechnicalOfficerMedicalsAddController implements Initializable {

    @FXML
    private TextField txtStudentID;
    @FXML
    private DatePicker txtDateStart;
    @FXML
    private DatePicker txtDateEnd;
    @FXML
    private ComboBox<?> combCourseID;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnReset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
