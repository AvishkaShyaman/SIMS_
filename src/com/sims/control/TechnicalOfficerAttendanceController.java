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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author pragith
 */
public class TechnicalOfficerAttendanceController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private VBox notice_vbox;
    @FXML
    private TextField txtStuId;
    @FXML
    private DatePicker txtDate;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtCourseId;
    @FXML
    private TableView<?> tableAttendance;
    @FXML
    private TableColumn<?, ?> colNo;
    @FXML
    private TableColumn<?, ?> colDate;
    @FXML
    private TableColumn<?, ?> colStudent;
    @FXML
    private TableColumn<?, ?> colCourseId;
    @FXML
    private TableColumn<?, ?> colStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
}
