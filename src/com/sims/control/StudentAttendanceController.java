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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author PC PLUS
 */
public class StudentAttendanceController implements Initializable {

    @FXML
    private VBox notice_vbox;
    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> colcoursecode;
    @FXML
    private TableColumn<?, ?> coldate;
    @FXML
    private TableColumn<?, ?> coltype;
    @FXML
    private TableColumn<?, ?> colhours;
    @FXML
    private TableColumn<?, ?> colstatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
