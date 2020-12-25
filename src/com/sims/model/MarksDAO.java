/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.model;

import com.sims.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Helanka
 */
public class MarksDAO {
    
    ExamDAO examDAO = new ExamDAO();
 
    
    //Insert Marks into marks table(LecturerExam)
    public boolean insertMarks(String courseId, String examType, String studentId, float marks) {
        
        Connection con = null;
        boolean status = false;
         
        try {
            String[] dataRow = examDAO.getExam(courseId, examType);
            
            con = DBConnectionUtil.getDBConnection();
            
            
            String insertMarks = "INSERT INTO marks (marks_st_id, marks_examid, mark) VALUES ( ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(insertMarks, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, dataRow[0]);
            preparedStatement.setFloat(3, marks);
            int i = preparedStatement.executeUpdate();
            
            if (i == 1) {
                System.out.println("A Marks record has inserted successfully");
                status = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return status;
    }
    
    //Get Mark from marks table according to the given Student ID(LecturerStuMarks) +getMarkForAStudent()
    public String[] getMarks(String courseId, String examType, String studentId) {
        
        Connection con = null;
        String[] dataRow = new String[4];
        
        try {
            
            con = DBConnectionUtil.getDBConnection();
            
            String[] examRow = examDAO.getExam(courseId, examType);
            
            String getMarkForAStudent = "SELECT * FROM marks WHERE marks_st_id = ? AND marks_examid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(getMarkForAStudent);
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, examRow[0]);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                dataRow[0] = examRow[3];
                dataRow[1] = examRow[1];
                dataRow[2] = resultSet.getString(1);
                dataRow[3] = resultSet.getString(3);
                
                System.out.println(dataRow[0] + ", " + dataRow[1] + ", " + dataRow[2]  + ", " + dataRow[3]);
            } else {
                dataRow[0] = "";
                dataRow[1] = "";
                dataRow[2] = "";
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataRow;
    }
    
    //Get Marks from marks table according to the given Course ID and Exam Type(LecturerStuMarks)
    public  String[][] getMarks(String courseId, String examType) {
        
        String[][] dataRow = null;
        Connection con = null;
        
        try {
            
            con = DBConnectionUtil.getDBConnection();
            
            String[] examRow = examDAO.getExam(courseId, examType);
            
            int rowIndex = 0;
            
            String rowcount = "SELECT count(marks_examid) FROM marks WHERE marks_examid = ?";
            PreparedStatement ps = con.prepareStatement(rowcount);
            ps.setString(1, examRow[0]);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            dataRow = new String[rowCount][3];
            
            String getMarks = "SELECT * FROM marks WHERE marks_examid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(getMarks);
            preparedStatement.setString(1, examRow[0]);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                dataRow[rowIndex][0] = examRow[3];
                dataRow[rowIndex][1] = examRow[1];
                dataRow[rowIndex][2] = resultSet.getString(1);
                dataRow[rowIndex][3] = resultSet.getString(3);
                
                System.out.println(dataRow[rowIndex][0] + ", " + dataRow[rowIndex][1] + ", " + dataRow[rowIndex][2] + ", " + dataRow[rowIndex][3]);
                
                rowIndex++;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return dataRow;
    }
    
    //Get All Marks from marks table(LecturerStuMarks) +getAllMarks()
    public  String[][] getMarks() { 
    
        String[][] dataRow = null;
        Connection con = null;
        
        try {
            
            
            con  = DBConnectionUtil.getDBConnection();
            
            int rowIndex = 0;
            
            String[][] examRow = examDAO.getExam();
            
            String rowcount = "SELECT count(marks_examid) FROM marks";
            PreparedStatement ps = con.prepareStatement(rowcount);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            dataRow = new String[rowCount][4];
            
            String getAllMarks = "SELECT * FROM marks";
            PreparedStatement preparedStatement = con.prepareStatement(getAllMarks);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                dataRow[rowIndex][0] = examRow[rowIndex][3];
                dataRow[rowIndex][1] = examRow[rowIndex][1];
                dataRow[rowIndex][2] = resultSet.getString(1);
                dataRow[rowIndex][3] = resultSet.getString(3);
                
                System.out.println(dataRow[rowIndex][0] + ", " + dataRow[rowIndex][1] + ", " + dataRow[rowIndex][2] + ", " + dataRow[rowIndex][3]);
                
                rowIndex++;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return dataRow;
    }
    
    //Update Marks in marks table(LecturerExam)
    public  int updateMarks(String courseId, String examType, String studentId, float marks) {
    
        int status = 0;
        
        Connection con = null;
        
        try {
            
            
            con = DBConnectionUtil.getDBConnection();
            
            String[] examRow = examDAO.getExam(courseId, examType);
            
            String updateMarks = "UPDATE marks SET mark = ? WHERE marks_examid = ? AND marks_st_id = ?";
            PreparedStatement preparedStatement  = con.prepareStatement(updateMarks);
            preparedStatement.setFloat(1, marks);
            preparedStatement.setString(2, examRow[0]);
            preparedStatement.setString(3, studentId);
            int i = preparedStatement.executeUpdate();
            
            if (i == 1) {
                System.out.println("A Marks record has updated successfully");
                status = 1;
            } else {
                System.out.println("Error in updating record");
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return status;
    }
    
    //Delete Marks from marks table according to the given Student ID(LecturerExam)
    public boolean deleteMarks(String courseId, String examType, String studentId) {
        
        boolean status = false;
        
        Connection con = null;
        
        try {
            
            
            
            con = DBConnectionUtil.getDBConnection();
            
            String[] examRow = examDAO.getExam(courseId, examType);
            
            String deleteMarks = "DELETE FROM mark WHERE marks_st_id = ? AND marks_examid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(deleteMarks);
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(1, examRow[0]);
            int i = preparedStatement.executeUpdate();
            
            if (i == 1) {
                System.out.println("A Marks record has deleted successfully");
                status = true;
            } else {
                System.out.println("Error in deleting record");
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MarksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        return status;
    }
    
    
    
    
    
}
