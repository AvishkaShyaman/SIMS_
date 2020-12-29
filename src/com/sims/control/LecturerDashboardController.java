/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.control;

import com.sims.model.Notice;
import com.sims.model.NoticeDOA;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class LecturerDashboardController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private Button btn_notice;
    @FXML
    private Button btn_course;
    @FXML
    private Button btn_exam;
    @FXML
    private Button btn_student;
    @FXML
    private VBox notice_vbox;
    @FXML
    private DatePicker cmb_date;
    @FXML
    private Button btn_Search;
    @FXML
    private TableView<Notice> table_view;
    @FXML
    private TableColumn<Notice, String> tale_col_date;
    @FXML
    private TableColumn<Notice, String> table_col_titel;
    @FXML
    private TableColumn<Notice, String> table_col_publisher;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btn_SignOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setNoticeTable();
    }

    @FXML
    private void btn_noticeActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_courseActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_examActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_studentActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_SearchActionPerformed(ActionEvent event) {
    }

    private void setNoticeTable() {
        ObservableList<Notice> obslist = FXCollections.observableArrayList();

        NoticeDOA dao = new NoticeDOA();
        ArrayList<Notice> notices = dao.getAllNotice();

        for (Notice notice : notices) {
            obslist.add(notice);
            System.out.println(notice.getID() + " " + notice.getTitle() + " " + notice.getPublisher());
        }

        tale_col_date.setCellValueFactory(new PropertyValueFactory<>("ID"));
        table_col_titel.setCellValueFactory(new PropertyValueFactory<>("title"));
        table_col_publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        table_view.setItems(obslist);
    }

    @FXML
    private void btn_ProfileActionHandel(ActionEvent event) {
    }

    @FXML
    private void btn_SignOutActionHandel(ActionEvent event) {
    }
}
