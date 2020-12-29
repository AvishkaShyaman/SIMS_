/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Course;
import com.sims.model.CourseDAO;
import com.sims.model.Student;
import com.sims.model.User;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author PC PLUS
 */
public class StudentGradeandGPAController implements Initializable {

    @FXML
    private VBox notice_vbox;
    @FXML
    private TableView<Course> tableview;
    @FXML
    private TableColumn<Course, String> colcoursecode;
    @FXML
    private TableColumn<Course, String> colcoursename;
    @FXML
    private TableColumn<Course, String> colgrade;
    @FXML
    private Label lable_sgpa;
    @FXML
    private Label lable_cgpa;
    
    ObservableList<Course> obslist = FXCollections.observableArrayList();
    
    CourseDAO dao = new CourseDAO();
    
    private Student student;
    @FXML
    private Button btn_gnarate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    private void setdetails(String id,int year,int sem){
        ArrayList<Course> courses = dao.getStudentAllCourseList(student.getUserID(), 1, 2);
        
        for(Course course : courses){
            course.setGrade(dao.getCoursegrade(course.getCourseid(), student.getUserID()));
            obslist.add(course);
            System.out.println(course.getCourseid());
        }
        
        colcoursecode.setCellValueFactory(new PropertyValueFactory<>("courseid"));
        colcoursename.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colgrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        tableview.setItems(obslist);
        
        double sgpa = student.getSGPA(courses);
        
        DecimalFormat df = new DecimalFormat("####0.00");
        System.out.println("Value: " + df.format(sgpa));
        
        lable_sgpa.setText(df.format(sgpa));
        lable_cgpa.setText(df.format(sgpa));
    }

    public void setStudent(Student student) {
        this.student = student;
        setdetails(student.getUserID(),student.getYear(),student.getSemester());
    }

    @FXML
    private void btn_gnarateActionhandler(ActionEvent event) {
        setdetails(student.getUserID(),1,2);
    }
    
}
