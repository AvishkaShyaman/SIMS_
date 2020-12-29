/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Student;
import com.sims.model.StudentDAO;
import com.sims.model.TimeTableDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author PC PLUS
 */
public class StudentMedicalsController implements Initializable {

    @FXML
    private VBox notice_vbox;
    
    private Student student;
    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> colno;
    @FXML
    private TableColumn<?, ?> colcoursecode;
    @FXML
    private TableColumn<?, ?> coldate;
    @FXML
    private TableColumn<?, ?> coltype;
    @FXML
    private TableColumn<?, ?> colhours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            TimeTableDAO tdao = new TimeTableDAO();
//            
//            InputStream is = tdao.getTimeTable(student.getYear(), student.getSemester());
//
//            OutputStream os = new FileOutputStream(new File("photo.jpg"));
//
//            byte[] content = new byte[5120];
//
//            int size = 0;
//
//            while ((size = is.read(content)) != -1) {
//                os.write(content, 0, size);
//            }
//
//            os.close();
//            is.close();
//
//            Image image_ = new Image("file:photo.PNG");
//            imageview.setImage(image_);
//        } catch (IOException ex) {
//            Logger.getLogger(AdminTimeTableController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
}
