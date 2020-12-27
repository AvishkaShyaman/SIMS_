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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Helanka
 */
public class LecturerStuGradeAndGPAController implements Initializable {

    @FXML
    private VBox notice_vbox;
    @FXML
    private ComboBox<?> cmb_Level;
    @FXML
    private ComboBox<?> cmb_Semester;
    @FXML
    private TextField txt;
    @FXML
    private Button btn_SearchTop;
    @FXML
    private ComboBox<?> cmb_Garde;
    @FXML
    private Button btn_SearchLeft;
    @FXML
    private ComboBox<?> cmb_CourseCode;
    @FXML
    private Button btn_SearchRight;
    @FXML
    private TableView<?> tableview;
    @FXML
    private TextField txt1;
    @FXML
    private Button btn_SearchBottom;
    @FXML
    private Label lbl_GPA;
    @FXML
    private Button btn_StuBack;
    @FXML
    private TableColumn<?, ?> tbl_CourseCode;
    @FXML
    private TableColumn<?, ?> tbl_Subject;
    @FXML
    private TableColumn<?, ?> tbl_StudentId;
    @FXML
    private TableColumn<?, ?> tbl_Garde;
    @FXML
    private TableColumn<?, ?> tbl_Year;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_SearchTopActionPerformed(ActionEvent event) {
    }

    @FXML
    private void btn_SearchLeftActionPerformed(ActionEvent event) {
    }

    @FXML
    private void btn_SearchRightActionPerformed(ActionEvent event) {
    }

    @FXML
    private void btn_SearchBottomActionPerformed(ActionEvent event) {
    }

    @FXML
    private void btn_StuBackActionPerformed(ActionEvent event) {
    }
    
}
