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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Course> courses = dao.getStudentAllCourseList("tg/2018/376", 1, 2);
        
        for(Course course : courses){
            course.setGrade(dao.getCoursegrade(course.getCourseid(), "tg/2018/376"));
            obslist.add(course);
            //System.out.println(" "+user.getUserID()+" "+user.getAddress()+" "+user.getEmail()+" "+user.getFirstName());
        }
        
        colcoursecode.setCellValueFactory(new PropertyValueFactory<>("courseid"));
        colcoursename.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colgrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        tableview.setItems(obslist);
        
        Student s1 = new Student();
        s1.setUserID("tg/2018/376");
        
        double sgpa = s1.getSGPA(courses);
        
        DecimalFormat df = new DecimalFormat("####0.00");
        System.out.println("Value: " + df.format(sgpa));
        
        lable_sgpa.setText(df.format(sgpa));
        lable_cgpa.setText(df.format(sgpa));
    }

    private void setgpa(){
        
        
        
        
    }
    
}
