/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Helanka
 */
public class LecturerProfileUpdateController implements Initializable {

    @FXML
    private ToggleGroup Gender;
    @FXML
    private TextField txt_Fname;
    @FXML
    private TextField txt_Lname;
    @FXML
    private RadioButton rad_Male;
    @FXML
    private RadioButton rad_Female;
    @FXML
    private TextField txt_NIC;
    @FXML
    private TextField txt_Contact;
    @FXML
    private TextField txt_Email;
    @FXML
    private TextArea txa_Address;
    @FXML
    private Button btn_Edit;
    @FXML
    private Button btn_Update;
    @FXML
    private Button btn_Cancel;
    @FXML
    private TextArea txa_Qualifications;
    @FXML
    private DatePicker datePicker_DOB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setfieldsView();
        
        btn_Update.setVisible(false);
        btn_Cancel.setVisible(false);
        
        txt_Fname.setDisable(true);
        txt_Lname.setDisable(true);
        datePicker_DOB.setDisable(true);
        rad_Male.setDisable(true);
        rad_Female.setDisable(true);
        txt_NIC.setDisable(true);
        txt_Contact.setDisable(true);
        txt_Email.setDisable(true);
        txa_Address.setDisable(true);
        txa_Qualifications.setDisable(true);
    }    

    @FXML
    private void btn_EditActionPerformed(ActionEvent event) {
        txt_Fname.setDisable(false);
        txt_Lname.setDisable(false);
        datePicker_DOB.setDisable(false);
        rad_Male.setDisable(false);
        rad_Female.setDisable(false);
        txt_NIC.setDisable(false);
        txt_Contact.setDisable(false);
        txt_Email.setDisable(false);
        txa_Address.setDisable(false);
        txa_Qualifications.setDisable(false);
        
        btn_Edit.setVisible(false);
        btn_Update.setVisible(true);
        btn_Cancel.setVisible(true);
    }

    @FXML
    private void btn_UpdateActionPerformed(ActionEvent event) {
        if (isFieldsEmpty()) {
            //JOptionPane.showMessageDialog(this, "Some fields are missing", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            //if () {
                //JOptionPane.showMessageDialog(this, "successfully updated");
                setfieldsView();
                setFieldsDisable();
            //} else {
                //JOptionPane.showMessageDialog(this, "Error in Updating data", "Warning", JOptionPane.ERROR_MESSAGE);
            //}
        }
    }

    @FXML
    private void btn_CancelActionPerformed(ActionEvent event) {
        txt_Fname.setDisable(true);
        txt_Lname.setDisable(true);
        datePicker_DOB.setDisable(true);
        rad_Male.setDisable(true);
        rad_Female.setDisable(true);
        txt_NIC.setDisable(true);
        txt_Contact.setDisable(true);
        txt_Email.setDisable(true);
        txa_Address.setDisable(true);
        txa_Qualifications.setDisable(true);
        
        btn_Edit.setVisible(true);
        btn_Update.setVisible(false);
        btn_Cancel.setVisible(false);
    }
    
    private void setfieldsView() {
        txt_Fname.setText("a");
        txt_Lname.setText("a");
        //datePicker_DOB.setValue();
        //if ("M".equals()) {
            rad_Male.setSelected(true);
        //} else if ("F".equals()) {
            rad_Female.setSelected(true);
        //}
        txt_NIC.setText("a");
        txt_Contact.setText("a");
        txt_Email.setText("a");
        txa_Address.setText("a");
        txa_Qualifications.setText("a");
    }
    
    private boolean isFieldsEmpty() {
        return txt_Fname.getText().isEmpty() || txt_Lname.getText().isEmpty() || datePicker_DOB.getValue() == null || 
                Gender.getSelectedToggle() == null || txt_NIC.getText().isEmpty() || txt_Contact.getText().isEmpty() || 
                txt_Email.getText().isEmpty() || txa_Address.getText().isEmpty() || txa_Qualifications.getText().isEmpty();
    }
    
    private void setFieldsDisable() {
        txt_Fname.setDisable(true);
        txt_Lname.setDisable(true);
        datePicker_DOB.setDisable(true);
        rad_Male.setDisable(true);
        rad_Female.setDisable(true);
        txt_NIC.setDisable(true);
        txt_Contact.setDisable(true);
        txt_Email.setDisable(true);
        txa_Address.setDisable(true);
        txa_Qualifications.setDisable(true);
        
        btn_Edit.setVisible(true);
        btn_Update.setVisible(false);
        btn_Cancel.setVisible(false);
    }

    
}
