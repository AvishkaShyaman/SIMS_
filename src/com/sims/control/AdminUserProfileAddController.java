/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AdminUserProfileAddController implements Initializable {

    @FXML
    private ComboBox combox_department;
    @FXML
    private ComboBox combox_job_staf;
    @FXML
    private ComboBox  combox_department_staf;

    ObservableList<String> dpt = FXCollections.observableArrayList("ICT", "ET", "BST");

    ObservableList<String> job = FXCollections.observableArrayList("Admin", "Lecturer", "Technical Officer");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combox_department.setItems(dpt);
        combox_department_staf.setItems(dpt);
        combox_job_staf.setItems(job);
        
    }

}
