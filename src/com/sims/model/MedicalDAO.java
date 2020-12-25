/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.model;

import com.sims.util.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pragith
 */
public class MedicalDAO {
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    /*public boolean addMedical(Medical medical){
        boolean value=true;
        String query1;
        String sessionid=null;
        try{
            Connection con = DBConnectionUtil.getDBConnection();
            
            query1="select sessionid from session where courseid=? and date_time=? type=?;";
            pst = con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            pst.setString(1, medical.getCourseID());
            pst.setString(2, medical.getDate());
            pst.setString(3, medical.getCourseType());
            
            rs=pst.executeQuery();
            while (rs.next()){
                sessionid=rs.getString(1);
            }
            
            pst = con.prepareStatement("insert into medical values(?,?,?,?,?,?,?);");
            pst.setString(1, medical.getMedicalRefNo());
            pst.setString(2, medical.getStudentID());
            pst.setString(3, sessionid);
            pst.setString(4, medical.getMedicalSubmitDate());
            pst.setString(5, medical.getMedicalStartDate());
            pst.setString(6, medical.getMedicalEndDate());
            pst.setString(7, medical.getMedicalStatus());
        
            if(pst.executeUpdate()>=1){
                value=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return value;
    
    }*/
    
    
    public boolean addMedical(Medical medical){
        boolean value=true;
        
        try{
            Connection con = DBConnectionUtil.getDBConnection();
            
            
            pst = con.prepareStatement("insert into medical values(?,?,?,?,?,?,?);");
            pst.setString(1, medical.getMedicalRefNo());
            pst.setString(2, medical.getStudentID());
            //pst.setString(3, sessionid);
            pst.setString(4, medical.getMedicalSubmitDate());
            pst.setString(5, medical.getMedicalStartDate());
            pst.setString(6, medical.getMedicalEndDate());
            pst.setString(7, medical.getMedicalStatus());
        
            if(pst.executeUpdate()>=1){
                value=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return value;
    
    }
    
    
    
    public boolean addMedicalCourseModule(Medical medical){
        boolean value=true;
        try{
            Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("insert into medical values(?,?,?,?,?);");
            pst.setString(1, medical.getStudentID());
            pst.setString(2, medical.getMedicalRefNo());
            pst.setString(3, medical.getCourseID());
            pst.setString(4, medical.getDate());
            pst.setString(5, medical.getType());
        
            if(pst.executeUpdate()>=1){
                value=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return value;
    
    }    
    
    
    public boolean updateMedical(Medical medical){
        boolean value=true;
        
        try{
            Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("update medical set med_status=? where med_refno=? and med_st_id=? ;");
            
            pst.setString(1, medical.getMedicalStatus());
            pst.setString(2, medical.getMedicalRefNo());
            pst.setString(3, medical.getStudentID());
        
            if(pst.executeUpdate()>=1){
                value=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return value;
    
    }   
    
    
    public Medical viewMedical(String studentID, String courseID){
        Medical medical=null;
        try{
            Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("select * from medical_course_module where mcm_st_id=? and mcm_courseID=?;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            pst.setString(1, studentID);
            pst.setString(2, courseID);
            
            rs=pst.executeQuery();
        
            while(rs.next()){
                medical = new Medical();
            
                medical.setStudentID(rs.getString(1));
                medical.setMedicalRefNo(rs.getString(2));
                medical.setCourseID(rs.getString(3));
                medical.setDate(rs.getString(4));
                medical.setType(rs.getString(5));
               
                
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return medical;
    
    } 
    
    
    public ArrayList<Medical>viewAllStudentMedical(String courseID,String dateTime){
        ArrayList<Medical> medicallist=new ArrayList<Medical>();
        
         try {
            Connection con = DBConnectionUtil.getDBConnection();

            pst = con.prepareStatement("select * from medical_course_module where mcm_courseid=? and mcm_date_time=?;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, courseID);
            pst.setString(2, dateTime);
            
            rs=pst.executeQuery();

            if (rs.first()) {
                Medical medical=new Medical();
                
                medical.setStudentID(rs.getString(1));
                medical.setMedicalRefNo(rs.getString(2));
                medical.setCourseID(rs.getString(3));
                medical.setDate(rs.getString(4));
                medical.setType(rs.getString(5));
                
                medicallist.add(medical);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return medicallist;
        
    }    
    
    
    
   

    
    
    
}


