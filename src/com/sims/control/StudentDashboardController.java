/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class StudentDashboardController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private Button btn_notice;
    @FXML
    private Button btn_userProfile;
    @FXML
    private Button btn_course;
    @FXML
    private Button btn_timetable;
    @FXML
    private VBox notice_vbox;
    
    Pane pane;
    @FXML
    private Button btn_gradeAndGPA;
    @FXML
    private Button btn_Attendance;
    @FXML
    private Button btn_medical;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_noticeActionHandel(ActionEvent event) {
        mainPane.setRight(notice_vbox);
    }

    @FXML
    private void btn_userProfileActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_courseActionHandel(ActionEvent event) {
        pane = getpane("StudentCourseDetails.fxml");
        mainPane.setRight(pane);
    }

    @FXML
    private void btn_timetableActionHandel(ActionEvent event) {
        
    }
    
    private Pane getpane(String fxmlname) {
        Pane pane = null;

        try {

            pane = FXMLLoader.load(getClass().getResource("/com/sims/view/" + fxmlname));

        } catch (IOException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pane;
    }

    @FXML
    private void btn_gradeAndGPAActionHandel(ActionEvent event) {
        pane = getpane("StudentGradeandGPA.fxml");
        mainPane.setRight(pane);
    }

    @FXML
    private void btn_AttendanceActionHandel(ActionEvent event) {
        pane = getpane("StudentAttendance.fxml");
        mainPane.setRight(pane);
    }

    @FXML
    private void btn_medicalActionHandel(ActionEvent event) {
        System.out.println("in med");
        pane = getpane("StudentMedicals.fxml");
        mainPane.setRight(pane);
        System.out.println("end med");
    }
    
}
