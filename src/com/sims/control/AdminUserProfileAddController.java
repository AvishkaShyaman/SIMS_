/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Student;
import com.sims.model.StudentDAO;
import com.sims.model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_nic;
    @FXML
    private TextField txt_fname;
    @FXML
    private TextField txt_contact;
    @FXML
    private TextField txt_batch;
    @FXML
    private DatePicker date_dob;
    @FXML
    private TextField txt_lname;
    @FXML
    private TextField txt_address;
    @FXML
    private RadioButton radio_btn;
    @FXML
    private Button btn_add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combox_department.setItems(dpt);
        combox_department_staf.setItems(dpt);
        combox_job_staf.setItems(job);
        
    }

    @FXML
    private void btn_addActionHandler(ActionEvent event) {
        Student st1 = new Student();
        
        st1.setUserID(txt_id.getText());
        st1.setFirstName(txt_fname.getText());
        st1.setLastname(txt_lname.getText());
        st1.setUsernic(txt_nic.getText());
        st1.setAddress(txt_address.getText());
        st1.setGender("m");
        st1.setDepartment("dpt01");
        st1.setDob("01-05-1998");
        st1.setEmail(txt_email.getText());
        st1.setYear(1);
        st1.setSemester(1);
        st1.setPhone(763234443);
        
        StudentDAO dao =new StudentDAO();
        boolean val = dao.saveStudent(st1);
        
        if(val){
            System.out.println("Add");
        } else {
            System.out.println("Error");
        }       
    }

}
