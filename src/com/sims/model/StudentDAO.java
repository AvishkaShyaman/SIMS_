/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sims.model;

import com.sims.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class StudentDAO extends UserDAO {

    public boolean saveStudent(Student student) {
        boolean value = false;

        if (saveUser(student)) {
            try {
                Connection con = DBConnectionUtil.getDBConnection();

                pst = con.prepareStatement("insert into student values(?,?,?,?);");
                pst.setString(1, student.getUserID());
                pst.setInt(2, student.getYear());
                pst.setInt(3, student.getSemester());
                pst.setString(4, student.getDepartment());

                if (pst.executeUpdate() >= 1) {
                    value = true;
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return value;
    }

    public boolean updateStudent(Student student) {
        boolean value = false;

        try {
            updateUser(student);

            Connection con = DBConnectionUtil.getDBConnection();

            pst = con.prepareStatement("update student set year=2,semester=2,stnd_dpt='dpt03' where studentid='id';");
            pst.setString(4, student.getUserID());
            pst.setInt(1, student.getYear());
            pst.setInt(2, student.getSemester());
            pst.setString(3, student.getDepartment());

            if (pst.executeUpdate() >= 1) {
                value = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

    public boolean deleteStudent(Student user) {
        boolean value = false;
        try {
            Connection con = DBConnectionUtil.getDBConnection();

            pst = con.prepareStatement("delete from student where studentid=?;");
            pst.setString(1, user.getUserID());

            if (pst.executeUpdate() >= 1) {

                deleteUser(user);
                value = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

    public Student getStudent(String userid) {
        Student student = new Student();
        User user = getUser(userid);

        student.setUserID(user.getUserID());
        student.setFirstName(user.getFirstName());
        student.setLastname(user.getLastname());
        student.setUsernic(user.getUsernic());
        student.setPhone(user.getPhone());
        student.setEmail(user.getEmail());
        student.setAddress(user.getAddress());
        student.setDob(user.getDob());
        student.setGender(user.getGender());
        try {
            Connection con = DBConnectionUtil.getDBConnection();

            pst = con.prepareStatement("select * from student where studentid=?;", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, userid);

            rs = pst.executeQuery();

            if (rs.first()) {
                student.setYear(rs.getInt(2));
                student.setSemester(rs.getInt(3));
                student.setDepartment(rs.getString(4));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return student;
    }
}
