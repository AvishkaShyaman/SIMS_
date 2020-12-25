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
public class TechnicalOfficerMedicalsController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private VBox notice_vbox;
    @FXML
    private TextField txtStudentID;
    @FXML
    private DatePicker btnDate;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnFilter;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> colSubmitedDate;
    @FXML
    private TableColumn<?, ?> colStudentID;
    @FXML
    private TableColumn<?, ?> colCourseID;
    @FXML
    private TableColumn<?, ?> colStatus;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
