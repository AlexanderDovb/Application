package com.example.app.model;

public class Courses {

  private int courseId;
  private String courseName;
  private String duration;
  private int freePlaces;

  public Courses(){
  }

  public Courses(int courseId, String courseName, String duration, int freePlaces) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.duration = duration;
    this.freePlaces = freePlaces;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public int getFreePlaces() {
    return freePlaces;
  }

  public void setFreePlaces(int freePlaces) {
    this.freePlaces = freePlaces;
  }
}
