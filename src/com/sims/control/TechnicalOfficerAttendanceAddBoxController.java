/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Attendance;
import com.sims.model.AttendanceDAO;
import com.sims.model.Session;
import com.sims.model.SessionDAO;
import com.sims.model.TechnicalOfficer;
import com.sims.model.TechnicalOfficerDAO;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author pragith
 */
public class TechnicalOfficerAttendanceAddBoxController implements Initializable {

    @FXML
    private TextField txtStudent;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox combCourseID;
    ObservableList<String> courselist=FXCollections.observableArrayList();
    
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnOk;
    @FXML
    private Pane pan2;
    @FXML
    private Pane pan1;
    @FXML
    private Spinner hours;
    @FXML
    private Spinner mins;
    @FXML
    private Button btnReset;

    
    
    
    TechnicalOfficerDAO technicalOfficerDAO = new TechnicalOfficerDAO();
    @FXML
    private TextField txtSessionid;
    @FXML
    private ComboBox combStatus;
    ObservableList<String> status=FXCollections.observableArrayList("Present","Absent");
    /**
     * 
     * 
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        ArrayList<TechnicalOfficer> cours;
        try {
            cours = technicalOfficerDAO.getCourseList("dpt02");
            for(TechnicalOfficer technicalOfficer : cours){
                courselist.add(technicalOfficer.getCourse());
            }
            combCourseID.setItems(courselist);
        } catch (SQLException ex) {
            Logger.getLogger(TechnicalOfficerMedicalsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        combStatus.setItems(status);
        
        
        SpinnerValueFactory<Integer> hours=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,24,8);
        this.hours.setValueFactory(hours);
        //time spinter minute
        SpinnerValueFactory<Integer> minutes=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
        mins.setValueFactory(minutes);
        
        
        
        
    }    

    @FXML
    private void getSessionIDActionController(ActionEvent event) {
       
        String dateTime, courseID,hour,min,dateNtime,id;

        courseID = (String) combCourseID.getValue();
        
        try {
            dateTime = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (NullPointerException x) {
            dateTime = "0";
        }
        
        if(((int) hours.getValue()<10)){
            hour="0"+String.valueOf(hours.getValue());
        }else{
            hour=String.valueOf(hours.getValue());
        }
        if(((int) mins.getValue()<10)){
            min="0"+String.valueOf(mins.getValue());
        }else{
            min=String.valueOf(mins.getValue());
        }
        dateNtime=dateTime+" "+hour+":"+min+":00";
        
        SessionDAO sessionDAO = new SessionDAO();
        System.out.println(dateNtime + courseID);
        //sessionDAO.viewSessionID(dateNtime, courseID);
        
        //Session session = new Session();
        id=sessionDAO.viewSessionID(dateTime, courseID);
        System.out.println(id);
//        String id=session.getSessionID();
//        lblSessionID.setText(id);
//        System.out.println(id);
        
        
    }

    @FXML
    private void addAttendanceActionController(ActionEvent event) {
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        
        Attendance attendance = new Attendance();
        
        String status,courseStatus;
        
        status=(String) combStatus.getValue();
        if (status=="Present"){
            courseStatus="1";
        }else{
            courseStatus="0";
        }
        
        attendance.setStudentID(txtStudent.getText());
        attendance.setSessionID(txtSessionid.getText());
        attendance.setAttendanceStatus(courseStatus);
        
        attendanceDAO.addAttendance(attendance);
        
        System.out.println(txtStudent.getText());
        System.out.println(txtSessionid.getText());
        System.out.println(courseStatus);
    }

    @FXML
    private void resetFormActionController(ActionEvent event) {
    }
    
}
