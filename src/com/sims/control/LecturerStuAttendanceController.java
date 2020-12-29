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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Helanka
 */
public class LecturerStuAttendanceController implements Initializable {

    @FXML
    private ComboBox<String> cmb_SearchBy;
    @FXML
    private TextField txt_SearchBy;
    @FXML
    private Button btn_Search;
    @FXML
    private TableColumn<?, ?> tbl_CourseCode;
    @FXML
    private TableColumn<?, ?> tbl_CourseName;
    @FXML
    private TableColumn<?, ?> tbl_StudentId;
    @FXML
    private TableColumn<?, ?> tbl_Date;
    @FXML
    private TableColumn<?, ?> tbl_Time;
    @FXML
    private TableColumn<?, ?> tbl_Hours;
    @FXML
    private TableColumn<?, ?> tbl_Type;
    @FXML
    private TableColumn<?, ?> tbl_Status;
    @FXML
    private Button btn_StuBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmb_SearchBy.getItems().addAll("Student ID", "Course Code");
    }    

    @FXML
    private void btn_SearchActionPerformed(ActionEvent event) {
        if (cmb_SearchBy.getValue().isEmpty() || txt_SearchBy.getText().isEmpty()) {
        
        } else {
            if (null != cmb_SearchBy.getValue()) switch (cmb_SearchBy.getValue()) {
                case "Student ID":
                    clearField();
                    break;
                case "Course Code":
                    clearField();
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    private void btn_StuBackActionPerformed(ActionEvent event) {
    }
    
    private void clearField() {
        cmb_SearchBy.setValue(null);
        txt_SearchBy.setText(null);
    }
    
}
