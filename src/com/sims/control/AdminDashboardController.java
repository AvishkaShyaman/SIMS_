/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.CourseDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AdminDashboardController implements Initializable {

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
    private BorderPane mainPane;
    @FXML
    private Button btn_AddNotice;
    @FXML
    private Button btn_update;

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
        pane = getpane("AdminUserprofile.fxml");
        mainPane.setRight(pane);
    }

    @FXML
    private void btn_courseActionHandel(ActionEvent event) {
        pane = getpane("AdminCourse.fxml");
        mainPane.setRight(pane);
    }

    @FXML
    private void btn_timetableActionHandel(ActionEvent event) {
        pane = getpane("AdminTimeTable.fxml");
        mainPane.setRight(pane);
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
    private void btn_AddNoticeActionHandler(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sims/view/AdminNoticeAdd.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void btn_update_test(ActionEvent event) {
        
        CourseDAO doa = new CourseDAO();
        
        System.out.println(doa.getCoursegrade("ENG1222","Tg/2016/224"));
    }

}
