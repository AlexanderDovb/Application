package com.example.app.dao;

import com.example.app.model.Courses;

import java.util.List;

public interface CoursesDAO {

  public List<Courses> list();

  public List<Courses> coursesList(int id);

  public void addCoursesToStudent(int studentId, int courseId);

  public void removeCoursesFromStudent(int courseId, int studentId );

  public Courses getCourse(int id);

}
