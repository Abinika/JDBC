package com.projectname.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.projectname.dao.DatabaseConnection;
import com.projectname.model.Student;
import com.projectname.service.StudentDao;





public abstract class StudentsData implements StudentDao {

    Connection con = DatabaseConnection.getConnections();

    @Override
    public void save(Student s) {
        try {
            if (s.getName() != null) {
                PreparedStatement pstm = con.prepareStatement("insert into studentsinfo(RollNo,Name,Age,Department) values(?,?,?,?)");
                pstm.setInt(1, s.getRollNo());
                pstm.setString(2, s.getName());
                pstm.setInt(3, s.getAge());
                pstm.setString(4, s.getDepartment());
                int i = pstm.executeUpdate();
                System.out.println(i + " Data Inserted Successfully");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Student s) {
        try {
            if (s.getAge() != 0) {
                PreparedStatement pstm = con.prepareStatement("update studentsinfo set name=? where A=?");
                pstm.setString(1, s.getName());
                pstm.setInt(2, s.getAge());
                int i = pstm.executeUpdate();
                System.out.println(i + " Data Updated Successfully");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(int RollNo) {
        try {
            if (RollNo != 0) {
                PreparedStatement pstm = con.prepareStatement("delete from student where id=?");
                pstm.setInt(1, RollNo);
                int i = pstm.executeUpdate();
                System.out.println(i + " Data Deleted Successfully");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public Student getStudent(int id) {
        Student student = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from student where id=?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                 student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                student = new Student( id, null, id, null);
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
            }

        } catch (Exception e) {
        }
        return student;
    }

}
