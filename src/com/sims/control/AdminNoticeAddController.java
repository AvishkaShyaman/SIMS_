/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Notice;
import com.sims.model.NoticeDOA;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AdminNoticeAddController implements Initializable {

    @FXML
    private TextField txt_notice_title;
    @FXML
    private TextArea txt_notice_content;
    @FXML
    private Button btn_notice_add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_notice_addActionhandel(ActionEvent event) {
        Notice notice = new Notice();
        
        notice.setID("notice01");
        notice.setTitle(txt_notice_title.getText());
        notice.setContent(txt_notice_content.getText());
        notice.setPublisher("Admin");
        
        NoticeDOA noticedoa = new NoticeDOA();
        
        if(noticedoa.saveNotice(notice)){
            System.out.println("Add");
        } else {
            System.out.println("Error");
        }
    }
    
}
