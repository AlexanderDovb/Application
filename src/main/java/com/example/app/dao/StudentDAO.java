package com.example.app.dao;

import com.example.app.model.Student;

import java.util.List;

public interface StudentDAO {

  public List<Student> list();

  public void addStudent(Student student);

  public void deleteStudent(int id);

  public void editStudent(Student student);

 public Student getStudent(int id);

}
