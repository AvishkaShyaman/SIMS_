/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.model;

import com.sims.util.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pragith
 */
public class AttendanceDAO {
    PreparedStatement pst;
    ResultSet rs;
    

    
    public boolean addAttendance(Attendance attendance){
        boolean value=false;
        String query1,query2,sessionid=null;
        
        try {
            Connection con = DBConnectionUtil.getDBConnection();
            
            query1="select sessionid from session where courseid=? and type=? and date_time=?;";
            pst = con.prepareStatement(query1);
            pst.setString(1, attendance.getCourseID());
            pst.setString(2, attendance.getSessionType());
            pst.setString(3, attendance.getDateTime());
            rs=pst.executeQuery();
            
            while(rs.next()){
                sessionid=rs.getString(1);
            }
            
            query2="insert into attendance values(?,?,?);";
            pst = con.prepareStatement(query2);
            pst.setString(1, attendance.getStudentID());
            pst.setString(2, sessionid);
            pst.setString(3, attendance.getAttendanceStatus());
            
            if(pst.executeUpdate()>=1){
                value=true;
            }
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return value;
    }
    
    

    
    public boolean updateAttendance(Attendance attendance){
        boolean value = false;
        String query;
        try {
            Connection con = DBConnectionUtil.getDBConnection();
            
            query="UPDATE attendance SET state=? WHERE at_st_id=? AND at_sessionid=?;";
            pst = con.prepareStatement(query);
            pst.setString(1, attendance.getAttendanceStatus());
            pst.setString(2, attendance.getStudentID());
            pst.setString(3, attendance.getSessionType());
            
            if(pst.executeUpdate()>=1){
                value=true;
            }
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    

    
      //public Attendance getAttendance(String studentID,String courseID,String courseType,String dateTime,int attendanceState){
      
      

    public Attendance getAttendance(String studentID,String courseID,String state,String type){
        String query;
        float totalhours=0;
        Attendance attendance=null;
    
        try {
            Connection con = DBConnectionUtil.getDBConnection();
            //query1="select sessionid from session where courseid=?  and type=?;";
            query="select attendance.at_st_id, attendance.state, session.courseid, session.hours from session FULL OUTER JOIN attendance ON attendance.at_sessionid=session.sessionid  where session.courseid=?  and session.type=? and attendance.state=? and attendance.at_st_id=?;";
            
            pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    
            pst.setString(1, courseID);
            pst.setString(2, type);
            pst.setString(3, state);
            pst.setString(4, studentID);
            
            rs=pst.executeQuery();

            
            while(rs.next()){
                 attendance = new Attendance();
        
                 
                 attendance.setStudentID(rs.getString(1));
                 attendance.setAttendanceStatus(rs.getString(2));
                 attendance.setSessionType(rs.getString(3));
                 totalhours+=rs.getFloat(4);
            }
            attendance.setTotalHours(totalhours);
            
            
    
     } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attendance;
    }
      
      
      
      
      

    
    public  ArrayList<Attendance> getAllStudentAttendance(String courseID, String dateTime,String state,String type) {
        String query1,query2;
        String sessionID=null;
        
        
        ArrayList<Attendance> attendancelist = new ArrayList<Attendance>();
        try {
            Connection con = DBConnectionUtil.getDBConnection();

            
            query1="select sessionid from session where courseid=? and date_time=? and type=?;";
            pst = con.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    
            pst.setString(1, courseID);
            pst.setString(2, dateTime);
            pst.setString(3, type);
            
            rs=pst.executeQuery();
            while(rs.next()){
                sessionID=rs.getString(1);
            }
               
            
            query2="select * from attendance where at_sessionid=? and state=?;";
            pst = con.prepareStatement(query2, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            pst.setString(1, sessionID);
            pst.setString(2, state);
            
            rs=pst.executeQuery();
            
            if(rs.first()){
                Attendance attendance=new Attendance();
                
                attendance.setStudentID(rs.getString(1));
                attendance.setAttendanceStatus(rs.getString(3));
            
                attendancelist.add(attendance);
            }
           

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attendancelist;
    }
   
   
      
      
      
      
      
    
}
