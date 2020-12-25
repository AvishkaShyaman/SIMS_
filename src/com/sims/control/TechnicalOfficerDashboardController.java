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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class TechnicalOfficerDashboardController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private Button btn_notice;
    @FXML
    private Button btn_timetable;
    @FXML
    private VBox notice_vbox;
    @FXML
    private Button btn_attendance;
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
    }

    @FXML
    private void btn_userProfileActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_courseActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_timetableActionHandel(ActionEvent event) {
    }
    
}
