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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Helanka
 */
public class LecturerExamController implements Initializable {

    @FXML
    private ChoiceBox<?> cmb_CourseCode;
    @FXML
    private ChoiceBox<?> cmb_ExamType;
    @FXML
    private Button btn_Add;
    @FXML
    private Button btn_Update;
    @FXML
    private TextField txt_StudentId;
    @FXML
    private TextField txt_Marks;
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
    private void btn_AddActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_UpdateActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_CancelActionHandel(ActionEvent event) {
    }
    
}
