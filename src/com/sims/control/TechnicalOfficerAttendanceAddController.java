/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Attendance;
import com.sims.model.Student;
import com.sims.model.StudentDAO;
import com.sims.model.TechnicalOfficer;
import com.sims.model.TechnicalOfficerDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pragith
 */
public class TechnicalOfficerAttendanceAddController implements Initializable {

   
    
    
    @FXML
    private Button btnOk;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnReset;
  
    
    @FXML
    private TableView<Student> tableAttendance;
    @FXML
    private TableColumn<Student, String> colStudentID;
    
    @FXML
    private ComboBox combStudentYear;
    ObservableList<String> yearlist=FXCollections.observableArrayList();
    Student student = new Student();
    StudentDAO studentDAO = new StudentDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         //---------- year list pass to combobox-----------------
//        ArrayList<Student> year;
//        try {
//            year= studentDAO.studentYear();
//            for(Student student : year){
//                yearlist.add(String.valueOf(student.getYear()));
//            }
//            combStudentYear.setItems(yearlist);
//        } catch (SQLException ex) {
//            Logger.getLogger(TechnicalOfficerMedicalsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }    

    @FXML
    private void actionButtonHandler(ActionEvent event) {
        String year;

        year=(String) combStudentYear.getValue();

        
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        

    
//        ArrayList<Student> students = studentDAO.getStudentByDepartment(year, "dpt02");
//
//        System.out.println(year);
//        System.out.println(student.getCourseID());
//        for(Student student : students){
//            studentList.add(student);
//        }

        
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));

        tableAttendance.setItems(studentList);
        
        
        
    }


    @FXML
    private void resetMedicalAction(ActionEvent event) {
    }

    @FXML
    private void addAttendanceActionController(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sims/view/TechnicalOfficerAttendanceAddBox.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
