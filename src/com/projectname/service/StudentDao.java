package com.projectname.service;

import java.util.List;

import com.projectname.model.Student;

public interface StudentDao {

        public void save(Student s);
        public void update(Student s);
        public void delete(int RollNo);
        public Student getStudent(int RollNo);
        public List<Student> getStudents();
    }
