/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.ExamDAO;
import com.sims.model.MarksDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Helanka
 */
public class LecturerExamController implements Initializable {

    @FXML
    private ComboBox<String> cmb_CourseCode;
    @FXML
    private ComboBox<String> cmb_ExamType;
    @FXML
    private Button btn_Add;
    @FXML
    private Button btn_Update;
    @FXML
    private TextField txt_StudentId;
    @FXML
    private TextField txt_Marks;
    @FXML
    private Button btn_Delete;
    
    
    MarksDAO marksDAO = new MarksDAO();
    ExamDAO examDAO = new ExamDAO();
    //ComboBox database
    private ArrayList<String> courseid() {
        ArrayList<String> id = new ArrayList<String>();
        id = examDAO.getExamCourseId();
        return id;
    }
    ObservableList<String> courseId = FXCollections.observableArrayList(courseid());
    
    //ComboBox database
    private ArrayList<String> examType() {
        ArrayList<String> type = new ArrayList<String>();
        type = examDAO.getExamType();
        return type;
    }
    ObservableList<String> examType = FXCollections.observableArrayList(examType());
    
    private void clearField() {
        txt_StudentId.setText("");
        txt_Marks.setText("");
        cmb_CourseCode.setValue("");
        cmb_ExamType.setValue("");
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ComboBox database
        cmb_CourseCode.setItems(courseId);
        cmb_ExamType.setItems(examType);
    }    

    @FXML
    private void btn_AddActionPerformed(ActionEvent event) {
        
        if (isFieldsEmpty()) {
            //JOptionPane.showMessageDialog(this, "Some fields are missing", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            if (marksDAO.insertMarks(cmb_CourseCode.getValue().toUpperCase(), cmb_ExamType.getValue().toUpperCase(), txt_StudentId.getText(), Float.parseFloat(txt_Marks.getText()))) {
                //JOptionPane.showMessageDialog(this, "successfully inserted");
                //setAllStudentTabale();
                clearField();
            } else {
                //JOptionPane.showMessageDialog(this, "Error in inserting record", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
    }

    @FXML
    private void btn_UpdateActionPerformed(ActionEvent event) {
    }

    @FXML
    private void btn_DeleteActionPerformed(ActionEvent event) {
    }
    
    private boolean isFieldsEmpty() {
        return cmb_CourseCode.getValue()== null || cmb_ExamType.getValue()== null || txt_Marks.getText().isEmpty() || txt_StudentId.getText().isEmpty();
    }
    
    
    
}
