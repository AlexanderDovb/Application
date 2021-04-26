package com.example.app.dao.row_maper;

import com.example.app.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

  @Override
  public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

    Student student = new Student();
    student.setId(rs.getInt("idst"));
    student.setName(rs.getString("namest"));
    student.setSurname(rs.getString("surnamest"));
    student.setAge(rs.getInt("agest"));

    return student;
  }
}
