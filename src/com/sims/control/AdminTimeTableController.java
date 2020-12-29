/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.TimeTableDAO;
import com.sims.model.UserDAO;
import com.sims.util.DBConnectionUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AdminTimeTableController implements Initializable {

    @FXML
    private Button btn_choose;
    @FXML
    private Button btn_add;
    @FXML
    private ImageView Imageview;

    private File file =null;
    private Image image = null;
    private FileInputStream fis = null;

    TimeTableDAO tdao = new TimeTableDAO();
    @FXML
    private ImageView Imageview_select;
    @FXML
    private Button btn_select;
    @FXML
    private ComboBox<?> combo_select_sem;
    @FXML
    private ComboBox<?> combo_select_level;
    @FXML
    private Button btn_update;
    @FXML
    private ComboBox<?> combo_manage_sem;
    @FXML
    private ComboBox<?> comobo_manage_level;
    @FXML
    private Button btn_delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }
    
    private void gettimetable(int year,int sem){
        try {
            InputStream is = tdao.getTimeTable(year, sem);

            OutputStream os = new FileOutputStream(new File("photo.jpg"));

            byte[] content = new byte[5120];

            int size = 0;

            while ((size = is.read(content)) != -1) {
                os.write(content, 0, size);
            }

            os.close();
            is.close();

            Image image_ = new Image("file:photo.PNG");
            Imageview_select.setImage(image_);
        } catch (IOException ex) {
            Logger.getLogger(AdminTimeTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btn_chooseActionhandler(ActionEvent event) {
        FileChooser flc = new FileChooser();
        flc.setTitle("Choose Time Table");
        file = flc.showOpenDialog(null);

        image = new Image(file.toURI().toString());

        Imageview.setImage(image);
    }

    @FXML
    private void btn_addActionhandler(ActionEvent event) throws FileNotFoundException, IOException {
        
        fis = new FileInputStream(file);

        if (tdao.setTimeTable(1, 2, fis, (int) file.length())) {
            System.out.println("File Done");
        } else {
            System.out.println("File error");
        }
        fis.close();
        file = null;
        gettimetable(1,2);

    }

    @FXML
    private void btn_updateActionhandler(ActionEvent event) throws FileNotFoundException {
        fis = new FileInputStream(file);

        if (tdao.updateTimeTable(1, 2, fis, (int) file.length())) {
            System.out.println("File Update Done");
        } else {
            System.out.println("File update error");
        }
        
        image = new Image(file.toURI().toString());

        Imageview_select.setImage(image);
    }

    @FXML
    private void btn_selectActionhandler(ActionEvent event) {
        gettimetable(1,2);
    }

    @FXML
    private void btn_deleteActionhandler(ActionEvent event) {
        if (tdao.delteTimeTable(1, 2)) {
                System.out.println(" Succesfully deleted");
                Imageview.setImage(null);
                Imageview_select.setImage(null);
            } else {
                System.out.println(" delete Error");
            }
    }

}
