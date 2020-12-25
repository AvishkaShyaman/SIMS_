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
 * @author pragith
 */
public class SessionDAO {
    
    PreparedStatement pst;
    ResultSet rs;

    
    public boolean setSession(Session session){
        boolean value=false;
        try {
            
            
            Connection con = DBConnectionUtil.getDBConnection();
            
            
            
            pst = con.prepareStatement("insert into session values(?,?,?,?,?);");
            
            pst.setString(1, session.getSessionID());
            pst.setFloat(2, session.getHours());
            pst.setString(3, session.getType());
            pst.setString(4, session.getDateTime());
            pst.setString(5, session.getCourseID());
           

            if (pst.executeUpdate() >= 1) {
                value = true;
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        return value;
    
 
    }
    



    public Session getSession(String courseID){
        Session session=null;
        try {
           Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("select * from session where courseid=?;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            pst.setString(1, courseID);
            
            rs=pst.executeQuery();
            
            while(rs.next()){
           
                session=new Session();
                
                session.setCourseID(rs.getString(1));
                session.setHours(rs.getFloat(2));
                session.setType(rs.getString(3));
                session.setDateTime(rs.getString(4));
                session.setCourseID(rs.getString(5));

            }

            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        return session;
    
 
    }
    
    
    public float getTotalHours(String courseID){
        float total=0;
        try {
           Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("select hours from session where courseid=?;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            pst.setString(1, courseID);
            
            rs=pst.executeQuery();
            
            while(rs.next()){

                total+=rs.getFloat(2);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return total;
    
 
    }
    
    
    
    
    
    
    
}