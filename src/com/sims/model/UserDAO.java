/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.model;

import com.sims.util.DBConnectionUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class UserDAO {
    
    private int num;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean verifyPassword(String username,String pwd){
        boolean valid = false;
        String password,quary;
        
        try {
            Connection con = DBConnectionUtil.getDBConnection();
            
            quary = "select password from login where username=?;";
            
            pst = con.prepareStatement(quary,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, username);
            
            rs = pst.executeQuery();
            
            if(rs.first()){
                password = rs.getString(1);
                
                valid = password.equals(pwd);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }
    
    public String verifyUserName(String username){
        String userid = null;
        try {
            Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("select log_userid from login where username=?;",ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, username);
            
            rs = pst.executeQuery();
            
            if(rs.first()){
                userid = rs.getString(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return userid;
    }
    
    public String getUserType(String userid){
        String type = null;
        try {
            Connection con = DBConnectionUtil.getDBConnection();
            
            pst = con.prepareStatement("select st_job_type from staf where stfid=?",ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, userid);
            
            rs = pst.executeQuery();
            
            if(rs.first()){
                type = rs.getString(1);
            } else {
                type = "student";
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return type;
    }
    
}
